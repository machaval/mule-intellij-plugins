package org.mule.lang.raml.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static org.mule.lang.raml.lexer.RamlTokenTypes.*;
%%
%class _RamlLexer
%implements FlexLexer
%public
// %debug
%unicode
%function advance
%type IElementType
%{
    private int yycolumn = 0;
    private int a = 0;
	private void retryInState(int newState) {
        yybegin(newState);
        yypushback(yylength());
	}
%}

STRING = \'[^\'\n,]*\'|\"(\\.|[^\"{}\\\n,])*\"
COMMENT = \#.*
YAML_HEADER = ---.*
TAG=\![\!|[:jletterdigit:]]+
INDENT = \n[\t ]*
LITERAL_START = [^#,=\[\]{}\x00-\x20!`]
WHITESPACE = [\t ]+
Identifier = [:jletter:] [:jletterdigit:]*
NEWLINE = \r\n|[\r\n\u2028\u2029\u000B\u000C\u0085]

%state IN_LITERAL
%state IN_ASSIGNMENT
%state IN_ASSIGNMENT_LITERAL
%%

<YYINITIAL> {

    {STRING} {
        return RAML_STRING;
    }

    {YAML_HEADER} {
        return RAML_HEADER;
    }

    {TAG} {return RAML_TAG;}

    "-" / [ \t\n] { return RAML_ARRAY_BULLET; }
    "-" $ { return RAML_ARRAY_BULLET; }
    ":" / [ \t\n,\]})] { return RAML_COLON; }
    ":" $ { return RAML_COLON; }
    ","   { return RAML_ITEM_DELIMITER; }
    ">" | "|" {WHITESPACE}* { return RAML_LINE_CONTINUATION; }

    "{" { return RAML_LBRACE_CURLY; }
    "}" { return RAML_RBRACE_CURLY; }
    "[" { return RAML_LBRACE_SQUARE; }
    "]" { return RAML_RBRACE_SQUARE; }
    "=" { return RAML_ASSIGNMENT; }

    {COMMENT} {
        return RAML_COMMENT;
    }

    {INDENT} {
        return RAML_INDENT;
    }

    {LITERAL_START} {
        yybegin(IN_LITERAL);
        return RAML_LITERAL;
    }

    {WHITESPACE} {
        return RAML_WHITESPACE;
    }

    . {
        return RAML_UNKNOWN;
    }
}

<IN_LITERAL> {
    [^,:\]{}\x00-\x20]+    { a=302; }
    [ \t]+[^#,:\]{}\x00-\x20] { a=303; }
    ":"[ \t\n,\]})]         { a=304;retryInState(YYINITIAL); }
    ":"$                    { a=305;retryInState(YYINITIAL); }
    ":"                     { a=306; }
    .|\n                    { a=307;retryInState(YYINITIAL); }
}

<IN_ASSIGNMENT_LITERAL> {
    {WHITESPACE}+ {Identifier} {WHITESPACE}* "="    { a=501; retryInState(IN_ASSIGNMENT); }
    {NEWLINE}            { a=503;retryInState(IN_ASSIGNMENT); }
    // Just to make next one faster
    [:jletter:]* [:jletterdigit:]*               { a=504; }
    .               { a=505; }
}

<IN_ASSIGNMENT> {
    {STRING}         {  a=401;return RAML_STRING; }
    {WHITESPACE}     {  a=403;return RAML_WHITESPACE;    }

    {LITERAL_START}  {
        return RAML_LITERAL;
    }

    .|\n { a=406;retryInState(YYINITIAL); }
}
