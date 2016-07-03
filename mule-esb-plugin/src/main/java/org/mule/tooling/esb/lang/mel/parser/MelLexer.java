package org.mule.tooling.esb.lang.mel.parser;


import com.intellij.lexer.FlexAdapter;
import org.mule.tooling.lang.mel.parser._MelLexer;

public class MelLexer extends FlexAdapter {
    public MelLexer() {
        super(new _MelLexer());
    }
}
