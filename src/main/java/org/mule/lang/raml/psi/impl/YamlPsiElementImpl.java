package org.mule.lang.raml.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import org.jetbrains.annotations.NotNull;

/**
 * Base of all PsiElements (or unknown/not-recognized elements)
 */
public class YamlPsiElementImpl extends ASTWrapperPsiElement implements NavigatablePsiElement {
    public YamlPsiElementImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @NotNull
    @Override
    public PsiReference[] getReferences()
    {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }
}
