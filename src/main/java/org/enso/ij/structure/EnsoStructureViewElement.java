package org.enso.ij.structure;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.ArrayList;
import org.enso.ij.EnsoFile;
import org.enso.ij.psi.EnsoBinding;
import org.enso.ij.psi.EnsoModule;
import org.enso.ij.psi.EnsoTypes;
import org.enso.ij.psi.impl.EnsoBindingImpl;
import org.jetbrains.annotations.NotNull;

public final class EnsoStructureViewElement implements StructureViewTreeElement,
    SortableTreeElement {

  private static final TreeElement[] EMPTY_ARRAY = new TreeElement[0];
  private final NavigatablePsiElement element;

  public EnsoStructureViewElement(NavigatablePsiElement element) {
    this.element = element;
  }

  @Override
  public Object getValue() {
    return element;
  }

  @Override
  public void navigate(boolean requestFocus) {
    element.navigate(requestFocus);
  }

  @Override
  public boolean canNavigate() {
    return element.canNavigate();
  }

  @Override
  public boolean canNavigateToSource() {
    return element.canNavigateToSource();
  }

  @Override
  public @NotNull String getAlphaSortKey() {
    var name = element.getName();
    return name != null ? name : "";
  }

  @Override
  public @NotNull ItemPresentation getPresentation() {
    var presentation = element.getPresentation();
    return presentation != null ? presentation : new PresentationData();
  }

  @Override
  public TreeElement @NotNull [] getChildren() {
    if (element instanceof EnsoFile ensoFile) {
      var module = PsiTreeUtil.getChildOfType(ensoFile, EnsoModule.class);
      assert module != null;
      var bindings = PsiTreeUtil.getChildrenOfTypeAsList(module, EnsoBinding.class);
      var treeElements = new ArrayList<TreeElement>();
      for (var binding : bindings) {
        treeElements.add(
            new EnsoStructureViewElement((EnsoBindingImpl) binding)
        );
      }
      return treeElements.toArray(new TreeElement[0]);
    }
    return EMPTY_ARRAY;
  }
}
