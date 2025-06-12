package org.enso.ij;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class EnsoLanguage extends Language {
  public static final EnsoLanguage INSTANCE = new EnsoLanguage();

  private EnsoLanguage() {
    super("Enso");
  }
}
