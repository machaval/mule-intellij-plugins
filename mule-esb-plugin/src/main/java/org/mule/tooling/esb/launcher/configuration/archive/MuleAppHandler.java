package org.mule.tooling.esb.launcher.configuration.archive;


import com.intellij.execution.ExecutionException;
import com.intellij.openapi.module.Module;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public interface MuleAppHandler {

    @NotNull
    File getMuleApp(Module module) throws ExecutionException;

}
