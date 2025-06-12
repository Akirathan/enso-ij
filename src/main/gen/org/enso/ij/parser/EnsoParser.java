// This is a generated file. Not intended for manual editing.
package org.enso.ij.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.enso.ij.psi.EnsoTypes.*;
import static org.enso.ij.parser.EnsoParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class EnsoParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // identifier [type_ascription] (EQUALS default_value)?
  public static boolean argument_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_def")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && argument_def_1(b, l + 1);
    r = r && argument_def_2(b, l + 1);
    exit_section_(b, m, ARGUMENT_DEF, r);
    return r;
  }

  // [type_ascription]
  private static boolean argument_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_def_1")) return false;
    type_ascription(b, l + 1);
    return true;
  }

  // (EQUALS default_value)?
  private static boolean argument_def_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_def_2")) return false;
    argument_def_2_0(b, l + 1);
    return true;
  }

  // EQUALS default_value
  private static boolean argument_def_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument_def_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && default_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier EQUALS expression
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && expression(b, l + 1);
    exit_section_(b, m, ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // id_or_literal operator id_or_literal
  public static boolean binary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OP, "<binary op>");
    r = id_or_literal(b, l + 1);
    r = r && operator(b, l + 1);
    r = r && id_or_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // method |
  //   extension_method |
  //   eol_with_comment
  public static boolean binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding")) return false;
    if (!nextTokenIs(b, "<binding>", EOL, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINDING, "<binding>");
    r = method(b, l + 1);
    if (!r) r = extension_method(b, l + 1);
    if (!r) r = eol_with_comment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literal |
  //     method_call |
  //     LEFT_PAREN call_argument RIGHT_PAREN
  public static boolean call_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL_ARGUMENT, "<call argument>");
    r = literal(b, l + 1);
    if (!r) r = method_call(b, l + 1);
    if (!r) r = call_argument_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_PAREN call_argument RIGHT_PAREN
  private static boolean call_argument_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_argument_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && call_argument(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean default_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "default_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFAULT_VALUE, "<default value>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EOL [MULTILINE_COMMENT]
  public static boolean eol_with_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol_with_comment")) return false;
    if (!nextTokenIs(b, EOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    r = r && eol_with_comment_1(b, l + 1);
    exit_section_(b, m, EOL_WITH_COMMENT, r);
    return r;
  }

  // [MULTILINE_COMMENT]
  private static boolean eol_with_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eol_with_comment_1")) return false;
    consumeToken(b, MULTILINE_COMMENT);
    return true;
  }

  /* ********************************************************** */
  // EXPORT fully_qualified_name
  public static boolean export_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export_rule")) return false;
    if (!nextTokenIs(b, EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXPORT);
    r = r && fully_qualified_name(b, l + 1);
    exit_section_(b, m, EXPORT_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // assignment |
  //     binary_op |
  //     literal |
  //     method_call |
  //     LEFT_PAREN expression RIGHT_PAREN |
  //     eol_with_comment
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = assignment(b, l + 1);
    if (!r) r = binary_op(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = method_call(b, l + 1);
    if (!r) r = expression_4(b, l + 1);
    if (!r) r = eol_with_comment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LEFT_PAREN expression RIGHT_PAREN
  private static boolean expression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier DOT identifier (argument_def)* EQUALS method_body
  public static boolean extension_method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_method")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && identifier(b, l + 1);
    r = r && extension_method_3(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && method_body(b, l + 1);
    exit_section_(b, m, EXTENSION_METHOD, r);
    return r;
  }

  // (argument_def)*
  private static boolean extension_method_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_method_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!extension_method_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "extension_method_3", c)) break;
    }
    return true;
  }

  // (argument_def)
  private static boolean extension_method_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_method_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_def(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FROM fully_qualified_name EXPORT identifier_list
  public static boolean from_export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from_export")) return false;
    if (!nextTokenIs(b, FROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && fully_qualified_name(b, l + 1);
    r = r && consumeToken(b, EXPORT);
    r = r && identifier_list(b, l + 1);
    exit_section_(b, m, FROM_EXPORT, r);
    return r;
  }

  /* ********************************************************** */
  // FROM fully_qualified_name IMPORT (identifier_list|ALL) [AS identifier]
  public static boolean from_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from_import")) return false;
    if (!nextTokenIs(b, FROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FROM);
    r = r && fully_qualified_name(b, l + 1);
    r = r && consumeToken(b, IMPORT);
    r = r && from_import_3(b, l + 1);
    r = r && from_import_4(b, l + 1);
    exit_section_(b, m, FROM_IMPORT, r);
    return r;
  }

  // identifier_list|ALL
  private static boolean from_import_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from_import_3")) return false;
    boolean r;
    r = identifier_list(b, l + 1);
    if (!r) r = consumeToken(b, ALL);
    return r;
  }

  // [AS identifier]
  private static boolean from_import_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from_import_4")) return false;
    from_import_4_0(b, l + 1);
    return true;
  }

  // AS identifier
  private static boolean from_import_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "from_import_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier (DOT identifier)*
  public static boolean fully_qualified_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fully_qualified_name")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && fully_qualified_name_1(b, l + 1);
    exit_section_(b, m, FULLY_QUALIFIED_NAME, r);
    return r;
  }

  // (DOT identifier)*
  private static boolean fully_qualified_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fully_qualified_name_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fully_qualified_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fully_qualified_name_1", c)) break;
    }
    return true;
  }

  // DOT identifier
  private static boolean fully_qualified_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fully_qualified_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // fully_qualified_name|literal
  public static boolean id_or_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_or_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID_OR_LITERAL, "<id or literal>");
    r = fully_qualified_name(b, l + 1);
    if (!r) r = literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // identifier (COMMA identifier)*
  static boolean identifier_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && identifier_list_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA identifier)*
  private static boolean identifier_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!identifier_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifier_list_1", c)) break;
    }
    return true;
  }

  // COMMA identifier
  private static boolean identifier_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // import_rule|
  //   from_import|
  //   export_rule|
  //   from_export|
  //   eol_with_comment
  static boolean import_or_export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_or_export")) return false;
    boolean r;
    r = import_rule(b, l + 1);
    if (!r) r = from_import(b, l + 1);
    if (!r) r = export_rule(b, l + 1);
    if (!r) r = from_export(b, l + 1);
    if (!r) r = eol_with_comment(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IMPORT fully_qualified_name
  public static boolean import_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_rule")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && fully_qualified_name(b, l + 1);
    exit_section_(b, m, IMPORT_RULE, r);
    return r;
  }

  /* ********************************************************** */
  // STRING_DOUBLE |
  //     STRING_SINGLE |
  //     NUMBER
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, STRING_DOUBLE);
    if (!r) r = consumeToken(b, STRING_SINGLE);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier (argument_def)* EQUALS method_body
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && method_1(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && method_body(b, l + 1);
    exit_section_(b, m, METHOD, r);
    return r;
  }

  // (argument_def)*
  private static boolean method_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_1", c)) break;
    }
    return true;
  }

  // (argument_def)
  private static boolean method_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_def(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression*
  public static boolean method_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, METHOD_BODY, "<method body>");
    while (true) {
      int c = current_position_(b);
      if (!expression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_body", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // fully_qualified_name call_argument*
  public static boolean method_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fully_qualified_name(b, l + 1);
    r = r && method_call_1(b, l + 1);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  // call_argument*
  private static boolean method_call_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!call_argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_call_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // import_or_export* binding*
  public static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODULE, "<module>");
    r = module_0(b, l + 1);
    r = r && module_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // import_or_export*
  private static boolean module_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_or_export(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_0", c)) break;
    }
    return true;
  }

  // binding*
  private static boolean module_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binding(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PLUS|MINUS|STAR|DIV|AND|OR
  public static boolean operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATOR, "<operator>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module
  static boolean root(PsiBuilder b, int l) {
    return module(b, l + 1);
  }

  /* ********************************************************** */
  // COLON identifier
  public static boolean type_ascription(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_ascription")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, TYPE_ASCRIPTION, r);
    return r;
  }

  /* ********************************************************** */
  // type_constructor* method*
  public static boolean type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_BODY, "<type body>");
    r = type_body_0(b, l + 1);
    r = r && type_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type_constructor*
  private static boolean type_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_body_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_constructor(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_body_0", c)) break;
    }
    return true;
  }

  // method*
  private static boolean type_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_body_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_body_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifier (argument_def)*
  public static boolean type_constructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_constructor")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && type_constructor_1(b, l + 1);
    exit_section_(b, m, TYPE_CONSTRUCTOR, r);
    return r;
  }

  // (argument_def)*
  private static boolean type_constructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_constructor_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_constructor_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_constructor_1", c)) break;
    }
    return true;
  }

  // (argument_def)
  private static boolean type_constructor_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_constructor_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argument_def(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE identifier type_body
  public static boolean type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_definition")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && identifier(b, l + 1);
    r = r && type_body(b, l + 1);
    exit_section_(b, m, TYPE_DEFINITION, r);
    return r;
  }

}
