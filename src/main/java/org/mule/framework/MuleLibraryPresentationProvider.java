package org.mule.framework;

import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.roots.libraries.LibraryProperties;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.sdk.MuleSdk;
import org.mule.util.MuleIcons;

import javax.swing.*;
import java.util.List;

public class MuleLibraryPresentationProvider extends LibraryPresentationProvider<MuleLibraryProperties> {

    public static LibraryKind libraryKind = new LibraryKind("Mule");

    public MuleLibraryPresentationProvider() {
        super(libraryKind);
    }

    @Override
    public String getDescription(@NotNull MuleLibraryProperties properties) {
        return String.format("Mule - %s", properties.getVersion());
    }

    @Override
    public MuleLibraryProperties detect(@NotNull List<VirtualFile> classesRoots) {
        final VirtualFile[] libraryFiles = VfsUtilCore.toVirtualFileArray(classesRoots);
        for (VirtualFile libraryFile : libraryFiles) {
            final String muleHome = MuleSdk.getMuleHome(libraryFile);
            if(muleHome != null){
                return new MuleLibraryProperties(new MuleSdk(muleHome).getVersion());
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
