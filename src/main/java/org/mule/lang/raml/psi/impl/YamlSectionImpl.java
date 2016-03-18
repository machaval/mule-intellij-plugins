package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.mule.lang.raml.parser.RamlElementTypes;
import org.mule.lang.raml.psi.YamlKey;
import org.mule.lang.raml.psi.YamlSection;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class YamlSectionImpl extends YamlKeyValPairImpl implements YamlSection {
	public YamlSectionImpl(@NotNull ASTNode astNode) {
		super(astNode);
	}

	public String toString() {
		return "Yaml section";
	}

	@Override
	public YamlKey getParentSection() {
		if (getNode().getFirstChildNode().getElementType() == RamlElementTypes.COMPOUND_KEY) {
			return (YamlKey) getNode().getFirstChildNode().getPsi();
		} else {
			return null;
		}
	}

	@Override
	public String getParentSectionText() {
		PsiElement tmp = getParentSection();
		return tmp == null ? null : tmp.getText();
	}
}
