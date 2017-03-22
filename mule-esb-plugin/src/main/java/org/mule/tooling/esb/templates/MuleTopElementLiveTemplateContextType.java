package org.mule.tooling.esb.templates;

import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.xml.XmlTag;
import com.intellij.psi.xml.XmlText;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.util.MuleConfigUtils;

public class MuleTopElementLiveTemplateContextType extends TemplateContextType {
    public MuleTopElementLiveTemplateContextType() {
        super("MULE_TAG", "Mule Top Level Element", MuleConfigLiveTemplateContextType.class);
    }

    public boolean isInContext(@NotNull final PsiFile file, final int offset) {
        if (!MuleConfigUtils.isMuleFile(file)) {
            return false;
        }
        PsiElement element = file.findElementAt(offset);
        XmlTag parent = PsiTreeUtil.getParentOfType(element, XmlTag.class);

        return (element != null && parent != null && MuleConfigUtils.isMuleTag(parent));
    }
}