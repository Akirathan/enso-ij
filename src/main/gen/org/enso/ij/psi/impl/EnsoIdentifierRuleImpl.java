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
import com.intellij.util.IncorrectOperationException;

public class EnsoIdentifierRuleImpl extends ASTWrapperPsiElement implements EnsoIdentifierRule {

  public EnsoIdentifierRuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EnsoVisitor visitor) {
    visitor.visitIdentifierRule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EnsoVisitor) accept((EnsoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

  @Override
  public String getName() {
    return EnsoPsiUtil.getName(this);
  }

  @Override
  public PsiElement setName(String name) throws IncorrectOperationException {
    return EnsoPsiUtil.setName(this, name);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return EnsoPsiUtil.getNameIdentifier(this);
  }

}
