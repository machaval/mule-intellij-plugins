package org.mule.framework;

import com.intellij.openapi.roots.libraries.LibraryProperties;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.Nullable;
import org.mule.sdk.MuleSdk;

public class MuleLibraryProperties extends LibraryProperties<MuleSdk>
{
    private MuleSdk muleSdk;

    public MuleLibraryProperties(MuleSdk version)
    {
        muleSdk = version;
    }

    public MuleLibraryProperties()
    {
    }

    @Nullable
    public String getVersion()
    {
        return muleSdk.getVersion();
    }

    @Override
    public MuleSdk getState()
    {
        return muleSdk;
    }

    @Override
    public void loadState(MuleSdk state)
    {
        this.muleSdk = state;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MuleLibraryProperties that = (MuleLibraryProperties) o;

        return muleSdk != null ? muleSdk.equals(that.muleSdk) : that.muleSdk == null;

    }

    @Override
    public int hashCode()
    {
        return muleSdk != null ? muleSdk.hashCode() : 0;
    }
}
