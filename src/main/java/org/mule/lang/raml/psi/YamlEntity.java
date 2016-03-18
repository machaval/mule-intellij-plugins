package org.mule.lang.raml.psi;

import com.intellij.psi.PsiNamedElement;

/**
 * Entity - identifier with arguments
 */
public interface YamlEntity extends YamlValue, PsiNamedElement {
	public YamlArray getArgs();
}
