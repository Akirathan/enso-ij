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

public class EnsoFromExportImpl extends ASTWrapperPsiElement implements EnsoFromExport {

  public EnsoFromExportImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EnsoVisitor visitor) {
    visitor.visitFromExport(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EnsoVisitor) accept((EnsoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public EnsoFullyQualifiedName getFullyQualifiedName() {
    return findNotNullChildByClass(EnsoFullyQualifiedName.class);
  }

  @Override
  @NotNull
  public List<EnsoIdentifierRule> getIdentifierRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnsoIdentifierRule.class);
  }

}
