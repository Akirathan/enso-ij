package org.enso.ij.psi;

import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;

public final class EnsoPsiUtil {
  public static String getName(EnsoIdentifier identifier) {
    return identifier.getIdentifier().getText();
  }

  public static PsiElement getNameIdentifier(EnsoIdentifier identifier) {
    return identifier.getIdentifier();
  }

  public static PsiElement setName(EnsoIdentifier identifier, String name) throws IncorrectOperationException {
    // TODO
    throw new UnsupportedOperationException("unimplemented");
  }

  public static String getName(EnsoIdentifierRule identifierRule) {
    return identifierRule.getIdentifier().getText();
  }

  public static PsiElement getNameIdentifier(EnsoIdentifierRule identifierRule) {
    return identifierRule.getIdentifier();
  }

  public static PsiElement setName(EnsoIdentifierRule identifierRule, String name) throws IncorrectOperationException {
    // TODO
    throw new UnsupportedOperationException("unimplemented");
  }
}
