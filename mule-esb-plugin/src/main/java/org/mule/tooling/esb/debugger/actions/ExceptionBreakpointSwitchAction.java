package org.mule.tooling.esb.debugger.actions;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import org.mule.tooling.esb.debugger.session.MuleDebuggerSession;


public class ExceptionBreakpointSwitchAction extends ToggleAction {

    private MuleDebuggerSession muleDebuggerSession;

    public ExceptionBreakpointSwitchAction(MuleDebuggerSession muleDebuggerSession) {
        super("Enable/Disable Mule Exception Breakpoint", "Enable/Disable Exception Breakpoint", AllIcons.Debugger.Db_exception_breakpoint);
        this.muleDebuggerSession = muleDebuggerSession;
    }


    @Override
    public boolean isSelected(AnActionEvent anActionEvent) {
        return muleDebuggerSession.isExceptionBreakpoint();
    }

    @Override
    public void setSelected(AnActionEvent event, boolean selected) {
        if (selected) {
            muleDebuggerSession.enableExceptionBreakpoint();
        } else {
            muleDebuggerSession.disableExceptionBreakpoint();
        }
    }
}
