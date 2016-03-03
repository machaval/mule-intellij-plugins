package org.mule.lang.raml.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * User: plducharme
 * Date: 06/02/14
 * Time: 11:28 AM
 * Description:
 */
public class RamlDocSyntaxHighlighter extends SyntaxHighlighterBase{
    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        //todo implement me
        return null;
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType iElementType) {
        return new TextAttributesKey[0];
    }
}
