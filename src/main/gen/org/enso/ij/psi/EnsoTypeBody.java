// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface EnsoTypeBody extends PsiElement {

  @NotNull
  List<EnsoMethod> getMethodList();

  @NotNull
  List<EnsoTypeConstructor> getTypeConstructorList();

}
