package org.mule.tooling.esb.lang.mel.highlighter;


import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MelColorSettingsPage implements ColorSettingsPage {
    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return MelSyntaxHighlighter.getInstance();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "import java.lang.*;\n" +
                "def funcName() {\n" +
                "\n" +
                "    b instanceOf c\n" +
                "\n" +
                "\n" +
                "    for(a: name){\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    a.b.?c\n" +
                "\n" +
                "    a[\"b\"]\n" +
                "\n" +
                "    c[1]\n" +
                "\n" +
                "    new ArrayList();\n" +
                "\n" +
                "\n" +
                "\n" +
                "    while(a == b){\n" +
                "    }\n" +
                "\n" +
                "    for(int i = 0; i < payload.lenght ; i ++) {\n" +
                "        print(\"a\")\n" +
                "    }\n" +
                "\n" +
                "    do{\n" +
                "     a = \"\"\n" +
                "    }while(a > b)\n" +
                "\n" +
                "    if(a) {\n" +
                "      String a=\"\";\n" +
                "    }\n" +
                "    else {\n" +
                "    }\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return new HashMap<>();
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return new AttributesDescriptor[0];
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Mel";
    }
}
