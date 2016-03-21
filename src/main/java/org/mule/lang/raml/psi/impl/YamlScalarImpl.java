package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import org.mule.lang.raml.editor.RamlStructureViewElement;
import org.mule.lang.raml.psi.YamlScalar;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class YamlScalarImpl extends YamlPsiElementImpl implements YamlScalar {
	public YamlScalarImpl(@NotNull ASTNode astNode) {
		super(astNode);
	}

	public String toString() {
		return "Yaml scalar";
	}

	@Override
	public String getValueText() {
		return getNode().getText();
	}

	@Override
	public String getName() {
		return getValueText();
	}

	@Override
	public ItemPresentation getPresentation() {
		return new RamlStructureViewElement(this);
	}
}
