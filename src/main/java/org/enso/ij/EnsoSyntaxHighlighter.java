package org.enso.ij;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import javax.swing.JSpinner.NumberEditor;
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
  private static final TextAttributesKey[] COMMENT_KEYS
      = new TextAttributesKey[]{COMMENT};
  private static final TextAttributesKey[] STRING_KEYS
      = new TextAttributesKey[]{STRING};
  private static final TextAttributesKey[] KEYWORD_KEYS
      = new TextAttributesKey[]{KEYWORD};
  private static final TextAttributesKey[] NUMBER_KEYS
      = new TextAttributesKey[]{NUMBER};
  private static final TextAttributesKey[] OPERATOR_KEYS
      = new TextAttributesKey[]{OPERATOR};
  private static final TextAttributesKey[] BAD_CHARACTER_KEYS
      = new TextAttributesKey[]{BAD_CHARACTER};
  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @Override
  public @NotNull Lexer getHighlightingLexer() {
    return new EnsoLexerAdapter();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    if (tokenType.equals(EnsoTypes.COMMENT) || tokenType.equals(EnsoTypes.MULTILINE_COMMENT)) {
      return COMMENT_KEYS;
    }
    if (tokenType.equals(EnsoTypes.FROM)
        || tokenType.equals(EnsoTypes.IMPORT)
        || tokenType.equals(EnsoTypes.EXPORT)
        || tokenType.equals(EnsoTypes.ALL)
        || tokenType.equals(EnsoTypes.TYPE)
    ) {
      return KEYWORD_KEYS;
    }
    if (tokenType.equals(EnsoTypes.STRING_DOUBLE)
      || tokenType.equals(EnsoTypes.STRING_SINGLE)) {
      return STRING_KEYS;
    }
    if (tokenType.equals(EnsoTypes.NUMBER)) {
      return NUMBER_KEYS;
    }
    if (tokenType.equals(EnsoTypes.OPERATOR)) {
      return OPERATOR_KEYS;
    }

    return new TextAttributesKey[0];
  }
}
