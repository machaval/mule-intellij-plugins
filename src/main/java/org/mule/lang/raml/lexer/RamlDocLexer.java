package org.mule.lang.raml.lexer;

import com.intellij.lexer.DelegateLexer;
import com.intellij.lexer.Lexer;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

/**
 * User: plducharme
 * Date: 06/02/14
 * Time: 11:47 AM
 * Description:
 */
public class RamlDocLexer extends RamlBaseLexer {

    public RamlDocLexer() {
        super();
    }

    @Override
    public void start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
        super.start(buffer, startOffset, endOffset, initialState);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int getState() {
        return super.getState();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Nullable
    @Override
    public IElementType getTokenType() {
        return super.getTokenType();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int getTokenStart() {
        return super.getTokenStart();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int getTokenEnd() {
        return super.getTokenEnd();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void advance() {
        super.advance();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int getBufferEnd() {
        return super.getBufferEnd();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
