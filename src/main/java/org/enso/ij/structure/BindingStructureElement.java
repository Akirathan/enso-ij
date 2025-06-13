package org.enso.ij.structure;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import org.enso.ij.psi.EnsoBinding;
import org.jetbrains.annotations.NotNull;

final class BindingStructureElement implements StructureViewTreeElement {

  private final EnsoBinding binding;

  BindingStructureElement(EnsoBinding binding) {
    this.binding = binding;
  }

  @Override
  public Object getValue() {
    return binding;
  }

  @Override
  public @NotNull ItemPresentation getPresentation() {
    var methodName = binding.getMethod().getIdentifierRule().getIdentifier();
    return new PresentationData();
  }

  @Override
  public TreeElement @NotNull [] getChildren() {
    return new TreeElement[0];
  }
}
