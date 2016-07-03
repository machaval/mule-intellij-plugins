package org.mule.tooling.lang.raml.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.lang.raml.RamlLanguage;
import org.mule.tooling.lang.raml.util.RamlIcons;

import javax.swing.*;

public class RamlFileType extends LanguageFileType
{
    public static final RamlFileType INSTANCE = new RamlFileType();

    public static final String EXTENSIONS = "raml";

    public static RamlFileType getInstance()
    {
        return INSTANCE;
    }

    protected RamlFileType()
    {
        super(RamlLanguage.INSTANCE);
    }

    @NotNull
    public String getName()
    {
        return "Raml";
    }

    @NotNull
    public String getDescription()
    {
        return "Raml File";
    }

    @NotNull
    public String getDefaultExtension()
    {
        return "raml";
    }

    @NotNull
    public Icon getIcon()
    {
        return RamlIcons.RamlFileType;
    }
}

