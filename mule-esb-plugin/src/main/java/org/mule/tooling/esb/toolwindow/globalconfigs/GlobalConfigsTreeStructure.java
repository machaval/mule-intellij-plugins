package org.mule.tooling.esb.toolwindow.globalconfigs;

import com.intellij.icons.AllIcons;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.util.treeView.IndexComparator;
import com.intellij.ide.util.treeView.smartTree.SmartTreeStructure;
import com.intellij.ide.util.treeView.smartTree.TreeModel;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ui.util.CompositeAppearance;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.treeStructure.*;
import com.intellij.util.xml.DomFileElement;
import com.intellij.util.xml.DomManager;
import org.mule.tooling.esb.config.model.Mule;
import org.mule.tooling.esb.util.MuleConfigUtils;
import org.mule.tooling.esb.util.MuleElementType;
import org.mule.tooling.esb.util.MuleIcons;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Created by eberman on 4/20/17.
 */
public class GlobalConfigsTreeStructure extends SimpleTreeStructure {
    private final RootNode myRoot;
    //private final SimpleTreeBuilder myTreeBuilder;

    public GlobalConfigsTreeStructure(Project project) {
        this.myRoot = new RootNode(project);
    }

//    public void updateFromRoot() {
//        myTreeBuilder.addSubtreeToUpdateByElement(myRoot);
//    }

    @Override
    public Object getRootElement() {
        return myRoot;
    }

    public abstract class NamedNode extends CachingSimpleNode {
        protected NamedNode(SimpleNode aParent, String name) {
            super(aParent);
            myName = name;
        }
    }

    public class RootNode extends NamedNode {

        private Project myProject;

        public RootNode(Project project) {
            super(null, "Root");
            myProject = project;
        }

        @Override
        protected SimpleNode[] buildChildren() {
            List<SimpleNode> myConfigNodes = new ArrayList<>();

            final DomManager manager = DomManager.getDomManager(myProject);

            final Collection<VirtualFile> files = FileTypeIndex.getFiles(StdFileTypes.XML, GlobalSearchScope.projectScope(myProject));

            for (VirtualFile file : files) {

                final PsiFile xmlFile = PsiManager.getInstance(myProject).findFile(file);

                if (xmlFile != null) {
//                    PsiDirectory directory = xmlFile.getParent();
//                    Module module = ModuleUtilCore.findModuleForPsiElement((PsiElement) (directory == null ? xmlFile : directory));

                    if (MuleConfigUtils.isMuleFile(xmlFile)) {
                        final DomFileElement<Mule> fileElement = manager.getFileElement((XmlFile) xmlFile, Mule.class);

                        if (fileElement != null) {
                            final Mule rootElement = fileElement.getRootElement();
                            XmlTag[] subTags = rootElement.getXmlTag().getSubTags();

                            for (XmlTag nextTag : subTags) {
                                MuleElementType muleElementType = MuleConfigUtils.getMuleElementTypeFromXmlElement(nextTag);

                                if (muleElementType != null && //This is a global config file and it has at least one connector
                                        (MuleElementType.CONFIG.equals(muleElementType) || (MuleElementType.TRANSPORT_CONNECTOR.equals(muleElementType)))) {
                                    MuleConfigNode nextConfigNode = new MuleConfigNode(this, xmlFile);
                                    myConfigNodes.add(nextConfigNode);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            return myConfigNodes.toArray(new SimpleNode[]{});
        }
    }

    public class MuleConfigNode extends NamedNode {
        private PsiFile myXmlFile;
        private Project myProject;

        public MuleConfigNode(SimpleNode aParent, PsiFile xmlFile) {
            super(aParent, xmlFile.getName());
            myXmlFile = xmlFile;
            myProject = xmlFile.getProject();
            myClosedIcon = MuleIcons.MuleFileType;
            updatePresentation();
        }

        private void updatePresentation() {
            PresentationData presentation = getPresentation();
            presentation.clear();
            presentation.addText(myName, SimpleTextAttributes.GRAYED_BOLD_ATTRIBUTES);
            update(presentation);
        }

        @Override
        protected SimpleNode[] buildChildren() {
            List<SimpleNode> myConfigNodes = new ArrayList<>();

            final DomManager manager = DomManager.getDomManager(myProject);
            final DomFileElement<Mule> fileElement = manager.getFileElement((XmlFile) myXmlFile, Mule.class);

            if (fileElement != null) {
                final Mule rootElement = fileElement.getRootElement();
                XmlTag[] subTags = rootElement.getXmlTag().getSubTags();

                for (XmlTag nextTag : subTags) {
                    MuleElementType muleElementType = MuleConfigUtils.getMuleElementTypeFromXmlElement(nextTag);

                    if (muleElementType != null && //This is a global config
                            (MuleElementType.CONFIG.equals(muleElementType) || (MuleElementType.TRANSPORT_CONNECTOR.equals(muleElementType)))) {

                        GlobalConfigNode nextConfigNode = new GlobalConfigNode(this, nextTag);
                        myConfigNodes.add(nextConfigNode);
                    }
                }
            }
            return myConfigNodes.toArray(new SimpleNode[]{});
        }
    }

    public class GlobalConfigNode extends NamedNode {
        private XmlTag myTag;

        public GlobalConfigNode(SimpleNode aParent, XmlTag tag) {
            super(aParent, tag.getAttributeValue("name"));
            myTag = tag;
            myClosedIcon = MuleIcons.ConnectorIcon;
            updatePresentation();
        }

        private void updatePresentation() {
            String connectorType = myTag.getName();

            PresentationData presentation = getPresentation();
            presentation.clear();
            presentation.addText(myName, SimpleTextAttributes.REGULAR_ATTRIBUTES);
            presentation.addText("  (" + connectorType + ")", SimpleTextAttributes.GRAYED_ITALIC_ATTRIBUTES);
            update(presentation);
        }

        public XmlTag getXmlTag() {
            return myTag;
        }

//
//        @Override
//        public void handleDoubleClickOrEnter(SimpleTree tree, InputEvent inputEvent) {
//            if (Color.RED.equals(myColor)) {
//                myColor = Color.BLUE;
//            } else {
//                myColor = Color.RED;
//            }
//            updatePresentation();
//        }

        @Override
        protected SimpleNode[] buildChildren() {
            return NO_CHILDREN;
        }
    }
}

