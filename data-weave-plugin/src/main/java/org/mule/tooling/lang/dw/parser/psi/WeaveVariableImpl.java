package org.mule.tooling.lang.dw.parser.psi;


import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class WeaveVariableImpl extends ASTWrapperPsiElement implements WeaveNamedElement, WeaveVariable {

    public WeaveVariableImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        return getVariableName();
    }

    @Nullable
    @Override
    public WeaveExpression getVariableValue() {
        return getExpression();
    }

    @Nullable
    @Override
    public String getVariableName() {
        final WeaveIdentifier identifier = getIdentifier();
        return identifier != null ? identifier.getName() : "";
    }

    public PsiElement setName(String newName) {
        ASTNode keyNode = getIdentifier().getNode();
        if (keyNode != null) {
            WeaveIdentifier property = WeaveElementFactory.createIdentifier(getProject(), newName);
            getNode().replaceChild(keyNode, property.getNode());
        }
        return this;
    }

    public PsiElement getNameIdentifier() {
        ASTNode keyNode = getIdentifier().getNode();
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    @Nullable
    public abstract WeaveIdentifier getIdentifier();

    @Nullable
    public abstract WeaveExpression getExpression();
}
