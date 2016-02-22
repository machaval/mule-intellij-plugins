package org.mule.debugger.session;


import com.mulesoft.mule.debugger.response.MuleMessageInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;

public interface MessageReceivedListener {

    void onNewMessageReceived(MuleMessageInfo muleMessageInfo);

    void onExceptionThrown(MuleMessageInfo muleMessageInfo, ObjectFieldDefinition exceptionThrown);
}
