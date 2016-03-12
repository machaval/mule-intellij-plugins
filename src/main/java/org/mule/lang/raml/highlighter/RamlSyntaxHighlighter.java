package org.mule.lang.raml.highlighter;


import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.raml.parser.RamlLexer;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static org.mule.lang.raml.parser.RamlTokenTypes.*;

public class RamlSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final String            UNKNOWN_ID       = "Bad character";
    public static final TextAttributesKey UNKNOWN          = TextAttributesKey.createTextAttributesKey(UNKNOWN_ID, HighlighterColors.BAD_CHARACTER.getDefaultAttributes().clone());

    public static final String            COMMENT_ID       = "Comment";
    public static final TextAttributesKey COMMENT          = TextAttributesKey.createTextAttributesKey(COMMENT_ID, SyntaxHighlighterColors.LINE_COMMENT.getDefaultAttributes().clone());

    public static final String            IDENTIFIER_ID    = "Identifier";
    public static final TextAttributesKey IDENTIFIER       = TextAttributesKey.createTextAttributesKey(IDENTIFIER_ID, SyntaxHighlighterColors.KEYWORD.getDefaultAttributes().clone());

    public static final String            INTERPUNCTION_ID = "Interpunction";
    public static final TextAttributesKey INTERPUNCTION    = TextAttributesKey.createTextAttributesKey(INTERPUNCTION_ID, SyntaxHighlighterColors.DOT.getDefaultAttributes().clone());

    public static final String            NUMBER_ID        = "Number";
    public static final TextAttributesKey NUMBER           = TextAttributesKey.createTextAttributesKey(NUMBER_ID, SyntaxHighlighterColors.NUMBER.getDefaultAttributes().clone());

    public static final String            KEYWORD_ID       = "Keyword";
    public static final TextAttributesKey KEYWORD          = TextAttributesKey.createTextAttributesKey(KEYWORD_ID, SyntaxHighlighterColors.KEYWORD.getDefaultAttributes().clone());

    // Groups of IElementType's
    public static final TokenSet sBAD           = TokenSet.create(RAML_UNKNOWN);
    public static final TokenSet sCOMMENTS      = TokenSet.create(RAML_COMMENT);
    public static final TokenSet sIDENTIFIERS   = TokenSet.create(RAML_KEY); //, RAML_IDENTIFIER, RAML_LITERAL);
    public static final TokenSet sINTERPUNCTION = TokenSet.create(RAML_BLOCK_INHERITENCE, RAML_LPAREN, RAML_RPAREN, RAML_LBRACE_CURLY, RAML_RBRACE_CURLY, RAML_LBRACE_SQUARE, RAML_RBRACE_SQUARE, RAML_ITEM_DELIMITER, RAML_ASSIGNMENT);
    public static final TokenSet sNUMBERS       = TokenSet.create(RAML_NUMBER);
    public static final TokenSet sKEYWORDS      = TokenSet.create(RAML_KEYWORD);


    // Static container
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();


    // Fill in the map
    static {
        fillMap(ATTRIBUTES, sBAD,           UNKNOWN);
        fillMap(ATTRIBUTES, sCOMMENTS,      COMMENT);
        fillMap(ATTRIBUTES, sIDENTIFIERS,   IDENTIFIER);
        fillMap(ATTRIBUTES, sINTERPUNCTION, INTERPUNCTION);
        fillMap(ATTRIBUTES, sNUMBERS,       NUMBER);
        fillMap(ATTRIBUTES, sKEYWORDS,      KEYWORD);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new RamlHighlightingLexer(new RamlLexer((Reader)null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
        return pack(ATTRIBUTES.get(type));
    }

    public static RamlSyntaxHighlighter getInstance() {
        return new RamlSyntaxHighlighter();
    }
}
