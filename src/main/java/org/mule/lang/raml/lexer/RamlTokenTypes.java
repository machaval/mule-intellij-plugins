package org.mule.lang.raml.lexer;

import com.google.common.collect.ImmutableMap;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import java.util.Map;

/**
 * Types of tokens returned form lexer
 *
 * @author Jan Dolecek - juzna.cz@gmail.com
 */
public interface RamlTokenTypes
{
	IElementType RAML_STRING = new RamlTokenType("string");
	IElementType RAML_COMMENT = new RamlTokenType("comment");
	IElementType RAML_INDENT = new RamlTokenType("indent");
	IElementType RAML_LITERAL = new RamlTokenType("literal");
	IElementType RAML_KEYWORD = new RamlTokenType("keyword");
	IElementType RAML_WHITESPACE = TokenType.WHITE_SPACE;
	IElementType RAML_UNKNOWN = TokenType.BAD_CHARACTER;

	IElementType RAML_TAG = new RamlTokenType("tag");
	IElementType RAML_HEADER = new RamlTokenType("header");

	// symbols
	IElementType RAML_COLON = new RamlTokenType(":");
	IElementType RAML_ASSIGNMENT = new RamlTokenType("=");
	IElementType RAML_ARRAY_BULLET = new RamlTokenType("-");
	IElementType RAML_ITEM_DELIMITER = new RamlTokenType(",");
	IElementType RAML_LINE_CONTINUATION = new RamlTokenType(">");

	// braces
	IElementType RAML_LBRACE_CURLY = new RamlTokenType("{");
	IElementType RAML_RBRACE_CURLY = new RamlTokenType("}");


	IElementType RAML_LBRACE_SQUARE = new RamlTokenType("[");
	IElementType RAML_RBRACE_SQUARE = new RamlTokenType("]");

	// special tokens
	IElementType RAML_KEY = new RamlTokenType("key");

	// sets
	TokenSet WHITESPACES = TokenSet.create(RAML_WHITESPACE);
	TokenSet COMMENTS = TokenSet.create(RAML_COMMENT);
	TokenSet STRING_LITERALS = TokenSet.create(RAML_LITERAL, RAML_STRING);
	TokenSet ASSIGNMENTS = TokenSet.create(RAML_ASSIGNMENT, RAML_COLON);
	TokenSet OPEN_BRACKET = TokenSet.create(RAML_LBRACE_CURLY, RAML_LBRACE_SQUARE);
	TokenSet CLOSING_BRACKET = TokenSet.create(RAML_RBRACE_CURLY, RAML_RBRACE_SQUARE);

	TokenSet OPEN_STRING_ALLOWED = TokenSet.create(
			RAML_COLON, RAML_ASSIGNMENT, RAML_ARRAY_BULLET,
			RAML_WHITESPACE, RAML_LITERAL, RAML_STRING,

			// Match brackets, as they would be inside the literal
			RAML_LBRACE_CURLY, RAML_LBRACE_SQUARE
    );

	// brackets
	Map<IElementType, IElementType> closingBrackets = ImmutableMap.of(
			RAML_LBRACE_CURLY, RAML_RBRACE_CURLY,
			RAML_LBRACE_SQUARE, RAML_RBRACE_SQUARE
	);

}
