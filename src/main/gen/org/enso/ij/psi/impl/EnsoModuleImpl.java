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

public class EnsoModuleImpl extends ASTWrapperPsiElement implements EnsoModule {

  public EnsoModuleImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull EnsoVisitor visitor) {
    visitor.visitModule(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof EnsoVisitor) accept((EnsoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<EnsoBinding> getBindingList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnsoBinding.class);
  }

  @Override
  @NotNull
  public List<EnsoEolWithComment> getEolWithCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnsoEolWithComment.class);
  }

  @Override
  @NotNull
  public List<EnsoExportRule> getExportRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnsoExportRule.class);
  }

  @Override
  @NotNull
  public List<EnsoFromExport> getFromExportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnsoFromExport.class);
  }

  @Override
  @NotNull
  public List<EnsoFromImport> getFromImportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnsoFromImport.class);
  }

  @Override
  @NotNull
  public List<EnsoImportRule> getImportRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, EnsoImportRule.class);
  }

}
