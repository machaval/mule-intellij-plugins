package org.mule.lang.raml;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.util.MuleIcons;

import javax.swing.*;


public class RamlFileType extends LanguageFileType {

    private static RamlFileType instance = new RamlFileType();

    protected RamlFileType() {
        super(RamlLanguage.getInstance());
    }

    @NotNull
    @Override
    public String getName() {
        return "RAML";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "RAML";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "raml";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return MuleIcons.RamlFileType;
    }

    public static RamlFileType getInstance(){
        return instance;
    }
}
