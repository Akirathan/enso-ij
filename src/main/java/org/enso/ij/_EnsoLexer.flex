package org.enso.ij;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.enso.ij.psi.EnsoTypes;

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
%state MULTILINE_COMMENT

EOL=\R
WHITE_SPACE=\s+

MULTILINE_COMMENT_START=[ \t]*##[^\n\r]*
COMMENT=#.*
EOL=\R
WHITE_SPACE=[ \t\n\x0B\f\r]+
IDENTIFIER=[a-zA-Z_][a-zA-Z_0-9]*
NUMBER=[0-9]+(\.[0-9]+)?
STRING_DOUBLE=\"([^\"\\]|\\\\.)*\"
STRING_SINGLE='([^'\\]|\\\\.)*'


%%
<YYINITIAL> {
  {WHITE_SPACE}                   { return WHITE_SPACE; }

  "import"                        { return IMPORT; }
  "export"                        { return EXPORT; }
  "all"                           { return ALL; }
  "as"                            { return AS; }
  "from"                          { return FROM; }
  "self"                          { return SELF; }
  "type"                          { return TYPE; }
  "not"                           { return NOT; }
  "="                             { return EQUALS; }
  ":"                             { return COLON; }
  "."                             { return DOT; }
  ","                             { return COMMA; }
  "+"                             { return PLUS; }
  "-"                             { return MINUS; }
  "*"                             { return STAR; }
  "/"                             { return DIV; }
  "&&"                            { return AND; }
  "||"                            { return OR; }
  "("                             { return LEFT_PAREN; }
  ")"                             { return RIGHT_PAREN; }

  {EOL}                           { return EOL; }
  {WHITE_SPACE}                   { return WHITE_SPACE; }
  {IDENTIFIER}                    { return IDENTIFIER; }
  {NUMBER}                        { return NUMBER; }
  {STRING_DOUBLE}                 { return STRING_DOUBLE; }
  {STRING_SINGLE}                 { return STRING_SINGLE; }

  // When a line start with `##`, record its indentation.
  // For each following line, if it is more indented, include it in the comment.
  // Stop when a line is not more indented.
  {MULTILINE_COMMENT_START} {
    // Record base indentation.
    String text = yytext().toString();
    int indent = 0;
    while (indent < text.length() && (text.charAt(indent) == ' ' || text.charAt(indent) == '\t')) {
      indent++;
    }
    baseIndent = indent;
    yybegin(MULTILINE_COMMENT);
  }

  {COMMENT}                       { return COMMENT; }
}

<MULTILINE_COMMENT> {
  \n([ \t]*)([^\n\r]*) {
    // Check indentation of the new line
    String text = yytext().toString();
    int indent = 0;
    int i = 1; // skip the \n
    while (i < text.length() && (text.charAt(i) == ' ' || text.charAt(i) == '\t')) {
      indent++;
      i++;
    }
    if (indent > baseIndent) {
      // Still part of the comment, stay in MULTILINE_COMMENT
      // Do nothing, just consume
    } else {
      // Not part of the comment, push back this line
      yypushback(yylength());
      yybegin(YYINITIAL);
      return EnsoTypes.MULTILINE_COMMENT;
    }
  }
  [^\n\r]+ {
    // Consume the rest of the comment line
    // Do nothing, just consume
  }
  [\n\r] {
    // End of line, continue
    // Do nothing, just consume
  }
  <<EOF>> {
    yybegin(YYINITIAL);
    return EnsoTypes.MULTILINE_COMMENT;
  }
}

[^] { return BAD_CHARACTER; }
