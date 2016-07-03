package org.mule.tooling.lang.mel.parser;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static org.mule.tooling.lang.mel.parser.psi.MelTypes.*;

%%

%{
  public _MelLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _MelLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

ALPHA=[:letter:]
DIGIT=[0-9]

LINE_COMMENT = "//" [^\r\n]*

IDENTIFIER={ALPHA} [:jletterdigit:]*

INTEGER_LITERAL=(0|([1-9]({DIGIT})*))
BIG_INTEGER_LITERAL=({INTEGER_LITERAL})(["h""H"]?)
DOUBLE_LITERAL=({FLOATING_POINT_LITERAL1})|({FLOATING_POINT_LITERAL2})|({FLOATING_POINT_LITERAL3})
BIG_DECIMAL_LITERAL=({DOUBLE_LITERAL})(["b""B"]?)

FLOATING_POINT_LITERAL1=({DIGIT})+"."({DIGIT})*({EXPONENT_PART})?
FLOATING_POINT_LITERAL2="."({DIGIT})+({EXPONENT_PART})?
FLOATING_POINT_LITERAL3=({DIGIT})+({EXPONENT_PART})
EXPONENT_PART=[Ee]["+""-"]?({DIGIT})*

CHARACTER_LITERAL="'"([^\\\'\r\n]|{ESCAPE_SEQUENCE})*("'"|\\)?
STRING_LITERAL=\"([^\\\"\r\n]|{ESCAPE_SEQUENCE})*(\"|\\)?
ESCAPE_SEQUENCE=\\[^\r\n]

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return com.intellij.psi.TokenType.WHITE_SPACE;}
  "++"                     { return PLUS_PLUS;}
  "--"                     { return MINUS_MINUS;}
  "}"                      { return RBRACE; }
  "."                      { return DOT; }
  ","                      { return COMMA; }
  ":"                      { return COLON; }
  "("                      { return LPARENTH; }
  ")"                      { return RPARENTH; }
  "["                      { return LBRACKET; }
  "]"                      { return RBRACKET; }
  "{"                      { return LBRACE; }
  "@"                      { return AT; }
  "?"                      { return QUESTION; }
  "$"                      { return DOLLAR; }
  "#"                      { return HASH; }
  "+"                      { return PLUS; }
  "-"                      { return MINUS; }
  "*"                      { return MULTIPLY; }
  "/"                      { return DIVISION; }
  "%"                      { return MODULO; }
  "!"                      { return NEGATE; }
  "!="                     { return NOT_EQUAL; }
  "=="                     { return EQUAL; }
  "="                      { return EQ; }
  "<"                      { return LESS; }
  "<="                     { return LESS_EQUAL; }
  ">"                      { return GREATER; }
  ">="                     { return GREATER_EQUAL; }
  "&&"                     { return AND_AND; }
  "||"                     { return OR_OR; }
  "and"                    { return AND_KEYWORD; }
  "or"                     { return OR_KEYWORD; }
  "not"                    { return NOT_KEYWORD; }
  "|"                      { return OR; }
  "^"                      { return XOR; }
  "&"                      { return AND; }
  "~"                      { return NOT; }
  "new"                    { return NEW_KEYWORD; }
  "true"                   { return TRUE_KEYWORD; }
  "false"                  { return FALSE_KEYWORD; }
  "null"                   { return NULL_KEYWORD; }
  "instanceof"             { return INSTANCEOF_KEYWORD; }
  "<<"                     { return SHIFT_LEFT; }
  ">>"                     { return SHIFT_RIGHT; }
  "import"                 { return IMPORT; }
  "def"                    { return DEF;}
  "if"                     { return IF;}
  "else"                   { return ELSE;}
  "foreach"                { return FOREACH;}
  "for"                    { return FOR;}
  "while"                  { return WHILE;}
  "do"                     { return DO;}
  "in"                     { return IN;}
  "return"                 { return RETURN;}

  {LINE_COMMENT}           { return LINE_COMMENT; }
  {IDENTIFIER}             { return IDENTIFIER; }
  {INTEGER_LITERAL}        { return INTEGER_LITERAL; }
  {BIG_INTEGER_LITERAL}    { return BIG_INTEGER_LITERAL; }
  {DOUBLE_LITERAL}         { return DOUBLE_LITERAL; }
  {BIG_DECIMAL_LITERAL}    { return BIG_DECIMAL_LITERAL; }
  {CHARACTER_LITERAL}      { return CHARACTER_LITERAL; }
  {STRING_LITERAL}         { return STRING_LITERAL; }


  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
