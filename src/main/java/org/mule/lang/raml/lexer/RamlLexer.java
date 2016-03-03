package org.mule.lang.raml.lexer;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.LexerPosition;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

/**
 * User: plducharme
 * Date: 06/02/14
 * Time: 2:29 PM
 * Description:
 */
public class RamlLexer extends LookAheadLexer {
    public RamlLexer() {
        super(new RamlBaseLexer());
    }
}
