package org.mule.tooling.lang.dw.util;

import org.jetbrains.annotations.NotNull;
import org.mule.tooling.lang.dw.parser.psi.WeaveDirective;
import org.mule.tooling.lang.dw.parser.psi.WeaveHeader;
import org.mule.tooling.lang.dw.parser.psi.WeaveInputDirective;
import org.mule.tooling.lang.dw.parser.psi.WeaveOutputDirective;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eberman on 11/4/16.
 */
public class WeaveUtils {

    @NotNull
    public static List<WeaveInputDirective> getInputDirectiveList(@NotNull WeaveHeader header) {
        List<WeaveInputDirective> inputDirectiveList = new ArrayList<WeaveInputDirective>();
        for (WeaveDirective directive : header.getDirectiveList()) {
            if (directive instanceof WeaveInputDirective) {
                inputDirectiveList.add((WeaveInputDirective) directive);
            }
        }
        return inputDirectiveList;
    }

    @NotNull
    public static List<WeaveOutputDirective> getOutputDirectiveList(@NotNull WeaveHeader header) {
        List<WeaveOutputDirective> outputDirectiveList = new ArrayList<WeaveOutputDirective>();
        for (WeaveDirective directive : header.getDirectiveList()) {
            if (directive instanceof WeaveOutputDirective) {
                outputDirectiveList.add((WeaveOutputDirective) directive);
            }
        }
        return outputDirectiveList;
    }
}
