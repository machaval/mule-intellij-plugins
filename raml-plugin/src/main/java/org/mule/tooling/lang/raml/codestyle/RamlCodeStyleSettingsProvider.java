package org.mule.tooling.lang.raml.codestyle;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.openapi.options.Configurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.yaml.YAMLCodeStyleSettingsProvider;
import org.jetbrains.yaml.YAMLLanguage;
import org.mule.tooling.lang.raml.RamlLanguage;

/**
 * Created by eberman on 4/18/17.
 */
public class RamlCodeStyleSettingsProvider extends YAMLCodeStyleSettingsProvider {
    @NotNull
    @Override
    public Configurable createSettingsPage(final CodeStyleSettings settings, final CodeStyleSettings originalSettings) {
        return new CodeStyleAbstractConfigurable(settings, originalSettings, RamlLanguage.INSTANCE.getDisplayName()) {
            @Override
            protected CodeStyleAbstractPanel createPanel(final CodeStyleSettings settings) {
                final CodeStyleSettings currentSettings = getCurrentSettings();
                final CodeStyleSettings settings1 = settings;
                return new TabbedLanguageCodeStylePanel(RamlLanguage.INSTANCE, currentSettings, settings1) {
                    @Override
                    protected void initTabs(final CodeStyleSettings settings) {
                        addIndentOptionsTab(settings);
                    }
                };
            }

            @Override
            public String getHelpTopic() {
                return "reference.settingsdialog.codestyle.yaml";
            }
        };
    }

    @Override
    public String getConfigurableDisplayName() {
        return RamlLanguage.INSTANCE.getDisplayName();
    }
}
