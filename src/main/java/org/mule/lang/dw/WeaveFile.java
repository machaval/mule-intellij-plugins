package org.mule.lang.dw;


import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.dw.parser.psi.WeaveDocument;

public class WeaveFile extends PsiFileBase {
    public WeaveFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, WeaveLanguage.getInstance());
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return WeaveFileType.getInstance();
    }

    public WeaveDocument getDocument() {
        return getChildren().length > 0 ? (WeaveDocument) getChildren()[0] : null;
    }

}
