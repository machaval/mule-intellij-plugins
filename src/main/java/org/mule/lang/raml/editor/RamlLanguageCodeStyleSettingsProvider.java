package org.mule.lang.raml.editor;

import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.IndentOptions;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.mule.lang.raml.RamlLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * Code style settings (tabs etc)
 */
public class RamlLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider
{
	public CommonCodeStyleSettings getDefaultCommonSettings()
	{
		CommonCodeStyleSettings defaultSettings = new CommonCodeStyleSettings(RamlLanguage.INSTANCE);
		IndentOptions indentOptions = defaultSettings.initIndentOptions();
		indentOptions.INDENT_SIZE = 2;
		indentOptions.TAB_SIZE = 2;
		indentOptions.USE_TAB_CHARACTER = false;
		indentOptions.SMART_TABS = false;

		return defaultSettings;
	}

	public IndentOptionsEditor getIndentOptionsEditor()
	{
		return new IndentOptionsEditor();
	}

	@NotNull
	public Language getLanguage() {
		return RamlLanguage.INSTANCE;
	}

	public String getCodeSample(@NotNull SettingsType settingsType) {
		return "product:\n  name: Yaml\n  version: 4\n  vendor: vermut@kid.lv\n  url: \"https://github.com/vermut/intellij-ansible/\"";
	}
}
