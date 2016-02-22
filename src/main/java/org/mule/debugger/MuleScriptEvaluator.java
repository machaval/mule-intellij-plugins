package org.mule.debugger;


import com.intellij.icons.AllIcons;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.mulesoft.mule.debugger.exception.RemoteDebugException;
import com.mulesoft.mule.debugger.response.ScriptResultInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.debugger.session.ScriptEvaluationCallback;
import org.mule.util.MuleSupport;

public class MuleScriptEvaluator extends XDebuggerEvaluator {

    private MuleDebuggerSession session;

    public MuleScriptEvaluator(@NotNull MuleDebuggerSession session) {
        this.session = session;
    }

    @Override
    public void evaluate(@NotNull String script, @NotNull final XEvaluationCallback xEvaluationCallback, @Nullable XSourcePosition xSourcePosition) {
        final String melExpression = MuleSupport.asMelScript(script);
        session.eval(melExpression, new ScriptEvaluationCallback() {
            @Override
            public void onScriptEvaluationException(RemoteDebugException exception) {
                xEvaluationCallback.evaluated(new ObjectFieldDefinitionValue(session, exception.getException(), AllIcons.General.Error));
            }

            @Override
            public void onScriptEvaluation(ScriptResultInfo info) {
                xEvaluationCallback.evaluated(new ObjectFieldDefinitionValue(session, info.getResult(), AllIcons.Nodes.Function));
            }
        });
    }



}
