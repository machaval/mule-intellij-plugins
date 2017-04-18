package org.mule.tooling.lang.raml.codestyle;

import com.intellij.lang.Language;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.yaml.YAMLLanguageCodeStyleSettingsProvider;
import org.mule.tooling.lang.raml.RamlLanguage;

/**
 * Created by eberman on 4/18/17.
 */
public class RamlLanguageCodeStyleSettingsProvider extends YAMLLanguageCodeStyleSettingsProvider {
    @NotNull
    @Override
    public Language getLanguage() {
        return RamlLanguage.INSTANCE;
    }

    @Override
    public CommonCodeStyleSettings getDefaultCommonSettings() {
        CommonCodeStyleSettings settings = new CommonCodeStyleSettings(RamlLanguage.INSTANCE);
        CommonCodeStyleSettings.IndentOptions indentOptions = settings.initIndentOptions();
        indentOptions.INDENT_SIZE = 2;
//        indentOptions.CONTINUATION_INDENT_SIZE = 8;
        indentOptions.TAB_SIZE = 2;
        indentOptions.USE_TAB_CHARACTER = false;
        return settings;
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType) {

        return "#%RAML 0.8\n" +
                "title: ACME API\n" +
                "version: 0.1\n" +
                "baseUri: http://localhost:9443/acme/api\n" +
                "mediaType: application/json\n" +
                "\n" +
                "/gadget:\n" +
                "  post:\n" +
                "    displayName: Create a new Gadget\n" +
                "    body:\n" +
                "      application/json:\n" +
                "        example: !include common/examples/CreateGadgetRequest.json\n" +
                "        schema: !include common/schema/gadget.json\n" +
                "    responses:\n" +
                "      200:\n" +
                "        body:\n" +
                "          application/json:\n" +
                "            example: !include acme-api/examples/CreateGadgetResponse.json\n" +
                "  /{id}:\n" +
                "    displayName: Update an existing Gadget\n" +
                "    put:\n" +
                "      body:\n" +
                "        application/json:\n" +
                "          example: !include common/examples/UpdateGadgetRequest.json\n" +
                "          schema: !include common/schema/gadget.json\n" +
                "      responses:\n" +
                "        200:\n" +
                "          body:\n" +
                "            application/json:\n" +
                "              example: !include acme-api/examples/UpdateGadgetResponse.json\n";
    }

//    @Override
//    public CommonCodeStyleSettings getDefaultCommonSettings() {
//        CommonCodeStyleSettings defaultSettings = new CommonCodeStyleSettings( getLanguage() );
//        CommonCodeStyleSettings.IndentOptions indentOptions = defaultSettings.initIndentOptions();
//        indentOptions.INDENT_SIZE = 4;
//        indentOptions.CONTINUATION_INDENT_SIZE = 8;
//        indentOptions.TAB_SIZE = 4;
//        indentOptions.USE_TAB_CHARACTER = true;
//
//        defaultSettings.LINE_COMMENT_AT_FIRST_COLUMN = false;
//        defaultSettings.KEEP_FIRST_COLUMN_COMMENT = false;
//
//        return defaultSettings;
//    }
}
