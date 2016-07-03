package org.mule.tooling.esb.framework;

import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.roots.libraries.LibraryProperties;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.sdk.MuleSdk;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;
import java.util.List;

public class MuleLibraryPresentationProvider extends LibraryPresentationProvider<MuleLibraryProperties> {

    public MuleLibraryPresentationProvider() {
        super(MuleLibraryKind.MULE_LIBRARY_KIND);
    }

    @Override
    public String getDescription(@NotNull MuleLibraryProperties properties) {
        return String.format("Mule - %s", properties.getVersion());
    }

    @Override
    public MuleLibraryProperties detect(@NotNull List<VirtualFile> classesRoots) {
        final VirtualFile[] libraryFiles = VfsUtilCore.toVirtualFileArray(classesRoots);
        for (VirtualFile libraryFile : libraryFiles) {
            final String muleHome = MuleSdk.getMuleHome(libraryFile.getCanonicalFile());
            if(muleHome != null){
                return new MuleLibraryProperties(new MuleSdk(muleHome));
            }
        }
        return null;
    }

    @Nullable
    @Override
    public Icon getIcon(@Nullable LibraryProperties properties) {
        return MuleIcons.MuleIcon;
    }

}
