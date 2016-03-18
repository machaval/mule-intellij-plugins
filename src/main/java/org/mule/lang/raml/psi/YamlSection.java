package org.mule.lang.raml.psi;

import com.intellij.psi.PsiNamedElement;

/**
 * Section is a special type of key-val pair - in first indention level
 * TODO: for future version
 */
public interface YamlSection extends YamlKeyValPair, PsiNamedElement {
	// for section inheritance
	public YamlKey getParentSection();
	public String getParentSectionText();
}
