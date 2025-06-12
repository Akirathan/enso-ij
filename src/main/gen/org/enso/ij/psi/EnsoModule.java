// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EnsoModule extends PsiElement {

  @NotNull
  List<EnsoBinding> getBindingList();

  @NotNull
  List<EnsoExportRule> getExportRuleList();

  @NotNull
  List<EnsoFromExport> getFromExportList();

  @NotNull
  List<EnsoFromImport> getFromImportList();

  @NotNull
  List<EnsoImportRule> getImportRuleList();

}
