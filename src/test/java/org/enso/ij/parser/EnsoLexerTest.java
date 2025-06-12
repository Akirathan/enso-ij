package org.enso.ij.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.LexerTestCase;
import java.io.IOException;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.enso.ij.EnsoLexerAdapter;
import org.enso.ij._EnsoLexer;
import org.enso.ij.psi.EnsoTokenType;
import org.enso.ij.psi.EnsoTypes;
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
    var lexer = createLexer();
    lexer.start(input);
    assertThat(lexer.getTokenType(), is(EnsoTypes.IDENTIFIER));
    assertThat(lexer.getTokenText(), is("main"));
    lexer.advance();
    assertThat(lexer.getTokenType().toString(), containsString("WHITE"));
    lexer.advance();
    assertThat(lexer.getTokenType(), is(EnsoTypes.EQUALS));
    lexer.advance();
    assertThat(lexer.getTokenType().toString(), containsString("WHITE"));
    lexer.advance();
    assertThat(lexer.getTokenType(), is(EnsoTypes.NUMBER));
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
    var lexer = createLexer();
    lexer.start(input);
    assertEquals(EnsoTypes.MULTILINE_COMMENT, lexer.getTokenType());
    lexer.advance();
    assertThat(lexer.getTokenType().toString(), containsString("WHITE"));
    lexer.advance();
    assertEquals("ident", lexer.getTokenText());
  }


}
