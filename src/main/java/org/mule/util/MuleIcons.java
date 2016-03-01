package org.mule.util;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;
import java.net.URL;

public class MuleIcons {
    public static final Icon MuleIcon = IconLoader.findIcon("/mulesoft-icon.png");
    public static final Icon MUnitIcon = IconLoader.findIcon("/munit-icon.png");
    public static final Icon MuleFlow = IconLoader.findIcon("/flow.png");
    public static final Icon MuleSubFlow = IconLoader.findIcon("/sub-flow.png");
    public static final Icon MuleFileType = IconLoader.findIcon("/mule_type.png");
    public static final Icon MUnitFileType = IconLoader.findIcon("/munit_type.png");
    public static final Icon DataFileType = IconLoader.findIcon("/weave_type.png");
    public static final Icon MelFileType = IconLoader.findIcon("/mel_type.png");

    private MuleIcons() {
        super();
    }

}