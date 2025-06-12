package org.enso.ij.parser;

public final class LexerUtils {
  // TODO: add int baseIndent = -1 to _EnsoLexer
  public static void multilineComment() {
    /*
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

     */
  }
}
