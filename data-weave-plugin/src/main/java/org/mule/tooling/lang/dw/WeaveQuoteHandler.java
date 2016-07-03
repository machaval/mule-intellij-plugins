package org.mule.tooling.lang.dw;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.intellij.psi.tree.TokenSet;
import org.mule.tooling.lang.dw.parser.psi.WeaveTypes;


public class WeaveQuoteHandler extends SimpleTokenSetQuoteHandler {

    public WeaveQuoteHandler() {
        super(TokenSet.create(WeaveTypes.DOUBLE_QUOTED_STRING, WeaveTypes.SINGLE_QUOTED_STRING));
    }
}
