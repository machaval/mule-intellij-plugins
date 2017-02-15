package org.mule.tooling.lang.dw.debug.value;

import com.intellij.xdebugger.frame.XValue;
import com.mulesoft.weave.engine.debugger.ArrayDebuggerValue;
import com.mulesoft.weave.engine.debugger.DebuggerFunction;
import com.mulesoft.weave.engine.debugger.DebuggerValue;
import com.mulesoft.weave.engine.debugger.FieldDebuggerValue;
import com.mulesoft.weave.engine.debugger.ObjectDebuggerValue;
import com.mulesoft.weave.engine.debugger.OperatorDebuggerValue;
import com.mulesoft.weave.engine.debugger.SimpleDebuggerValue;


public class WeaveValueFactory {


  public static XValue create(DebuggerValue value) {
    if (value instanceof ArrayDebuggerValue) {
      return new ArrayWeaveValue((ArrayDebuggerValue) value);
    } else if (value instanceof ObjectDebuggerValue) {
      return new ObjectWeaveValue((ObjectDebuggerValue) value);
    } else if (value instanceof FieldDebuggerValue) {
      return new FieldWeaveValue((FieldDebuggerValue) value);
    } else if (value instanceof DebuggerFunction) {
      return new FunctionWeaveValue((DebuggerFunction) value);
    } else if (value instanceof OperatorDebuggerValue) {
      return new OperatorWeaveValue((OperatorDebuggerValue) value);
    } else if (value instanceof SimpleDebuggerValue) {
      return new SimpleWeaveValue((SimpleDebuggerValue) value);
    }

    throw new RuntimeException("Debugger value not supported ");
  }
}
