package org.mule.lang.raml.editor;


import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.raml.lexer.RamlHighlightingLexer;
import org.mule.lang.raml.lexer.RamlLexer;

import java.util.HashMap;
import java.util.Map;

import static org.mule.lang.raml.lexer.RamlTokenTypes.*;

public class RamlSyntaxHighlighter extends SyntaxHighlighterBase {

	public static final String            UNKNOWN_ID       = "Bad character";
	public static final TextAttributesKey UNKNOWN          = TextAttributesKey.createTextAttributesKey(UNKNOWN_ID, HighlighterColors.BAD_CHARACTER);

	public static final String            COMMENT_ID       = "Comment";
	public static final TextAttributesKey COMMENT          = TextAttributesKey.createTextAttributesKey(COMMENT_ID, DefaultLanguageHighlighterColors.LINE_COMMENT);

	public static final String            IDENTIFIER_ID    = "Identifier";
	public static final TextAttributesKey IDENTIFIER       = TextAttributesKey.createTextAttributesKey(IDENTIFIER_ID, DefaultLanguageHighlighterColors.INSTANCE_FIELD);

	public static final String            INTERPUNCTION_ID = "Interpunction";
	public static final TextAttributesKey INTERPUNCTION    = TextAttributesKey.createTextAttributesKey(INTERPUNCTION_ID, DefaultLanguageHighlighterColors.DOT);

	public static final String            NUMBER_ID        = "Number";
	public static final TextAttributesKey NUMBER           = TextAttributesKey.createTextAttributesKey(NUMBER_ID, DefaultLanguageHighlighterColors.NUMBER);

	public static final String            KEYWORD_ID       = "Keyword";
	public static final TextAttributesKey KEYWORD          = TextAttributesKey.createTextAttributesKey(KEYWORD_ID, DefaultLanguageHighlighterColors.KEYWORD);

	public static final String            STRING_ID       = "STRING";
	public static final TextAttributesKey STRING          = TextAttributesKey.createTextAttributesKey(STRING_ID, DefaultLanguageHighlighterColors.STRING);

	public static final String            TAG_ID          = "TAG";
	public static final TextAttributesKey TAG             = TextAttributesKey.createTextAttributesKey(TAG_ID, DefaultLanguageHighlighterColors.MARKUP_ATTRIBUTE);



	// Groups of IElementType's
	public static final TokenSet sBAD           = TokenSet.create(RAML_UNKNOWN);
	public static final TokenSet sCOMMENTS      = TokenSet.create(RAML_COMMENT);
	public static final TokenSet sIDENTIFIERS   = TokenSet.create(RAML_KEY);
	public static final TokenSet sINTERPUNCTION = TokenSet.create(RAML_LBRACE_CURLY, RAML_RBRACE_CURLY, RAML_LBRACE_SQUARE, RAML_RBRACE_SQUARE, RAML_ITEM_DELIMITER, RAML_ASSIGNMENT);
	public static final TokenSet sKEYWORDS      = TokenSet.create(RAML_KEYWORD);
	public static final TokenSet sSTRINGS       = TokenSet.create(RAML_STRING);
	public static final TokenSet sTAGS          = TokenSet.create(RAML_TAG, RAML_HEADER);



	// Static container
	private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();


	// Fill in the map
	static {
		fillMap(ATTRIBUTES, sBAD,           UNKNOWN);
		fillMap(ATTRIBUTES, sCOMMENTS,      COMMENT);
		fillMap(ATTRIBUTES, sIDENTIFIERS,   IDENTIFIER);
		fillMap(ATTRIBUTES, sINTERPUNCTION, INTERPUNCTION);
		fillMap(ATTRIBUTES, sKEYWORDS,      KEYWORD);
		fillMap(ATTRIBUTES, sSTRINGS,       STRING);
		fillMap(ATTRIBUTES, sTAGS,  	    TAG);
	}


	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new RamlHighlightingLexer(new RamlLexer());
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType type) {
		return pack(ATTRIBUTES.get(type));
	}
}
