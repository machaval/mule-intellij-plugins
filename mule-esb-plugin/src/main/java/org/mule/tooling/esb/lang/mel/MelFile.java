package org.mule.tooling.esb.lang.mel;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class MelFile extends PsiFileBase {
    public MelFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MelLanguage.getInstance());
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MelFileType.getInstance();
    }
}
