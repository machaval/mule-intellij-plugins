package org.mule.templates;

import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.xml.XmlText;
import org.jetbrains.annotations.NotNull;
import org.mule.util.MuleConfigUtils;

public class MuleConfigLiveTemplateContextType extends TemplateContextType
{
  public MuleConfigLiveTemplateContextType() {
    super("MULE_CONFIG", "Mule Config");
  }

  public boolean isInContext(@NotNull final PsiFile file, final int offset)
  {
    if (!MuleConfigUtils.isMuleFile(file))
    {
        return false;
    }
    PsiElement element = file.findElementAt(offset);
    return element != null && PsiTreeUtil.getParentOfType(element, XmlText.class) != null;
  }
}