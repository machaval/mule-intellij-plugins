package org.mule.lang.raml.highlighter;

import org.mule.lang.raml.lexer.RamlDocTokenTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * User: plducharme
 * Date: 05/02/14
 * Time: 4:01 PM
 * Description:
 */
public class RamlSyntaxHighlighter extends SyntaxHighlighterBase implements RamlDocTokenTypes {

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

    static{
        fillMap(ATTRIBUTES, DefaultHighlighter.RAML_VERSION, RDOC_VERSION_TOKEN);
        fillMap(ATTRIBUTES, DefaultHighlighter.TITLE, RDOC_TITLE_TOKEN);
        fillMap(ATTRIBUTES, DefaultHighlighter.TITLE_VALUE, RDOC_TITLE_VALUE_TOKEN);

        fillMap(ATTRIBUTES, DefaultHighlighter.URL_PARAM, RDOC_URL_PARAM_TOKEN);
        fillMap(ATTRIBUTES, DefaultHighlighter.URL_PATH, RDOC_URL_PATH_TOKEN);

        fillMap(ATTRIBUTES, DefaultHighlighter.UNKNOWN, RDOC_UNKNOWN_TOKEN);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        //todo implement me
        return new RamlHighlightingLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType iElementType) {
        return pack(ATTRIBUTES.get(iElementType));
    }
}
