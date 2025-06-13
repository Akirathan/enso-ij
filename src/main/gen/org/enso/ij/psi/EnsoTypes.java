// This is a generated file. Not intended for manual editing.
package org.enso.ij.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.enso.ij.psi.impl.*;

public interface EnsoTypes {

  IElementType ARGUMENT_DEF = new EnsoElementType("ARGUMENT_DEF");
  IElementType ASSIGNMENT = new EnsoElementType("ASSIGNMENT");
  IElementType BINARY_OP = new EnsoElementType("BINARY_OP");
  IElementType BINDING = new EnsoElementType("BINDING");
  IElementType CALL_ARGUMENT = new EnsoElementType("CALL_ARGUMENT");
  IElementType DEFAULT_VALUE = new EnsoElementType("DEFAULT_VALUE");
  IElementType EOL_WITH_COMMENT = new EnsoElementType("EOL_WITH_COMMENT");
  IElementType EXPORT_RULE = new EnsoElementType("EXPORT_RULE");
  IElementType EXPRESSION = new EnsoElementType("EXPRESSION");
  IElementType EXTENSION_METHOD = new EnsoElementType("EXTENSION_METHOD");
  IElementType FROM_EXPORT = new EnsoElementType("FROM_EXPORT");
  IElementType FROM_IMPORT = new EnsoElementType("FROM_IMPORT");
  IElementType FULLY_QUALIFIED_NAME = new EnsoElementType("FULLY_QUALIFIED_NAME");
  IElementType IDENTIFIER_RULE = new EnsoElementType("IDENTIFIER_RULE");
  IElementType ID_OR_LITERAL = new EnsoElementType("ID_OR_LITERAL");
  IElementType IMPORT_RULE = new EnsoElementType("IMPORT_RULE");
  IElementType LITERAL = new EnsoElementType("LITERAL");
  IElementType METHOD = new EnsoElementType("METHOD");
  IElementType METHOD_BODY = new EnsoElementType("METHOD_BODY");
  IElementType METHOD_CALL = new EnsoElementType("METHOD_CALL");
  IElementType MODULE = new EnsoElementType("MODULE");
  IElementType OPERATOR = new EnsoElementType("OPERATOR");
  IElementType TYPE_ASCRIPTION = new EnsoElementType("TYPE_ASCRIPTION");
  IElementType TYPE_BODY = new EnsoElementType("TYPE_BODY");
  IElementType TYPE_CONSTRUCTOR = new EnsoElementType("TYPE_CONSTRUCTOR");
  IElementType TYPE_DEFINITION = new EnsoElementType("TYPE_DEFINITION");

  IElementType ALL = new EnsoTokenType("all");
  IElementType AND = new EnsoTokenType("&&");
  IElementType AS = new EnsoTokenType("as");
  IElementType COLON = new EnsoTokenType(":");
  IElementType COMMA = new EnsoTokenType(",");
  IElementType COMMENT = new EnsoTokenType("COMMENT");
  IElementType DIV = new EnsoTokenType("/");
  IElementType DOT = new EnsoTokenType(".");
  IElementType EOL = new EnsoTokenType("EOL");
  IElementType EQUALS = new EnsoTokenType("=");
  IElementType EXPORT = new EnsoTokenType("export");
  IElementType FROM = new EnsoTokenType("from");
  IElementType IDENTIFIER = new EnsoTokenType("IDENTIFIER");
  IElementType IMPORT = new EnsoTokenType("import");
  IElementType LEFT_PAREN = new EnsoTokenType("(");
  IElementType MINUS = new EnsoTokenType("-");
  IElementType MULTILINE_COMMENT = new EnsoTokenType("MULTILINE_COMMENT");
  IElementType MULTILINE_COMMENT_START = new EnsoTokenType("MULTILINE_COMMENT_START");
  IElementType NOT = new EnsoTokenType("not");
  IElementType NUMBER = new EnsoTokenType("NUMBER");
  IElementType OR = new EnsoTokenType("||");
  IElementType PLUS = new EnsoTokenType("+");
  IElementType RIGHT_PAREN = new EnsoTokenType(")");
  IElementType SELF = new EnsoTokenType("self");
  IElementType STAR = new EnsoTokenType("*");
  IElementType STRING_DOUBLE = new EnsoTokenType("STRING_DOUBLE");
  IElementType STRING_SINGLE = new EnsoTokenType("STRING_SINGLE");
  IElementType TYPE = new EnsoTokenType("type");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT_DEF) {
        return new EnsoArgumentDefImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new EnsoAssignmentImpl(node);
      }
      else if (type == BINARY_OP) {
        return new EnsoBinaryOpImpl(node);
      }
      else if (type == BINDING) {
        return new EnsoBindingImpl(node);
      }
      else if (type == CALL_ARGUMENT) {
        return new EnsoCallArgumentImpl(node);
      }
      else if (type == DEFAULT_VALUE) {
        return new EnsoDefaultValueImpl(node);
      }
      else if (type == EOL_WITH_COMMENT) {
        return new EnsoEolWithCommentImpl(node);
      }
      else if (type == EXPORT_RULE) {
        return new EnsoExportRuleImpl(node);
      }
      else if (type == EXPRESSION) {
        return new EnsoExpressionImpl(node);
      }
      else if (type == EXTENSION_METHOD) {
        return new EnsoExtensionMethodImpl(node);
      }
      else if (type == FROM_EXPORT) {
        return new EnsoFromExportImpl(node);
      }
      else if (type == FROM_IMPORT) {
        return new EnsoFromImportImpl(node);
      }
      else if (type == FULLY_QUALIFIED_NAME) {
        return new EnsoFullyQualifiedNameImpl(node);
      }
      else if (type == IDENTIFIER_RULE) {
        return new EnsoIdentifierRuleImpl(node);
      }
      else if (type == ID_OR_LITERAL) {
        return new EnsoIdOrLiteralImpl(node);
      }
      else if (type == IMPORT_RULE) {
        return new EnsoImportRuleImpl(node);
      }
      else if (type == LITERAL) {
        return new EnsoLiteralImpl(node);
      }
      else if (type == METHOD) {
        return new EnsoMethodImpl(node);
      }
      else if (type == METHOD_BODY) {
        return new EnsoMethodBodyImpl(node);
      }
      else if (type == METHOD_CALL) {
        return new EnsoMethodCallImpl(node);
      }
      else if (type == MODULE) {
        return new EnsoModuleImpl(node);
      }
      else if (type == OPERATOR) {
        return new EnsoOperatorImpl(node);
      }
      else if (type == TYPE_ASCRIPTION) {
        return new EnsoTypeAscriptionImpl(node);
      }
      else if (type == TYPE_BODY) {
        return new EnsoTypeBodyImpl(node);
      }
      else if (type == TYPE_CONSTRUCTOR) {
        return new EnsoTypeConstructorImpl(node);
      }
      else if (type == TYPE_DEFINITION) {
        return new EnsoTypeDefinitionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
