package org.mule.debugger.events;


import com.mulesoft.mule.debugger.response.MuleMessageInfo;

public class NewMuleMessageArrivedEvent {
    private MuleMessageInfo muleMessageInfo;

    public NewMuleMessageArrivedEvent(MuleMessageInfo muleMessageInfo) {
        super();
        this.setMuleMessageInfo(muleMessageInfo);
    }


    public void setMuleMessageInfo(MuleMessageInfo muleMessageInfo) {
        this.muleMessageInfo = muleMessageInfo;
    }

    public MuleMessageInfo getMuleMessageInfo() {
        return muleMessageInfo;
    }

}
