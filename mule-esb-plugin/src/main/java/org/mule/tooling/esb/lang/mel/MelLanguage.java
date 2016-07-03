package org.mule.tooling.esb.lang.mel;


import com.intellij.lang.Language;

public class MelLanguage extends Language {

    public static final String MEL_LANGUAGE_ID = "Mel";
    private static MelLanguage instance = new MelLanguage();

    protected MelLanguage() {
        super(MEL_LANGUAGE_ID);
    }

    public static MelLanguage getInstance() {
        return instance;
    }
}
