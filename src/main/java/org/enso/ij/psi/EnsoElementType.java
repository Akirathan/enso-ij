package org.enso.ij.psi;

import com.intellij.psi.tree.IElementType;
import org.enso.ij.EnsoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class EnsoElementType extends IElementType {

  public EnsoElementType(
      @NonNls @NotNull String debugName) {
    super(debugName, EnsoLanguage.INSTANCE);
  }
}
