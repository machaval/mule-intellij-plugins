package org.mule.tooling.lang.raml.util;

import com.intellij.psi.PsiFile;

public class RamlUtils
{
    public static boolean isRamlFile(PsiFile file)
    {
        if (file.getVirtualFile().getName().toLowerCase().endsWith(".raml"))
        {
            return true;
        }
        return false;
    }
}
