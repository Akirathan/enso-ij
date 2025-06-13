// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;

public interface EnsoIdentifier extends EnsoNamedElement {

  @NotNull
  PsiElement getIdentifier();

  String getName();

  PsiElement setName(String name) throws IncorrectOperationException;

  PsiElement getNameIdentifier();

}
