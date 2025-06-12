package org.enso.ij;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts.Label;
import com.intellij.openapi.util.NlsSafe;
import javax.swing.Icon;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public final class EnsoFileType extends LanguageFileType {
  public static final EnsoFileType INSTANCE = new EnsoFileType();

  private EnsoFileType() {
    super(EnsoLanguage.INSTANCE);
  }

  @Override
  public @NonNls @NotNull String getName() {
    return "Enso File";
  }

  @Override
  public @Label @NotNull String getDescription() {
    return "Enso language file";
  }

  @Override
  public @NlsSafe @NotNull String getDefaultExtension() {
    return "enso";
  }

  @Override
  public Icon getIcon() {
    return EnsoIcons.FILE;
  }
}
