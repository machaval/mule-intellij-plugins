package org.mule.util;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.sdk.MuleSdk;

import javax.swing.*;

public class MuleUIUtils
{
    @Nullable public static MuleSdk selectSdk(@NotNull JComponent parentComponent)
    {
        final VirtualFile initial = findFile(System.getenv("MULE_HOME"));

        final FileChooserDescriptor descriptor = new FileChooserDescriptor(false, true, false, false, false, false)
        {
            @Override
            public boolean isFileSelectable(VirtualFile file)
            {
                return super.isFileSelectable(file) && MuleSdk.isValidMuleHome(file.getCanonicalPath());
            }
        };
        descriptor.setTitle("Mule SDK");
        descriptor.setDescription("Choose a directory containing Mule distribution");
        final VirtualFile dir = FileChooser.chooseFile(descriptor, parentComponent, null, initial);
        if (dir == null || !MuleSdk.isValidMuleHome(dir.getCanonicalPath()))
        {
            return null;
        }
        return new MuleSdk(dir.getCanonicalPath());
    }

    @Nullable
    private static VirtualFile findFile(String path)
    {
        if (path != null && !path.isEmpty())
        {
            return LocalFileSystem.getInstance().findFileByPath(FileUtil.toSystemIndependentName(path));
        }
        return null;
    }
}
