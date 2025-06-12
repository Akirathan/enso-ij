package org.enso.ij;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.enso.ij.psi.EnsoTypes;
import org.jetbrains.annotations.NotNull;

public class EnsoSyntaxHighlighter extends SyntaxHighlighterBase {
  public static final TextAttributesKey COMMENT =
      TextAttributesKey.createTextAttributesKey(
          "ENSO_COMMENT",
          DefaultLanguageHighlighterColors.BLOCK_COMMENT
      );
  public static final TextAttributesKey STRING =
      TextAttributesKey.createTextAttributesKey(
          "ENSO_STRING",
          DefaultLanguageHighlighterColors.STRING
      );
  public static final TextAttributesKey KEYWORD =
      TextAttributesKey.createTextAttributesKey(
          "ENSO_KEYWORD",
          DefaultLanguageHighlighterColors.KEYWORD
      );
  public static final TextAttributesKey NUMBER =
      TextAttributesKey.createTextAttributesKey(
          "ENSO_NUMBER",
          DefaultLanguageHighlighterColors.NUMBER
      );
  public static final TextAttributesKey OPERATOR =
      TextAttributesKey.createTextAttributesKey(
          "ENSO_OPERATOR",
          DefaultLanguageHighlighterColors.OPERATION_SIGN
      );
  public static final TextAttributesKey BAD_CHARACTER =
      TextAttributesKey.createTextAttributesKey(
          "ENSO_BAD_CHARACTER",
          HighlighterColors.BAD_CHARACTER
      );

  @Override
  public @NotNull Lexer getHighlightingLexer() {
    return new EnsoLexerAdapter();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(EnsoTypes.COMMENT)) {
      return new TextAttributesKey[]{COMMENT};
    }
    if (tokenType.equals(EnsoTypes.STRING_DOUBLE)
      || tokenType.equals(EnsoTypes.STRING_SINGLE)) {
      return new TextAttributesKey[]{STRING};
    }
    if (tokenType.equals(EnsoTypes.NUMBER)) {
      return new TextAttributesKey[]{NUMBER};
    }
    if (tokenType.equals(EnsoTypes.OPERATOR)) {
      return new TextAttributesKey[]{OPERATOR};
    }

    return new TextAttributesKey[0];
  }
}
