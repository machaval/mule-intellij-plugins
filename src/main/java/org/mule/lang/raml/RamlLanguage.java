package org.mule.lang.raml;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class RamlLanguage extends Language {
	// singleton
	public static final RamlLanguage INSTANCE = new RamlLanguage();
	public static final String MIME_TYPE = "application/x-yaml";
	public static final String MIME_TYPE2 = "application/yaml";

	public RamlLanguage() {
		super("RAML");
	}

	@NotNull
	@Override
	public String getDisplayName() {
		return "Raml";
	}
}
