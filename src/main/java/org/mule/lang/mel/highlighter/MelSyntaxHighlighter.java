package org.mule.lang.mel.highlighter;


import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.mel.parser.MelLexer;
import org.mule.lang.mel.parser.psi.MelTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MelSyntaxHighlighter extends SyntaxHighlighterBase {

    private static MelSyntaxHighlighter instance = new MelSyntaxHighlighter();

    public static TextAttributesKey KEYWORD = createTextAttributesKey("Mel_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static TextAttributesKey STRING = createTextAttributesKey("Mel_STRING", DefaultLanguageHighlighterColors.STRING);
    public static TextAttributesKey COMMENT = createTextAttributesKey("Mel_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static TextAttributesKey NUMBER = createTextAttributesKey("Mel_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static TextAttributesKey COMMA = createTextAttributesKey("Mel_COMMA", DefaultLanguageHighlighterColors.SEMICOLON);


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new MelLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {

        if (tokenType == null) {
            return new TextAttributesKey[0];
        } else if (tokenType.equals(MelTypes.INTEGER_LITERAL) | tokenType.equals(MelTypes.DOUBLE_LITERAL)) {
            return new TextAttributesKey[]{NUMBER};
        } else if (tokenType.equals(MelTypes.COMMA) || tokenType.equals(MelTypes.COLON)) {
            return new TextAttributesKey[]{COMMA};
        } else if (tokenType.equals(MelTypes.TRUE_KEYWORD)
                || tokenType.equals(MelTypes.FALSE_KEYWORD)
                || tokenType.equals(MelTypes.INSTANCEOF_KEYWORD)
                || tokenType.equals(MelTypes.FOR)
                || tokenType.equals(MelTypes.DEF)
                || tokenType.equals(MelTypes.IF)
                || tokenType.equals(MelTypes.DO)
                || tokenType.equals(MelTypes.ELSE)
                || tokenType.equals(MelTypes.WHILE)
                || tokenType.equals(MelTypes.IN)
                || tokenType.equals(MelTypes.NEW_KEYWORD)
                || tokenType.equals(MelTypes.IMPORT)
                || tokenType.equals(MelTypes.RETURN)
                ) {
            return new TextAttributesKey[]{KEYWORD};
        } else if (tokenType.equals(MelTypes.STRING_LITERAL)) {
            return new TextAttributesKey[]{STRING};
        } else if (tokenType.equals(MelTypes.LINE_COMMENT)) {
            return new TextAttributesKey[]{COMMENT};
        } else {
            return new TextAttributesKey[0];
        }
    }

    public static MelSyntaxHighlighter getInstance() {
        return instance;
    }
}
