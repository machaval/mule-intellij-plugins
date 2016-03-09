package org.mule.lang.raml;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.mel.MelLanguage;

public class RamlFile extends PsiFileBase {
    public RamlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RamlLanguage.getInstance());
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return RamlFileType.getInstance();
    }
}
