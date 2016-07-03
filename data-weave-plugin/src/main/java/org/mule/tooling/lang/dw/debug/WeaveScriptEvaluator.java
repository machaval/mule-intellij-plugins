package org.mule.tooling.lang.dw.debug;

import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.mulesoft.weave.engine.debugger.client.DebuggerClient;
import com.mulesoft.weave.engine.debugger.client.ScriptEvaluationListener;
import com.mulesoft.weave.engine.debugger.server.event.ScriptResultEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.debug.value.WeaveValueFactory;

public class WeaveScriptEvaluator extends XDebuggerEvaluator
{

    private DebuggerClient client;
    private int frameId;

    public WeaveScriptEvaluator(@NotNull DebuggerClient client)
    {
        this(client, -1);
    }

    public WeaveScriptEvaluator(@NotNull DebuggerClient client, int frameId)
    {
        this.client = client;
        this.frameId = frameId;
    }

    @Override
    public void evaluate(@NotNull String script, @NotNull final XEvaluationCallback xEvaluationCallback, @Nullable XSourcePosition xSourcePosition)
    {
        client.evaluateScript(frameId, script, new ScriptEvaluationListener()
        {
            @Override
            public void onScriptEvaluated(DebuggerClient client, ScriptResultEvent sr)
            {
                xEvaluationCallback.evaluated(WeaveValueFactory.create(sr.result()));
            }
        });
    }
}
