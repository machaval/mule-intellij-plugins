package org.mule.tooling.esb.toolwindow;

import com.intellij.openapi.roots.ui.CellAppearanceEx;
import com.intellij.openapi.roots.ui.util.CompositeAppearance;
import com.intellij.psi.PsiElement;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.SimpleTextAttributes;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by eberman on 3/28/17.
 */
public class GlobalConfigsNodeRenderer extends ColoredTreeCellRenderer {
    public GlobalConfigsNodeRenderer() {
    }

    public void customizeCellRenderer(@NotNull JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        CellAppearanceEx appearanceEx = forNodeDescriptorInTree(value, expanded);
        if (appearanceEx != null)
            appearanceEx.customize(this);
    }

    public static CellAppearanceEx forNodeDescriptorInTree(Object node, boolean expanded) {
        PsiElement psiElement = getPsiElement(node);

        CompositeAppearance result = null;

        if (psiElement != null) {
            if (psiElement instanceof XmlFile) {
                result = CompositeAppearance.single(((XmlFile) psiElement).getName(), SimpleTextAttributes.GRAYED_BOLD_ATTRIBUTES);
                result.setIcon(MuleIcons.MuleFileType);
            } else {
                CompositeAppearance.DequeEnd ending = (new CompositeAppearance()).getEnding();
                XmlTag nextTag = (XmlTag) psiElement;
                String nextConnectorName = nextTag.getAttributeValue("name");
                String connectorType = nextTag.getName();
                ending.addText(nextConnectorName);
                ending.addComment(connectorType, SimpleTextAttributes.GRAYED_ITALIC_ATTRIBUTES);
                result = ending.getAppearance();
                result.setIcon(MuleIcons.ConnectorIcon);
            }
        }
        return result;
    }
//    private static SimpleTextAttributes makeStrikeout(SimpleTextAttributes nameAttributes) {
//        return new SimpleTextAttributes(nameAttributes.getStyle() | 4, nameAttributes.getFgColor());

    private static PsiElement getPsiElement(Object value) {
        if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();
            if (userObject instanceof PsiElement) {
                return (PsiElement) userObject;
            }
        }

        return null;
    }

}
