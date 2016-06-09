package org.mule.debugger.session;


import com.mulesoft.mule.debugger.response.MuleMessageInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;

import java.util.List;

public interface MessageReceivedListener {

    void onNewMessageReceived(MuleMessageInfo muleMessageInfo);

    void onExceptionThrown(MuleMessageInfo muleMessageInfo, ObjectFieldDefinition exceptionThrown);

    void onExecutionStopped(MuleMessageInfo muleMessageInfo, List<ObjectFieldDefinition> frame, String path, String internalPosition);
}
