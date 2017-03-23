package org.mule.tooling.lang.dw.debug;


import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XStackFrame;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.intellij.xdebugger.impl.XSourcePositionImpl;
import com.mulesoft.weave.debugger.DebuggerFrame;
import com.mulesoft.weave.debugger.DebuggerPosition;
import com.mulesoft.weave.debugger.DebuggerValue;
import com.mulesoft.weave.debugger.client.DebuggerClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.debug.value.WeaveValueFactory;
import scala.Tuple2;

public class WeaveStackFrame extends XStackFrame {

  private DebuggerClient client;
  private final DebuggerFrame frame;
  private final XSourcePositionImpl xSourcePosition;

  public WeaveStackFrame(DebuggerClient client, DebuggerPosition debuggerPosition, DebuggerFrame frame, VirtualFile weaveFile) {
    this.client = client;
    this.frame = frame;
    this.xSourcePosition = XSourcePositionImpl.create(weaveFile, debuggerPosition.line() - 1);
  }

  @Nullable
  @Override
  public XSourcePosition getSourcePosition() {
    return xSourcePosition;
  }


  @Nullable
  @Override
  public XDebuggerEvaluator getEvaluator() {
    return new WeaveScriptEvaluator(client, frame.id());
  }

  @Override
  public Object getEqualityObject() {
    return WeaveStackFrame.class;
  }

  @Override
  public void computeChildren(@NotNull XCompositeNode node) {
    final XValueChildrenList children = new XValueChildrenList();
    final Tuple2<String, DebuggerValue>[] values = frame.values();
    for (Tuple2<String, DebuggerValue> value : values) {
      children.add(value._1, WeaveValueFactory.create(value._2));
    }
    node.addChildren(children, true);
  }

}

