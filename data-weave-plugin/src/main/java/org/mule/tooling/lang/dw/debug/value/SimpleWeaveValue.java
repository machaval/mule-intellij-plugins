package org.mule.tooling.lang.dw.debug.value;

import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.debugger.SimpleDebuggerValue;
import org.jetbrains.annotations.NotNull;

public class SimpleWeaveValue extends XValue {

  private SimpleDebuggerValue debuggerValue;

  public SimpleWeaveValue(SimpleDebuggerValue debuggerValue) {
    this.debuggerValue = debuggerValue;
  }

  @Override
  public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace) {
    //Lets make sure if it is null to be a string
    final String presentationValue = String.valueOf(debuggerValue.value());
    xValueNode.setPresentation(PlatformIcons.VARIABLE_ICON, debuggerValue.typeName(), presentationValue, false);
  }

}
