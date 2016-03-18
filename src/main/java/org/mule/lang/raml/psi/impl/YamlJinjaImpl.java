package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import org.mule.lang.raml.psi.YamlJinja;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Pavels.Veretennikovs on 2015.05.20..
 */
public class YamlJinjaImpl extends YamlPsiElementImpl implements YamlJinja {
    public YamlJinjaImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }
    public String toString() {
        return "Yaml Jinja2";
    }

}
