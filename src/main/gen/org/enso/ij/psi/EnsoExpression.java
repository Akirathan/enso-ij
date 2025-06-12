// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EnsoExpression extends PsiElement {

  @Nullable
  EnsoAssignment getAssignment();

  @Nullable
  EnsoBinaryOp getBinaryOp();

  @Nullable
  EnsoEolWithComment getEolWithComment();

  @Nullable
  EnsoExpression getExpression();

  @Nullable
  EnsoLiteral getLiteral();

  @Nullable
  EnsoMethodCall getMethodCall();

}
