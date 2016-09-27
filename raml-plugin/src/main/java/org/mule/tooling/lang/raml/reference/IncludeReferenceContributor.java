package org.mule.tooling.lang.raml.reference;

import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.string;


public class IncludeReferenceContributor extends PsiReferenceContributor {

    public static final String INCLUDE_TAG = "!include";

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(psiElement()
                        .withText(string().startsWith(INCLUDE_TAG))
                , new IncludeFilePathReferenceProvider());
    }

}

