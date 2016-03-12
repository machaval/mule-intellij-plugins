package org.mule.lang.raml.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static org.mule.lang.raml.parser.RamlTokenTypes.*;

/**
 * @author Jan Dolecek
 * @author Jan Tvrdík
 * @author Michael Moravec
 */
%%

%class _RamlLexer
%implements FlexLexer
%public
%unicode
%function advance
%type IElementType

%{
	private void retryInState(int newState) {
        yybegin(newState);
        yypushback(yylength());
	}
%}

STRING = \'[^\'\n]*\'|\"(\\.|[^\"\\\n])*\"
COMMENT = \#.*
INDENT = \n[\t ]*
LITERAL_START = [^-:#\"\',=\[\]{}()\x00-\x20!`]|[:-][!#$%&*\x2D-\x5C\x5E-\x7C~\xA0-\uFFFF]
WHITESPACE = [\t ]+

%states DEFAULT, IN_LITERAL, VYINITIAL

%%

<YYINITIAL> {

    {WHITESPACE} {
        return RAML_INDENT;
    }
    .|\n {
        retryInState(DEFAULT);
    }
}

<DEFAULT> {
    {STRING} {
        return RAML_STRING;
    }

    "," { return RAML_ITEM_DELIMITER; }
    "=" { return RAML_ASSIGNMENT; }

    "(" { return RAML_LPAREN; }
    ")" { return RAML_RPAREN; }
    "{" { return RAML_LBRACE_CURLY; }
    "}" { return RAML_RBRACE_CURLY; }
    "[" { return RAML_LBRACE_SQUARE; }
    "]" { return RAML_RBRACE_SQUARE; }

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

    ":" { return RAML_COLON; }
    "-" { return RAML_ARRAY_BULLET; }

    {WHITESPACE} {
        return RAML_WHITESPACE;
    }

    . {
        return RAML_UNKNOWN;
    }
}

<IN_LITERAL> {
    [^,:=\]})(\x00-\x20]+ {}
    [ \t]+[^#,:=\]})(\x00-\x20] {}
    ":" / [\x21-x28*\x2D-\x5C\x5E-\x7C~\xA0-\uFFFF] { }
    ":" { retryInState(DEFAULT); }
    .|\n { retryInState(DEFAULT); }
}
