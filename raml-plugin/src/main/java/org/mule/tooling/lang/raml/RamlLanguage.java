package org.mule.tooling.lang.raml;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

public class RamlLanguage extends Language {
	// singleton
	public static final RamlLanguage INSTANCE = new RamlLanguage();
	public static final String MIME_TYPE = "application/raml";

	public RamlLanguage() {
		super("RAML");
	}

	@NotNull
	@Override
	public String getDisplayName() {
		return "RAML";
	}
}
