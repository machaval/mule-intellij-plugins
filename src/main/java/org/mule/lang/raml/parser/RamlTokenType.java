package org.mule.lang.raml.parser;

import com.intellij.psi.tree.IElementType;
import org.mule.lang.raml.RamlLanguage;
import org.jetbrains.annotations.NotNull;


public class RamlTokenType extends IElementType {
	public RamlTokenType(@NotNull String debugName) {
		super(debugName, RamlLanguage.getInstance());
	}

	public String toString() {
		return "[Raml] " + super.toString();
	}
}
