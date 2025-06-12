package org.enso.ij.psi;

import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface EnsoNamedElement extends PsiNameIdentifierOwner {

  @Override
  default @Nullable PsiElement getNameIdentifier() {
    return null;
  }

  @Override
  default PsiElement setName(@NotNull String name) throws IncorrectOperationException {
    return null;
  }
}
