package org.mule.lang.dw.highlighter;


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

public class WeaveColorSettingsPage implements ColorSettingsPage {
    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return WeaveSyntaxHighlighter.getInstance();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "%weave0.1\n" + "%output xml\n" + "---\n" + "{\n" + "  a: $a.b.c.d?,\n" + "  b: $a['b']['c']['d']?,\n" + "  c: $a['b'].c['d'].e?,\n" + "  d: $a.b[0][1]?,\n" + "  e: ['Mariano'][0]?\n}";
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
        return "Weave";
    }
}
