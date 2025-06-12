package org.enso.ij;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.enso.ij.psi.EnsoTypes.*;

%%

%{
  public _EnsoLexer() {
    this((java.io.Reader)null);
  }

  int baseIndent = -1;
%}

%public
%class _EnsoLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

NUMBER=[0-9]+(\.[0-9]+)?
IDENTIFIER=[a-zA-Z_][a-zA-Z_0-9]*
MULTILINE_COMMENT_START=[ \t]*##[^\n\r]*
COMMENT=#.*
STRING_DOUBLE=\"([^\"\\]|\\\\.)*\"
STRING_SINGLE='([^'\\]|\\\\.)*'

%%
<YYINITIAL> {

  {EOL}                 { return EOL; }
  {WHITE_SPACE}         { return WHITE_SPACE; }

  "import"              { return IMPORT; }
  "export"              { return EXPORT; }
  "all"                 { return ALL; }
  "as"                  { return AS; }
  "from"                { return FROM; }
  "self"                { return SELF; }
  "type"                { return TYPE; }
  "not"                 { return NOT; }
  "="                   { return EQUALS; }
  ":"                   { return COLON; }
  "."                   { return DOT; }
  ","                   { return COMMA; }
  "+"                   { return PLUS; }
  "-"                   { return MINUS; }
  "*"                   { return STAR; }
  "/"                   { return DIV; }
  "&&"                  { return AND; }
  "||"                  { return OR; }
  "("                   { return LEFT_PAREN; }
  ")"                   { return RIGHT_PAREN; }

  {NUMBER}              { return NUMBER; }
  {IDENTIFIER}          { return IDENTIFIER; }
  {STRING_DOUBLE}       { return STRING_DOUBLE; }
  {STRING_SINGLE}       { return STRING_SINGLE; }

  // When a line start with `##`, record its indentation.
  // For each following line, if it is more indented, include it in the comment.
  // Stop when a line is not more indented.
  {MULTILINE_COMMENT_START} {
    // Record base indentation
    int i = 0;
    while (yytext().charAt(i) == ' ' || yytext().charAt(i) == '\t') i++;
    baseIndent = i;
    StringBuilder comment = new StringBuilder(yytext());
    int nextChar;
    boolean continueComment = true;
    while (continueComment && (nextChar = yyinput.read()) != -1) {
      if (nextChar == '\r') {
        comment.append((char)nextChar);
        int peek = yyinput.read();
        if (peek == '\n') {
          comment.append((char)peek);
        } else if (peek != -1) {
          yyinput.unread(peek);
        }
      } else if (nextChar == '\n') {
        comment.append((char)nextChar);
      } else {
        yyinput.unread(nextChar);
      }
      // Check indentation of next line
      StringBuilder line = new StringBuilder();
      int indent = 0;
      int c;
      while ((c = yyinput.read()) == ' ' || c == '\t') {
        line.append((char)c);
        indent++;
      }
      if (c == -1) break;
      line.append((char)c);
      if (indent > baseIndent) {
        // Continuation line
        while (c != '\n' && c != '\r' && c != -1) {
          c = yyinput.read();
          if (c != -1) line.append((char)c);
        }
        comment.append(line);
        if (c == -1) break;
      } else {
        // Not a continuation
        yyinput.unread(c);
        for (int j = line.length() - 1; j >= 0; j--) {
          yyinput.unread(line.charAt(j));
        }
        continueComment = false;
      }
    }
    yybegin(YYINITIAL);
    // Set the matched text as the current token
    yytext = comment.toString();
    return MULTILINE_COMMENT;
  }

  {COMMENT}             { return COMMENT; }
}

[^] { return BAD_CHARACTER; }
