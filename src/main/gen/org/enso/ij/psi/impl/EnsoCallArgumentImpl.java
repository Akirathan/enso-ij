// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.enso.ij.psi.EnsoTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.enso.ij.psi.*;

public class EnsoCallArgumentImpl extends ASTWrapperPsiElement implements EnsoCallArgument {

  public EnsoCallArgumentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EnsoVisitor visitor) {
    visitor.visitCallArgument(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EnsoVisitor) accept((EnsoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public EnsoCallArgument getCallArgument() {
    return findChildByClass(EnsoCallArgument.class);
  }

  @Override
  @Nullable
  public EnsoLiteral getLiteral() {
    return findChildByClass(EnsoLiteral.class);
  }

  @Override
  @Nullable
  public EnsoMethodCall getMethodCall() {
    return findChildByClass(EnsoMethodCall.class);
  }

}
