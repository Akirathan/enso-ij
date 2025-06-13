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

public class EnsoArgumentDefImpl extends ASTWrapperPsiElement implements EnsoArgumentDef {

  public EnsoArgumentDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EnsoVisitor visitor) {
    visitor.visitArgumentDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EnsoVisitor) accept((EnsoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public EnsoDefaultValue getDefaultValue() {
    return findChildByClass(EnsoDefaultValue.class);
  }

  @Override
  @NotNull
  public EnsoIdentifierRule getIdentifierRule() {
    return findNotNullChildByClass(EnsoIdentifierRule.class);
  }

  @Override
  @Nullable
  public EnsoTypeAscription getTypeAscription() {
    return findChildByClass(EnsoTypeAscription.class);
  }

}
