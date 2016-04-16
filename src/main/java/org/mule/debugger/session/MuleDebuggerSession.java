package org.mule.debugger.session;


import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.mulesoft.mule.debugger.client.DebuggerClient;
import com.mulesoft.mule.debugger.client.DebuggerConnection;
import com.mulesoft.mule.debugger.client.DefaultDebuggerResponseCallback;
import com.mulesoft.mule.debugger.commons.Breakpoint;
import com.mulesoft.mule.debugger.exception.RemoteDebugException;
import com.mulesoft.mule.debugger.response.MuleMessageInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import com.mulesoft.mule.debugger.response.ScriptResultInfo;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MuleDebuggerSession extends DefaultDebuggerResponseCallback {

    private static final int MAX_RETRIES = 30;
    private DebuggerClient debuggerClient;

    private boolean isConnected = false;
    private List<Breakpoint> breakpoints = new ArrayList<>();
    private List<MessageReceivedListener> messageReceivedListeners = new ArrayList<>();
    private boolean exceptionBreakpoint = true;
    private Project project;

    public MuleDebuggerSession(Project project) {
        this.project = project;
    }

    public void connect(@NotNull String host, @NotNull int port) {
        debuggerClient = new DebuggerClient(new DebuggerConnection(host, port));
        ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
            @Override
            public void run() {
                connect(debuggerClient, 0);
            }
        });
    }

    private DebuggerClient getDebuggerClient() {
        return debuggerClient;
    }

    private boolean connect(DebuggerClient debuggerClient, int retries) {
        try {
            debuggerClient.start(this);
        } catch (IOException e) {
            if (retries < MAX_RETRIES) {
                try {
                    Thread.sleep(1000L * 2);
                    connect(debuggerClient, retries + 1);
                } catch (InterruptedException e1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void disconnect() {
        if (isConnected) {
            try {
                System.out.println("MuleDebuggerSession.disconnect");
                getDebuggerClient().disconnect();
            } catch (Exception e) {
                //ignore
            }
        }
    }

    public Project getProject() {
        return project;
    }

    public boolean isExceptionBreakpoint() {
        return exceptionBreakpoint;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void nextStep() {
        if (isConnected) {
            getDebuggerClient().nextStep();
        }
    }

    public void resume() {
        if (isConnected) {
            getDebuggerClient().resume();
        }
    }

    public void runToCursor(String path) {
        if (isConnected) {
            getDebuggerClient().runToProcessor(path);
        }
    }

    public void enableExceptionBreakpoint() {
        if (isConnected) {
            getDebuggerClient().enableExceptionBreakpoint(true);
        }
        exceptionBreakpoint = true;
    }

    public void disableExceptionBreakpoint() {
        if (isConnected) {
            getDebuggerClient().enableExceptionBreakpoint(false);
        }
        exceptionBreakpoint = false;
    }

    public void addBreakpoint(Breakpoint muleBreakpoint) {
        if (isConnected) {
            getDebuggerClient().addBreakpoints(muleBreakpoint);
        } else {
            breakpoints.add(muleBreakpoint);
        }
    }

    @Override
    public void onError(String error) {
        System.out.println("MuleDebuggerSession.onError " + error);
    }

    public void removeBreakpoint(Breakpoint muleBreakpoint) {
        if (isConnected) {
            getDebuggerClient().removeBreakpoints(muleBreakpoint);
        } else {
            breakpoints.remove(muleBreakpoint);
        }
    }

    public List<ObjectFieldDefinition> loadInnerFields(ObjectFieldDefinition fieldDefinition) {
        final List<ObjectFieldDefinition> result = new ArrayList<>();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        getDebuggerClient().loadInnerFields(fieldDefinition.getPath(), new DefaultDebuggerResponseCallback() {
            @Override
            public void onInnerFieldsLoaded(ObjectFieldDefinition innerFields) {
                result.addAll(innerFields.getInnerElements());
                countDownLatch.countDown();
            }
        });

        try {
            countDownLatch.await(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {

        }
        return result;
    }

    public void addMessageReceivedListener(MessageReceivedListener listener) {
        messageReceivedListeners.add(listener);
    }

    @Override
    public void onMuleMessageArrived(final MuleMessageInfo muleMessageInfo) {
        ApplicationManager.getApplication().runReadAction(new Runnable() {
            @Override
            public void run() {
                for (MessageReceivedListener listener : messageReceivedListeners) {
                    listener.onNewMessageReceived(muleMessageInfo);
                }
            }
        });

    }

    @Override
    public void onExceptionThrown(final MuleMessageInfo muleMessageInfo, final ObjectFieldDefinition exceptionThrown) {
        ApplicationManager.getApplication().runReadAction(new Runnable() {
            @Override
            public void run() {
                for (MessageReceivedListener listener : messageReceivedListeners) {
                    listener.onExceptionThrown(muleMessageInfo, exceptionThrown);
                }
            }
        });
    }


    @Override
    public void onConnected() {
        System.out.println("MuleDebuggerSession.onConnected");
        isConnected = true;
        //Lets add the breakpoints that where added before it is connected
        for (Breakpoint breakpoint : breakpoints) {
            addBreakpoint(breakpoint);
        }
        getDebuggerClient().enableExceptionBreakpoint(exceptionBreakpoint);
        breakpoints.clear();
    }

    @Override
    public void onExit() {
        isConnected = false;
        System.out.println("MuleDebuggerSession.onExit");
        getDebuggerClient().disconnect();
    }

    public void eval(String script, final ScriptEvaluationCallback callback) {
        if (isConnected) {
            getDebuggerClient().executeScript(script, new DefaultDebuggerResponseCallback() {
                @Override
                public void onScriptEvaluationException(RemoteDebugException exception) {
                    callback.onScriptEvaluationException(exception);
                }

                @Override
                public void onScriptEvaluation(ScriptResultInfo info) {
                    callback.onScriptEvaluation(info);
                }
            });
        }
    }
}
