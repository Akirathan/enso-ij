// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EnsoArgumentDef extends PsiElement {

  @Nullable
  EnsoDefaultValue getDefaultValue();

  @NotNull
  EnsoIdentifierRule getIdentifierRule();

  @Nullable
  EnsoTypeAscription getTypeAscription();

}
