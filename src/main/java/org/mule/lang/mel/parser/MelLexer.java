package org.mule.lang.mel.parser;


import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

public class MelLexer extends FlexAdapter {
    public MelLexer() {
        super(new _MelLexer());
    }
}
