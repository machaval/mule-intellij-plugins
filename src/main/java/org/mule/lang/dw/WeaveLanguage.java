package org.mule.lang.dw;

import com.intellij.lang.Language;


public class WeaveLanguage extends Language {

    public static final String WEAVE_LANGUAGE_ID = "Weave";
    private static WeaveLanguage instance = new WeaveLanguage();

    protected WeaveLanguage() {
        super(WEAVE_LANGUAGE_ID);
    }

    public static WeaveLanguage getInstance(){
        return instance;
    }
}
