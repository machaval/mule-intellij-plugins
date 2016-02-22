package org.mule.debugger.events;


public class DebuggerErrorEvent {
    private String errorMessage;

    public DebuggerErrorEvent(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
