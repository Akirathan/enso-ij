// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EnsoBinaryOp extends PsiElement {

  @NotNull
  List<EnsoIdOrLiteral> getIdOrLiteralList();

  @NotNull
  EnsoOperator getOperator();

}
