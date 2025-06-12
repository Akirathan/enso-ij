package org.enso.ij;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class EnsoFile extends PsiFileBase {

  public EnsoFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, EnsoLanguage.INSTANCE);
  }

  @Override
  public @NotNull FileType getFileType() {
    return EnsoFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Enso file";
  }
}
