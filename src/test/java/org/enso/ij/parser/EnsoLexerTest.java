package org.enso.ij.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.LexerTestCase;
import java.io.IOException;
import java.util.List;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.enso.ij.EnsoLexerAdapter;
import org.enso.ij._EnsoLexer;
import org.enso.ij.psi.EnsoTokenType;
import org.enso.ij.psi.EnsoTypes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.containsString;


public class EnsoLexerTest extends LexerTestCase {

  @Override
  protected Lexer createLexer() {
    return new EnsoLexerAdapter();
  }

  @Override
  protected String getDirPath() {
    return "";
  }

  public void testAssignment() throws Exception {
    var input = "main = 42";
    assertTokenTypes(input, List.of(
        EnsoTypes.IDENTIFIER,
        EnsoTypes.EQUALS,
        EnsoTypes.NUMBER
    ));
  }

  public void testParsesMultilineComment_Simple() {
    var input = """
        ## C
        """;
    var lexer = createLexer();
    lexer.start(input);
    assertEquals(EnsoTypes.MULTILINE_COMMENT, lexer.getTokenType());
    assertEquals("## C", lexer.getTokenText());
    lexer.advance();
  }

  public void testParsesMultilineComment_Indent() {
    var input = """
        ## C
           D
        """;
    var lexer = createLexer();
    lexer.start(input);
    assertEquals(EnsoTypes.MULTILINE_COMMENT, lexer.getTokenType());
    assertThat(lexer.getTokenText(), containsString("C"));
    assertThat(lexer.getTokenText(), containsString("D"));
  }

  public void testParsesMultilineComment_Indent_ThreeLines() {
    var input = """
        ## C
           D
              E
        """;
    var lexer = createLexer();
    lexer.start(input);
    assertEquals(EnsoTypes.MULTILINE_COMMENT, lexer.getTokenType());
    assertThat(lexer.getTokenText(), containsString("C"));
    assertThat(lexer.getTokenText(), containsString("D"));
    assertThat(lexer.getTokenText(), containsString("E"));
  }

  public void testParseMultilineComment_AndIdentifier() {
    var input = """
        ## COM
        ident
        """;

    assertTokenTypes(input, List.of(
        EnsoTypes.MULTILINE_COMMENT,
        EnsoTypes.IDENTIFIER
    ));
  }

  /**
   * Whitespaces are ignored.
   */
  private void assertTokenTypes(String input, List<IElementType> tokenTypes) {
    var lexer = createLexer();
    lexer.start(input);
    for (var i = 0; i < tokenTypes.size(); i++) {
      var tokenType = lexer.getTokenType();
      if (tokenType.toString().contains("WHITE")) {
        continue;
      }
      var expectedTokenType = tokenTypes.get(i);
      assertThat("Token type mismatch at index " + i + ": " + currentTokenInfo(lexer),
          tokenType, is(expectedTokenType));
      lexer.advance();
    }
  }

  private static String currentTokenInfo(Lexer lexer) {
    var sb = new StringBuilder();
    sb.append("Token{");
    sb.append("type=").append(lexer.getTokenType());
    sb.append(", start=").append(lexer.getTokenStart());
    sb.append(", end=").append(lexer.getTokenEnd());
    sb.append(", text='").append(lexer.getTokenText()).append('\'');
    sb.append("}");
    return sb.toString();
  }


}
