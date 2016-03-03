package org.mule.lang.raml.highlighter;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

/**
 * User: plducharme
 * Date: 10/02/14
 * Time: 11:22 AM
 * Description:
 */
public class DefaultHighlighter {

    static final String RAML_VERSION_ID = "RAML Version";
    static final String TITLE_ID = "title";
    static final String TITLE_VALUE_ID = "API title";

    static final String URL_PARAM_ID = "url parameter";
    static final String URL_PATH_ID = "url path";

    static final String UNKNOWN_ID = "Unknown token type";

    public static final TextAttributesKey RAML_VERSION = TextAttributesKey.createTextAttributesKey(RAML_VERSION_ID, DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey TITLE = TextAttributesKey.createTextAttributesKey(TITLE_ID, JavaHighlightingColors.STRING);
    public static final TextAttributesKey TITLE_VALUE = TextAttributesKey.createTextAttributesKey(TITLE_VALUE_ID, DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);

    public static final TextAttributesKey URL_PARAM = TextAttributesKey.createTextAttributesKey(URL_PARAM_ID, JavaHighlightingColors.STRING);
    public static final TextAttributesKey URL_PATH = TextAttributesKey.createTextAttributesKey(URL_PATH_ID, JavaHighlightingColors.STRING);

    public static final TextAttributesKey UNKNOWN = TextAttributesKey.createTextAttributesKey(UNKNOWN_ID, DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);

}
