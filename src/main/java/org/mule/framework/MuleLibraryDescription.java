package org.mule.framework;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.NewLibraryConfiguration;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import com.intellij.openapi.roots.ui.configuration.libraryEditor.LibraryEditor;
import com.intellij.openapi.roots.ui.configuration.projectRoot.LibrariesContainer;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.mule.sdk.MuleSdk;

import javax.swing.*;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MuleLibraryDescription extends CustomLibraryDescription {

    private final String myEnvVariable;
    private final Set<? extends LibraryKind> myLibraryKinds;
    private final String myFrameworkName;

    public MuleLibraryDescription() {
        this("MULE_HOME", Collections.singleton(MuleLibraryPresentationProvider.libraryKind), MuleFrameworkType.MULE_FRAMEWORK_NAME);
    }

    private MuleLibraryDescription(@NotNull String envVariable, @NotNull final Set<? extends LibraryKind> libraryKinds, String frameworkName) {
        myEnvVariable = envVariable;
        myLibraryKinds = libraryKinds;
        myFrameworkName = frameworkName;
    }

    @NotNull
    @Override
    public Set<? extends LibraryKind> getSuitableLibraryKinds() {
        return myLibraryKinds;
    }

    @Override
    public NewLibraryConfiguration createNewLibrary(@NotNull JComponent parentComponent, VirtualFile contextDirectory) {
        final VirtualFile initial = findFile(System.getenv(myEnvVariable));

        final FileChooserDescriptor descriptor = new FileChooserDescriptor(false, true, false, false, false, false) {
            @Override
            public boolean isFileSelectable(VirtualFile file) {
                return super.isFileSelectable(file) && MuleSdk.isValidMuleHome(file.getCanonicalPath());
            }
        };
        descriptor.setTitle(myFrameworkName + " SDK");
        descriptor.setDescription("Choose a directory containing " + myFrameworkName + " distribution");
        final VirtualFile dir = FileChooser.chooseFile(descriptor, parentComponent, null, initial);
        if (dir == null || !MuleSdk.isValidMuleHome(dir.getCanonicalPath())) {
            return null;
        }
        final MuleSdk muleSdk = new MuleSdk(dir.getCanonicalPath());
        final String sdkVersion = muleSdk.getVersion();
        if (MuleSdk.UNDEFINED_VERSION.equals(sdkVersion)) {
            Messages.showErrorDialog(parentComponent,
                    "Looks like " + myFrameworkName + " distribution in specified path is broken. Cannot determine version.",
                    "Failed to Create Library");
            return null;
        }

        return new NewLibraryConfiguration("MuleESB -" + sdkVersion) {
            @Override
            public void addRoots(@NotNull LibraryEditor editor) {
                final List<File> libs = muleSdk.getLibs();
                for (File file : libs) {
                    editor.addRoot(VfsUtil.getUrlForLibraryRoot(file), OrderRootType.CLASSES);
                }
            }

        };
    }

    @Nullable
    private static VirtualFile findFile(String path) {
        if (path != null && !path.isEmpty()) {
            return LocalFileSystem.getInstance().findFileByPath(FileUtil.toSystemIndependentName(path));
        }
        return null;
    }

    @NotNull
    @Override
    public LibrariesContainer.LibraryLevel getDefaultLevel() {
        return LibrariesContainer.LibraryLevel.GLOBAL;
    }




}
