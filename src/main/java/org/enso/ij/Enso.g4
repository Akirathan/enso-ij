grammar Enso;

EQUALS: '=';
COLON: ':';
DOT: '.';
COMMA: ',';
PLUS: '+';
MINUS: '-';
STAR: '*';
DIV: '/';
AND: '&&';
OR: '||';
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
STRING_DOUBLE: '"'([^"]|.)*'"';
STRING_SINGLE: '\''([^']|.)*'\'';

IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER: [0-9]+('.'[0-9]+)?;


MULTILINE_COMMENT: . ; // Placeholder, real logic in MyLexer.java
INLINE_COMMENT: '#' ~[\r\n]* -> skip;
// ('\r'? '\n' [ \t]+ ~[\r\n]*)* matches subsequent lines that start with whitespace.
// DOCS_COMMENT is allowed only to start at the beginning of the line
// all other comments are ignored
DOCS_COMMENT:
    {getCharPositionInLine() == 0}? '##' ~[\r\n]* ('\r'? '\n' [ \t]+ ~[\r\n]*)*
    ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

//play: fully_qualified_name;

module :
    (imports_exports | binding)*;

module_declaration:
    comment |
    imports_exports;

imports_exports:
    import_or_export+;

// ignored comments
comment:
    MULTILINE_COMMENT |
    INLINE_COMMENT;

import_or_export : import_rule | from_import | export_rule | from_export;

import_rule : 'import' IDENTIFIER (DOT IDENTIFIER)*;

from_import : 'from' IDENTIFIER (DOT IDENTIFIER)* 'import' (identifier_list | 'all') ('as' IDENTIFIER)?;

export_rule : 'export' IDENTIFIER (DOT IDENTIFIER)*;

from_export : 'from' IDENTIFIER (DOT IDENTIFIER)* 'export' identifier_list;

identifier_list: IDENTIFIER (COMMA IDENTIFIER)*;

binding:
    method;


method: IDENTIFIER (argument_def)* EQUALS method_body;
argument_def:
    LEFT_PAREN IDENTIFIER (type_ascription)? (EQUALS default_value)? RIGHT_PAREN |
    IDENTIFIER (type_ascription)? (EQUALS default_value)?;

type_ascription: COLON IDENTIFIER;
default_value: expression;

method_body: expression+;

operator:
    PLUS |
    MINUS |
    STAR |
    DIV |
    AND |
    EQUALS |
    OR;

expression:
  literal |
  IDENTIFIER |
  method_call |
  LEFT_PAREN expression RIGHT_PAREN | // parenthesised expression
  assignment;

assignment: IDENTIFIER EQUALS expression;

method_call:
    fully_qualified_name call_argument*;

fully_qualified_name:
    IDENTIFIER (DOT IDENTIFIER)*;

call_argument:
  literal |
  IDENTIFIER |
  method_call |
  LEFT_PAREN call_argument RIGHT_PAREN;


literal:
    NUMBER |
    STRING_SINGLE |
    STRING_DOUBLE;



