package org.mule.lang.dw.parser;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;


public class WeaveLexer extends FlexAdapter {
    public WeaveLexer() {
        super(new _WeaveLexer());
    }
}
