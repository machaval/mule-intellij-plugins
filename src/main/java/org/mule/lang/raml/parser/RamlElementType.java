package org.mule.lang.raml.parser;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.raml.RamlLanguage;


public class RamlElementType extends IElementType {
	public RamlElementType(@NotNull String debugName) {
		super(debugName, RamlLanguage.INSTANCE);
	}

	public String toString() {
		return "[RAML] " + super.toString();
	}
}
