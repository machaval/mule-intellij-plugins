package org.mule.lang.raml.editor;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.raml.psi.*;
import org.mule.util.MuleIcons;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class RamlStructureViewElement extends PsiTreeElementBase<PsiElement> {

    public RamlStructureViewElement(PsiElement element) {
        super(element);
    }

    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        List<StructureViewTreeElement> elements = new ArrayList<StructureViewTreeElement>();
        PsiElement element = getElement();
        if (element instanceof YamlFile) {
            if (element.getChildren().length == 1 && element.getChildren()[0] instanceof YamlArray) { // top level array -> show it's elements
                addArrayElements(elements, element.getChildren()[0]);
            } else { // file children directly
                addArrayElements(elements, element);
            }
        } else if (element instanceof YamlKeyValPair && ((YamlKeyValPair) element).getValue() instanceof YamlArray) {
            addArrayElements(elements, ((YamlKeyValPair) element).getValue());
        } else if (element instanceof YamlArray) {
            addArrayElements(elements, element);
        }

        return elements;
    }

    private void addArrayElements(List<StructureViewTreeElement> elements, PsiElement firstValue) {
        for (PsiElement child : firstValue.getChildren()) {
            elements.add(new RamlStructureViewElement(child));
        }
    }

    @Override
    @Nullable
    public String getPresentableText() {
        PsiElement element = getElement();
        if (element instanceof YamlFile) {
            return ((YamlFile) element).getName();
        } else if (element instanceof YamlArray) {
            return "array";
        } else if (element instanceof YamlKeyValPair) {
            return ((YamlKeyValPair) element).getKeyText();
        } else if (element instanceof YamlKey) {
            return ((YamlKey) element).getKeyText();
        } else if (element instanceof YamlValue) {
            return element.getText();
        } else {
            return null;
        }
    }

    @Override
    @Nullable
    public String getLocationString() {
        return null;
    }

    @Nullable
    @Override
    public Icon getIcon(boolean unused) {
        return MuleIcons.RamlFileType;
    }
}
