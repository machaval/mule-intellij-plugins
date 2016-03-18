package org.mule.lang.raml.psi;

import com.intellij.psi.PsiNamedElement;

/**
 * Key-value pair, part of NeonHash
 */
public interface YamlKeyValPair extends PsiNamedElement {
	// key
	public YamlKey getKey();
	public String getKeyText();

	// value
	public YamlValue getValue();
	public String getValueText();
}
