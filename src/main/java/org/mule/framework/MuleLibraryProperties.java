package org.mule.framework;

import com.intellij.openapi.roots.libraries.LibraryProperties;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.Nullable;

public class MuleLibraryProperties extends LibraryProperties<MuleLibraryProperties> {
    private final String myVersion;

    public MuleLibraryProperties(String version) {
        myVersion = version;
    }

    @Nullable
    public String getVersion() {
        return myVersion;
    }

    @Override
    public MuleLibraryProperties getState() {
        return null;
    }

    @Override
    public void loadState(MuleLibraryProperties state) {
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MuleLibraryProperties && Comparing.equal(myVersion, ((MuleLibraryProperties) obj).myVersion);
    }

    @Override
    public int hashCode() {
        return myVersion != null ? myVersion.hashCode() : 0;
    }

}
