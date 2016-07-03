package org.mule.tooling.esb.framework;

import com.intellij.openapi.roots.libraries.PersistentLibraryKind;
import org.jetbrains.annotations.NotNull;

public class MuleLibraryKind extends PersistentLibraryKind<MuleLibraryProperties>
{
    public static MuleLibraryKind MULE_LIBRARY_KIND = new MuleLibraryKind();

    public MuleLibraryKind()
    {
        super("Mule");
    }

    @NotNull
    @Override
    public MuleLibraryProperties createDefaultProperties()
    {
        return new MuleLibraryProperties();
    }
}
