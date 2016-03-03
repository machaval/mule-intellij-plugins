package org.mule.lang.raml;


import com.intellij.lang.Language;

public class RamlLanguage extends Language {

    public static final String RAML_LANGUAGE_ID = "RAML";
    private static RamlLanguage instance = new RamlLanguage();

    protected RamlLanguage() {
        super(RAML_LANGUAGE_ID);
    }

    public static RamlLanguage getInstance() {
        return instance;
    }
}
