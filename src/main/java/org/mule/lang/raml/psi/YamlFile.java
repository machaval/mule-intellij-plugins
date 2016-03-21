package org.mule.lang.raml.psi;

import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiFile;

import java.util.HashMap;

/**
 * Yaml file - just a wrapper for the whole file
 */
public interface YamlFile extends PsiFile, NavigatablePsiElement {
	/**
	 * get sections of config file
	 * (assumes first level hash-map consists of *config section*)
	 */
	public HashMap<String, YamlSection> getSections();
}
