package org.mule.launcher;


import com.intellij.execution.BeforeRunTask;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;

public class MuleBeforeRunTask extends BeforeRunTask<MuleBeforeRunTask> {
    protected MuleBeforeRunTask(@NotNull Key providerId) {
        super(providerId);
    }



}
