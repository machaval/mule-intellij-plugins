package org.mule.debugger.events;

import com.mulesoft.mule.debugger.client.DebuggerClient;

public class ClientInitializedEvent {

    private DebuggerClient client;

    public ClientInitializedEvent(DebuggerClient client) {
        super();
        this.client = client;
    }

    public DebuggerClient getClient() {
        return client;
    }
}
