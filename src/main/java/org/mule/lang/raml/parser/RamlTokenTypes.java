package org.mule.lang.raml.parser;

import com.google.common.collect.ImmutableMap;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;
import org.mule.lang.raml.RamlFileType;
import com.intellij.psi.tree.IElementType;

import java.util.Map;

/**
 * User: plducharme
 * Date: 06/02/14
 * Time: 3:49 PM
 * Description:
 */
public interface RamlTokenTypes {

    IElementType RDOC_VERSION_TOKEN = new IElementType("RDOC_VERSION_TOKEN", RamlFileType.getInstance().getLanguage());
    IElementType RDOC_TITLE_TOKEN = new IElementType("RDOC_TITLE_TOKEN", RamlFileType.getInstance().getLanguage());
    IElementType RDOC_TITLE_VALUE_TOKEN = new IElementType("RDOC_TITLE_VALUE_TOKEN", RamlFileType.getInstance().getLanguage());

    IElementType RDOC_URL_PARAM_TOKEN = new IElementType("RDOC_URL_PARAM_TOKEN", RamlFileType.getInstance().getLanguage());
    IElementType RDOC_URL_PATH_TOKEN = new IElementType("RDOC_URL_PATH_TOKEN", RamlFileType.getInstance().getLanguage());

    IElementType RDOC_UNKNOWN_TOKEN = new IElementType("RDOC_UNKNOWN_TOKEN", RamlFileType.getInstance().getLanguage());

    IElementType RAML_STRING = new RamlTokenType("string");
    IElementType RAML_SYMBOL = new RamlTokenType("symbol"); // use a symbol or brace instead (see below)
    IElementType RAML_COMMENT = new RamlTokenType("comment");
    IElementType RAML_INDENT = new RamlTokenType("indent");
    IElementType RAML_LITERAL = new RamlTokenType("literal");
    IElementType RAML_KEYWORD = new RamlTokenType("keyword");
    IElementType RAML_WHITESPACE = TokenType.WHITE_SPACE; // new RamlTokenType("whitespace");
    IElementType RAML_UNKNOWN = TokenType.BAD_CHARACTER; // new RamlTokenType("error");

    // symbols
    IElementType RAML_COLON = new RamlTokenType(":");
    IElementType RAML_ASSIGNMENT = new RamlTokenType("=");
    IElementType RAML_ARRAY_BULLET = new RamlTokenType("-");
    IElementType RAML_ITEM_DELIMITER = new RamlTokenType(",");

    // braces
    IElementType RAML_LPAREN = new RamlTokenType("(");
    IElementType RAML_RPAREN = new RamlTokenType(")");
    IElementType RAML_LBRACE_CURLY = new RamlTokenType("{");
    IElementType RAML_RBRACE_CURLY = new RamlTokenType("}");
    IElementType RAML_LBRACE_SQUARE = new RamlTokenType("[");
    IElementType RAML_RBRACE_SQUARE = new RamlTokenType("]");


    // the rest are deprecated and will be removed
    IElementType RAML_IDENTIFIER = new RamlTokenType("identifier");
    IElementType RAML_EOL = new RamlTokenType("eol");
    IElementType RAML_VARIABLE = new RamlTokenType("variable");
    IElementType RAML_NUMBER = new RamlTokenType("number");
    IElementType RAML_REFERENCE = new RamlTokenType("reference");
    IElementType RAML_BLOCK_INHERITENCE = new RamlTokenType("<");
    IElementType RAML_DOUBLE_COLON = new RamlTokenType("::");
    IElementType RAML_DOLLAR = new RamlTokenType("$");
    IElementType RAML_AT = new RamlTokenType("@");


    // special tokens (identifier in block header or as array key)
    IElementType RAML_KEY = new RamlTokenType("key");


    // sets
    TokenSet WHITESPACES = TokenSet.create(RAML_WHITESPACE);
    TokenSet COMMENTS = TokenSet.create(RAML_COMMENT);
    TokenSet STRING_LITERALS = TokenSet.create(RAML_LITERAL, RAML_STRING);
    TokenSet ASSIGNMENTS = TokenSet.create(RAML_ASSIGNMENT, RAML_COLON);
    TokenSet OPEN_BRACKET = TokenSet.create(RAML_LPAREN, RAML_LBRACE_CURLY, RAML_LBRACE_SQUARE);
    TokenSet CLOSING_BRACKET = TokenSet.create(RAML_RPAREN, RAML_RBRACE_CURLY, RAML_RBRACE_SQUARE);
    TokenSet SYMBOLS = TokenSet.create(
            RAML_COLON, RAML_ASSIGNMENT, RAML_ARRAY_BULLET, RAML_ITEM_DELIMITER,
            RAML_LPAREN, RAML_RPAREN,
            RAML_LBRACE_CURLY, RAML_RBRACE_CURLY,
            RAML_LBRACE_SQUARE, RAML_RBRACE_SQUARE
    );

    // brackets
    public static final Map<IElementType, IElementType> closingBrackets = ImmutableMap.of(
            RAML_LPAREN, RAML_RPAREN,
            RAML_LBRACE_CURLY, RAML_RBRACE_CURLY,
            RAML_LBRACE_SQUARE, RAML_RBRACE_SQUARE
    );

}
