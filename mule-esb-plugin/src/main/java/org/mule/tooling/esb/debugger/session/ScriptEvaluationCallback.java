package org.mule.tooling.esb.debugger.session;


import com.mulesoft.mule.debugger.exception.RemoteDebugException;
import com.mulesoft.mule.debugger.response.ScriptResultInfo;

public interface ScriptEvaluationCallback {

    void onScriptEvaluationException(RemoteDebugException exception);

    void onScriptEvaluation(ScriptResultInfo info);
}
