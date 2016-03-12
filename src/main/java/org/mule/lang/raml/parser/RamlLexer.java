package org.mule.lang.raml.parser;


import com.intellij.lexer.FlexAdapter;
import org.mule.lang.mel.parser._MelLexer;

import java.io.Reader;

public class RamlLexer extends FlexAdapter {
    public RamlLexer(Reader r) {
        super(new _RamlLexer(r));
    }
}
