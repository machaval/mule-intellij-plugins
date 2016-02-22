package org.mule.debugger.events;

import com.mulesoft.mule.debugger.exception.RemoteDebugException;

public class DebuggerExceptionEvent {

    private RemoteDebugException exception;

    public DebuggerExceptionEvent(RemoteDebugException exception) {
        super();
        this.setException(exception);
    }

    public void setException(RemoteDebugException exception) {
        this.exception = exception;
    }

    public RemoteDebugException getException() {
        return exception;
    }

}
