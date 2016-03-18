package org.mule.lang.raml.psi.impl;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.raml.RamlLanguage;
import org.mule.lang.raml.editor.RamlStructureViewElement;
import org.mule.lang.raml.file.RamlFileType;
import org.mule.lang.raml.parser.RamlElementTypes;
import org.mule.lang.raml.psi.YamlFile;
import org.mule.lang.raml.psi.YamlSection;

import javax.swing.*;
import java.util.HashMap;

public class YamlFileImpl extends PsiFileBase implements YamlFile {
    public YamlFileImpl(FileViewProvider viewProvider) {
        super(viewProvider, RamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return RamlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "YamlFile:" + getName();
    }

    public HashMap<String, YamlSection> getSections() {
        HashMap<String, YamlSection> ret = new HashMap<String, YamlSection>();

        for (ASTNode node : getNode().getChildren(TokenSet.create(RamlElementTypes.KEY_VALUE_PAIR))) {
            YamlSection section = (YamlSection) node.getPsi();
            ret.put(section.getKeyText(), section);
        }

        return ret;
    }

    @NotNull
    @Override
    public PsiReference[] getReferences() {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this);
    }

    @Override
    public ItemPresentation getPresentation() {
        if (getVirtualFile().getCanonicalPath().endsWith("tasks/main.yml"))
            // Format role differently
            return new ItemPresentation() {
                @Nullable
                @Override
                public String getPresentableText() {
                    return "ROLE: " + getParent().getParent().getName();
                }

                @Nullable
                @Override
                public String getLocationString() {
                    return "(" + getParent().getParent().getParent().getParent().getName() + "/" +
                            getParent().getParent().getParent().getName()
                             + ")";
                }

                @Nullable
                @Override
                public Icon getIcon(boolean unused) {
                    return null;
                }
            };
        else
            return new RamlStructureViewElement(this);
    }
}
