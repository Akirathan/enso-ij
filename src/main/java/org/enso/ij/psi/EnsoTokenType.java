package org.enso.ij.psi;

import com.intellij.psi.tree.IElementType;
import org.enso.ij.EnsoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class EnsoTokenType extends IElementType {

  public EnsoTokenType(
      @NonNls @NotNull String debugName) {
    super(debugName, EnsoLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "EnsoTokenType." + super.toString();
  }
}
