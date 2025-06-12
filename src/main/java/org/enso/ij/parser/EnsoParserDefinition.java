package org.enso.ij.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.enso.ij.EnsoFile;
import org.enso.ij.EnsoLanguage;
import org.enso.ij.EnsoLexerAdapter;
import org.enso.ij.EnsoTokenSets;
import org.enso.ij.psi.EnsoTypes;
import org.jetbrains.annotations.NotNull;

public class EnsoParserDefinition implements ParserDefinition {
  public static final IFileElementType FILE =
      new IFileElementType(EnsoLanguage.INSTANCE);

  @Override
  public @NotNull Lexer createLexer(Project project) {
    return new EnsoLexerAdapter();
  }

  @Override
  public @NotNull PsiParser createParser(Project project) {
    return new EnsoParser();
  }

  @Override
  public @NotNull IFileElementType getFileNodeType() {
    return FILE;
  }

  @Override
  public @NotNull TokenSet getCommentTokens() {
    return EnsoTokenSets.COMMENTS;
  }

  @Override
  public @NotNull TokenSet getStringLiteralElements() {
    return EnsoTokenSets.STRINGS;
  }

  @Override
  public @NotNull PsiElement createElement(ASTNode node) {
    return EnsoTypes.Factory.createElement(node);
  }

  @Override
  public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new EnsoFile(viewProvider);
  }
}
