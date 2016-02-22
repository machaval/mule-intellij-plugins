package org.mule.debugger.events;

import com.mulesoft.mule.debugger.response.ScriptResultInfo;

public class ScriptEvaluatedEvent {
    private ScriptResultInfo scriptResult;

    public ScriptEvaluatedEvent(ScriptResultInfo scriptResult) {
        super();
        this.setScriptResult(scriptResult);
    }

    public void setScriptResult(ScriptResultInfo scriptResult) {
        this.scriptResult = scriptResult;
    }

    public ScriptResultInfo getScriptResult() {
        return scriptResult;
    }

}
