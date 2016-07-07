package org.mule.tooling.esb.config;


import com.intellij.lang.Language;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlTag;
import com.intellij.psi.xml.XmlText;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.lang.mel.MelLanguage;
import org.mule.tooling.esb.util.MuleConfigUtils;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;

public class MuleLanguageInjector implements LanguageInjector {


    public static final String EXPRESSION_PREFIX = "#[";
    public static final String DEFAULT_MULE_LANG = "mel";
    private static final String WEAVE_LANGUAGE_ID = "Weave";

    private static List<Pair<String, String>> languages = Arrays.asList(Pair.create("xpath", "XPath"), Pair.create("groovy", "Groovy"), Pair.create(DEFAULT_MULE_LANG, MelLanguage.MEL_LANGUAGE_ID));

    private QName globalFunctions = new QName("http://www.mulesoft.org/schema/mule/core", "global-functions");
    //Expression Component
    private QName expressionComponent = new QName("http://www.mulesoft.org/schema/mule/core", "expression-component");
    private QName expressionTransformer = new QName("http://www.mulesoft.org/schema/mule/core", "expression-transformer");
    //Scripting elements
    private QName scriptingScript = new QName("http://www.mulesoft.org/schema/mule/scripting", "script");

    //Data Weave Message Processor
    private QName dwSetPayload = new QName("http://www.mulesoft.org/schema/mule/ee/dw", "set-payload");
    private QName dwSetProperty = new QName("http://www.mulesoft.org/schema/mule/ee/dw", "set-property");
    private QName dwSetVariable = new QName("http://www.mulesoft.org/schema/mule/ee/dw", "set-variable");
    private QName dwSetSessionVar = new QName("http://www.mulesoft.org/schema/mule/ee/dw", "set-session-variable");


    @Override
    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost host,
                                     @NotNull InjectedLanguagePlaces injectedLanguagePlaces) {
        if (MuleConfigUtils.isMuleFile(host.getContainingFile())) {
            if (host instanceof XmlAttributeValue) {
                // Try to inject a language, somewhat abusing the lazy evaluation of predicates :(
                for (Pair<String, String> language : languages) {
                    if (tryInjectLanguage(language.getFirst(), language.getSecond(), host, injectedLanguagePlaces)) {
                        break;
                    }
                }
            } else if (host instanceof XmlText) {
                final XmlTag tag = ((XmlText) host).getParentTag();
                if (tag != null) {
                    final QName tagName = MuleConfigUtils.getQName(tag);
                    if (tagName.equals(globalFunctions) || tagName.equals(expressionComponent) || tagName.equals(expressionTransformer)) {
                        final String scriptingName = MelLanguage.MEL_LANGUAGE_ID;
                        injectLanguage(host, injectedLanguagePlaces, scriptingName);
                    } else if (tagName.equals(scriptingScript)) {
                        final String engine = tag.getAttributeValue("engine");
                        if (engine != null) {
                            injectLanguage(host, injectedLanguagePlaces, StringUtil.capitalize(engine));
                        }
                    } else if (tagName.equals(dwSetPayload) || tagName.equals(dwSetProperty) || tagName.equals(dwSetVariable) || tagName.equals(dwSetSessionVar)) {
                        injectLanguage(host, injectedLanguagePlaces, WEAVE_LANGUAGE_ID);
                    }
                }
            }
        }
    }

    private void injectLanguage(@NotNull PsiLanguageInjectionHost host, @NotNull InjectedLanguagePlaces injectedLanguagePlaces, String scriptingName) {
        final Language requiredLanguage = Language.findLanguageByID(scriptingName);
        if (requiredLanguage != null) {
            final TextRange range = TextRange.from(0, host.getTextRange().getLength());
            injectedLanguagePlaces.addPlace(requiredLanguage, range, null, null);
        }
    }


    private boolean tryInjectLanguage(@NotNull String langPrefix,
                                      @NotNull String languageId,
                                      @NotNull PsiLanguageInjectionHost host,
                                      @NotNull InjectedLanguagePlaces injectedLanguagePlaces) {
        if (isExpectedLocalName(langPrefix, host)) {
            injectLanguage(langPrefix, languageId, host, injectedLanguagePlaces);
            return true;
        }
        return false;
    }

    private boolean isExpectedLocalName(@NotNull String langPrefix,
                                        @NotNull PsiLanguageInjectionHost psiLanguageInjectionHost) {

        final XmlAttributeValue attributeValue = (XmlAttributeValue) psiLanguageInjectionHost;
        final String expressionText = attributeValue.getValue();
        return expressionText.startsWith(getLanguagePrefix(langPrefix)) && expressionText.endsWith("]");
    }

    @NotNull
    private String getLanguagePrefix(@NotNull String langPrefix) {
        return langPrefix.equals(DEFAULT_MULE_LANG) ? EXPRESSION_PREFIX : (EXPRESSION_PREFIX + langPrefix + ":");
    }


    private void injectLanguage(String langPrefix, @NotNull String languageId,
                                @NotNull PsiLanguageInjectionHost host,
                                @NotNull InjectedLanguagePlaces injectedLanguagePlaces) {
        // Find the required Language
        final Language requiredLanguage = Language.findLanguageByID(languageId);
        if (requiredLanguage == null) {
            return;
        }
        final TextRange textRange = ((XmlAttributeValue) host).getValueTextRange();
        final int length = getLanguagePrefix(langPrefix).length() + 1;
        final TextRange expressionTextRange = TextRange.from(length, textRange.getLength() - length);
        injectedLanguagePlaces.addPlace(requiredLanguage, expressionTextRange, null, null);
    }


}
