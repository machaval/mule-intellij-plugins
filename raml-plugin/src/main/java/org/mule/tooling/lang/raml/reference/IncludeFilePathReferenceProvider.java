package org.mule.tooling.lang.raml.reference;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReference;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet;
import com.intellij.util.ProcessingContext;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.mule.tooling.lang.raml.reference.IncludeReferenceContributor.INCLUDE_TAG;

/**
 * @author cdr
 */
public class IncludeFilePathReferenceProvider extends PsiReferenceProvider {

    private final boolean myEndingSlashNotAllowed;

    public IncludeFilePathReferenceProvider() {
        this(true);
    }

    public IncludeFilePathReferenceProvider(boolean endingSlashNotAllowed) {
        myEndingSlashNotAllowed = endingSlashNotAllowed;
    }


    @NotNull
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                 String text,
                                                 int offset) {
        return new FileReferenceSet(text, element, offset, this, true, myEndingSlashNotAllowed).getAllReferences();
    }

    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        String fileName = element.getText().substring(INCLUDE_TAG.length()).trim();
        PsiReference[] referencesByElement = getReferencesByElement(element, fileName, element.getText().length() - fileName.length());
        return referencesByElement;
    }

}