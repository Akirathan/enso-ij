package org.enso.ij;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class EnsoLexerAdapter extends FlexAdapter {

  public EnsoLexerAdapter() {
    super(new _EnsoLexer());
  }
}
