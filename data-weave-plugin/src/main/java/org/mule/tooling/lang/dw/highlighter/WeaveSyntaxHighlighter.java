package org.mule.tooling.lang.dw.highlighter;


import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import org.mule.tooling.lang.dw.lexer.WeaveLexer;
import org.mule.tooling.lang.dw.parser.psi.WeavePsiUtils;
import org.mule.tooling.lang.dw.parser.psi.WeaveTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class WeaveSyntaxHighlighter extends SyntaxHighlighterBase {

    private static WeaveSyntaxHighlighter instance = new WeaveSyntaxHighlighter();

    public static TextAttributesKey KEYWORD = createTextAttributesKey("Weave_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static TextAttributesKey STRING = createTextAttributesKey("Weave_STRING", DefaultLanguageHighlighterColors.STRING);
    public static TextAttributesKey COMMENT = createTextAttributesKey("Weave_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static TextAttributesKey NUMBER = createTextAttributesKey("Weave_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static TextAttributesKey COMMA = createTextAttributesKey("Weave_COMMA", DefaultLanguageHighlighterColors.SEMICOLON);
    public static TextAttributesKey TYPE = createTextAttributesKey("Weave_TYPE", DefaultLanguageHighlighterColors.LABEL);
    public static TextAttributesKey KEY = createTextAttributesKey("Weave_KEY", DefaultLanguageHighlighterColors.METADATA);
    public static TextAttributesKey FUNCTION_DECLARATION = createTextAttributesKey("Weave_FUNCTION_DECLARATION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static TextAttributesKey FUNCTION_CALL = createTextAttributesKey("Weave_FUNCTION_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static TextAttributesKey VARIABLE = createTextAttributesKey("Weave_VARIABLE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new WeaveLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType == null) {
            return new TextAttributesKey[0];
        } else if (tokenType.equals(WeaveTypes.LINE_COMMENT)) {
            return new TextAttributesKey[]{COMMENT};
        } else if (tokenType.equals(WeaveTypes.DOCUMENT_SEPARATOR)) {
            return new TextAttributesKey[]{COMMENT};
        } else if (tokenType.equals(WeaveTypes.INTEGER_LITERAL) | tokenType.equals(WeaveTypes.DOUBLE_LITERAL)) {
            return new TextAttributesKey[]{NUMBER};
        } else if (tokenType.equals(WeaveTypes.COMMA) || tokenType.equals(WeaveTypes.COLON)) {
            return new TextAttributesKey[]{COMMA};
        } else if (tokenType.equals(WeaveTypes.TRUE_LITERAL) || tokenType.equals(WeaveTypes.FALSE_LITERAL) || WeavePsiUtils.OperatorsToken.contains(tokenType) || WeavePsiUtils.DirectivesToken.contains(tokenType)) {
            return new TextAttributesKey[]{KEYWORD};
        } else if (tokenType.equals(WeaveTypes.DOUBLE_QUOTED_STRING) || tokenType.equals(WeaveTypes.SINGLE_QUOTED_STRING)) {
            return new TextAttributesKey[]{STRING};
        } else if (tokenType.equals(WeaveTypes.RULE_TYPE_ID)) {
            return new TextAttributesKey[]{TYPE};
        } else {
            return new TextAttributesKey[0];
        }
    }

    public static WeaveSyntaxHighlighter getInstance() {
        return instance;
    }
}
