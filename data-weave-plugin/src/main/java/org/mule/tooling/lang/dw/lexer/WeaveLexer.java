package org.mule.tooling.lang.dw.lexer;

import com.intellij.lexer.FlexAdapter;


public class WeaveLexer extends FlexAdapter {
  public WeaveLexer() {
    super(new _WeaveLexer());
  }
}
