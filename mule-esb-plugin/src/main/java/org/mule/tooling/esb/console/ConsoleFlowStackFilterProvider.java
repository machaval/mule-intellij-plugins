package org.mule.tooling.esb.console;

import com.intellij.execution.filters.ConsoleFilterProvider;
import com.intellij.execution.filters.Filter;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created by eberman on 5/31/16.
 */
public class ConsoleFlowStackFilterProvider implements ConsoleFilterProvider {

    static final Logger logger = Logger.getInstance(ConsoleFlowStackFilterProvider.class);

    @NotNull
    @Override
    public Filter[] getDefaultFilters(@NotNull Project project) {
        logger.debug("*** GET DEFAULT FILTERS ");
        return new Filter[] { new ConsoleFlowStackFilter(project) };
    }
}