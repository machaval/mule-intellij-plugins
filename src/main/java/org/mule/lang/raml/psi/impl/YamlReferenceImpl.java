package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.mule.lang.raml.psi.YamlReference;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Pavels.Veretennikovs on 2015.05.20..
 */
public class YamlReferenceImpl extends YamlPsiElementImpl implements YamlReference {
    public YamlReferenceImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    @Override
    public PsiElement setName(String name) throws IncorrectOperationException {
        return null;
    }
}
