package org.mule.lang.raml.lexer;


import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;


public class RamlLexer extends MergingLexerAdapter {
    // To be merged
    private static final TokenSet TOKENS_TO_MERGE = TokenSet.create(
            RamlTokenTypes.RAML_COMMENT,
            RamlTokenTypes.RAML_WHITESPACE
    );

    public RamlLexer() {
        super(new FlexAdapter(new _RamlLexer(null)), TOKENS_TO_MERGE);
    }
}
