package org.mule.lang.raml.editor;

import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.xml.breadcrumbs.BreadcrumbsInfoProvider;
import org.mule.lang.raml.RamlLanguage;
import org.mule.lang.raml.psi.YamlEntity;
import org.mule.lang.raml.psi.YamlKeyValPair;
import org.jetbrains.annotations.NotNull;

/**
 * Breadcrumbs info about which section are we editing now (just above the editor, below tabs)
 */
public class RamlBreadcrumbsInfoProvider extends BreadcrumbsInfoProvider {
	private final Language[] ourLanguages = {RamlLanguage.INSTANCE};

	@Override
	public Language[] getLanguages() {
		return ourLanguages;
	}

	@Override
	public boolean acceptElement(@NotNull PsiElement e) {
		return (e instanceof YamlKeyValPair) || (e instanceof YamlEntity);
	}

	@NotNull
	@Override
	public String getElementInfo(@NotNull PsiElement e) {
		if (e instanceof YamlKeyValPair) {
			return ((YamlKeyValPair) e).getKeyText();

		} else if (e instanceof YamlEntity) {
			String name = ((YamlEntity) e).getName();
			return name != null ? name : "??";

		} else {
			return "??";
		}
	}

	@Override
	public String getElementTooltip(@NotNull PsiElement e) {
		return e.toString();
	}

}
