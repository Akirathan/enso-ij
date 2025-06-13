// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EnsoMethod extends PsiElement {

  @NotNull
  List<EnsoArgumentDef> getArgumentDefList();

  @NotNull
  EnsoIdentifierRule getIdentifierRule();

  @NotNull
  EnsoMethodBody getMethodBody();

}
