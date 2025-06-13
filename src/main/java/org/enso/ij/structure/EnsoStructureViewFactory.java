package org.enso.ij.structure;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EnsoStructureViewFactory implements PsiStructureViewFactory {

  @Override
  public @Nullable StructureViewBuilder getStructureViewBuilder(@NotNull PsiFile psiFile) {
    return new TreeBasedStructureViewBuilder() {
      @Override
      public @NotNull StructureViewModel createStructureViewModel(@Nullable Editor editor) {
        return new EnsoStructureViewModel(psiFile, editor);
      }
    };
  }
}
