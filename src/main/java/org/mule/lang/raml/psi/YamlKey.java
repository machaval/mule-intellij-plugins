package org.mule.lang.raml.psi;

import com.intellij.navigation.ItemPresentation;

/**
 * Key from key-value pair
 */
public interface YamlKey extends YamlPsiElement {
	String getKeyText();
	ItemPresentation getPresentation();
}
