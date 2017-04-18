package org.mule.tooling.esb.toolwindow;

import com.intellij.ide.CommonActionsManager;
import com.intellij.ide.TreeExpander;
import com.intellij.ide.dnd.aware.DnDAwareTree;
import com.intellij.ide.ui.customization.CustomizationUtil;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupManager;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.meta.PsiMetaData;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.EditSourceOnDoubleClickHandler;
import com.intellij.util.OpenSourceUtil;
import com.intellij.util.ui.tree.TreeUtil;
import com.intellij.util.ui.tree.WideSelectionTreeUI;
import com.intellij.util.xml.DomFileElement;
import com.intellij.util.xml.DomManager;
import com.intellij.xml.XmlSchemaProvider;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.config.model.Mule;
import org.mule.tooling.esb.util.MuleConfigUtils;
import org.mule.tooling.esb.util.MuleElementType;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by eberman on 3/27/17.
 */
public class GlobalConfigsToolWindowPanel extends SimpleToolWindowPanel implements Disposable {

    private static final String TOOL_WINDOW_TOOLBAR_ID = "Mule.GlobalConfigsActionsToolbar";

    private Project myProject;

    private DnDAwareTree myTree;

    public GlobalConfigsToolWindowPanel(Project project) {
        super(true, true);
        myProject = project;

        if (myProject.isInitialized())
            init();
        else
            StartupManager.getInstance(myProject)
                    .registerPostStartupActivity(() -> {
                        init();
                    });
    }

    public GlobalConfigsToolWindowPanel(boolean vertical) {
        super(vertical, true);
    }


    public void init() {

        DefaultMutableTreeNode globalConfigs = new DefaultMutableTreeNode("");

        final DomManager manager = DomManager.getDomManager(myProject);

        final Collection<VirtualFile> files = FileTypeIndex.getFiles(StdFileTypes.XML, GlobalSearchScope.projectScope(myProject));

        for (VirtualFile file : files) {

            final PsiFile xmlFile = PsiManager.getInstance(myProject).findFile(file);
//TODO: There's NPE here because the VFS may not be indexed yet.
//TODO: Need dynamic init, PSI listener, etc.
            PsiDirectory directory = xmlFile.getParent();
            Module module = ModuleUtilCore.findModuleForPsiElement((PsiElement)(directory == null?xmlFile:directory));

            if (MuleConfigUtils.isMuleFile(xmlFile)) {
                final DomFileElement<Mule> fileElement = manager.getFileElement((XmlFile) xmlFile, Mule.class);

                if (fileElement != null) {
                    final Mule rootElement = fileElement.getRootElement();
                    XmlTag[] subTags = rootElement.getXmlTag().getSubTags();

                    for (XmlTag nextTag : subTags) {
                        MuleElementType muleElementType = MuleConfigUtils.getMuleElementTypeFromXmlElement(nextTag);

                        if (muleElementType != null &&
                            (MuleElementType.CONFIG.equals(muleElementType) || (MuleElementType.TRANSPORT_CONNECTOR.equals(muleElementType)))) {

                            DefaultMutableTreeNode lastChild = null;

                            if (globalConfigs.getChildCount() > 0) {
                                lastChild = (DefaultMutableTreeNode) globalConfigs.getLastChild();
                            }

                            if (lastChild == null || !(((PsiFile)lastChild.getUserObject()).getName().equals(xmlFile.getName()))) {
                                lastChild = new DefaultMutableTreeNode(xmlFile);
                                globalConfigs.add(lastChild);
                            }

                            DefaultMutableTreeNode nextConfigNode = new DefaultMutableTreeNode(nextTag);
                            lastChild.add(nextConfigNode);
                        }
                    }
                }
            }
        }

        myTree = new DnDAwareTree(globalConfigs);
        myTree.setRootVisible(false);
        myTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        myTree.setUI(new WideSelectionTreeUI());
        myTree.setOpaque(true);

        JScrollPane scrollPane = new JScrollPane(myTree);
        this.setContent(scrollPane);
        this.setToolbar(createActionsToolbar());

        GlobalConfigsNodeRenderer r = new GlobalConfigsNodeRenderer();
        myTree.setCellRenderer(r);

        addTreeMouseListeners();
    }

    public void expandAll() {
        ApplicationManager.getApplication().assertIsDispatchThread();

        try {
            TreeUtil.expandAll(myTree);
        } finally {
        }
    }

    private void collapseAll() {
        ApplicationManager.getApplication().assertIsDispatchThread();
        TreeUtil.collapseAll(myTree, 0);
    }

    @NotNull
    protected AnAction[] createActions() {
        ApplicationManager.getApplication().assertIsDispatchThread();
        final TreeExpander treeExpander = new TreeExpander() {
            @Override
            public void expandAll() {
                GlobalConfigsToolWindowPanel.this.expandAll();
            }

            @Override
            public boolean canExpand() {
                return true;
            }

            @Override
            public void collapseAll() {
                GlobalConfigsToolWindowPanel.this.collapseAll();
            }

            @Override
            public boolean canCollapse() {
                return true;
            }
        };

        CommonActionsManager actionsManager = CommonActionsManager.getInstance();

        final JComponent component = getComponent();

        final AnAction expandAllAction = actionsManager.createExpandAllAction(treeExpander, component);
        final AnAction collapseAllAction = actionsManager.createCollapseAllAction(treeExpander, component);

        Disposer.register(this, () -> {
            expandAllAction.unregisterCustomShortcutSet(component);
            collapseAllAction.unregisterCustomShortcutSet(component);
        });


        return new AnAction[]{
                expandAllAction,
                collapseAllAction
        };
    }

    @Override
    public void dispose() {

    }

    public DnDAwareTree getTree() {
        return myTree;
    }

    @NotNull
    private JComponent createActionsToolbar() {
        ApplicationManager.getApplication().assertIsDispatchThread();

        DefaultActionGroup group = new DefaultActionGroup() {
            @Override
            public void update(AnActionEvent e) {
                super.update(e);
            }

            @Override
            public boolean isDumbAware() {
                return true;
            }
        };

        AnAction[] actions = createActions();
        for (final AnAction action : actions) {
            if (action != null) {
                group.add(action);
            }
        }
        return _globalConfigsToolbar(group);
    }

    @NotNull
    private JComponent _globalConfigsToolbar(@NotNull DefaultActionGroup group) {
        ApplicationManager.getApplication().assertIsDispatchThread();
        ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar(TOOL_WINDOW_TOOLBAR_ID, group, true);
        actionToolbar.setTargetComponent(this);
        return actionToolbar.getComponent();
    }

    private void addTreeMouseListeners() {
        EditSourceOnDoubleClickHandler.install(getTree(), new Runnable() {
            @Override
            public void run() {
                TreePath path = getTree().getSelectionPath();
                if (path == null)
                    return;
                DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode)path.getLastPathComponent();
                if (selectedElement == null)
                    return;
                PsiElement element = (PsiElement)selectedElement.getUserObject();
                if (element == null)
                    return;
                OpenSourceUtil.navigate((Navigatable)element);
            }
        });

        CustomizationUtil.installPopupHandler(getTree(), IdeActions.GROUP_STRUCTURE_VIEW_POPUP, ActionPlaces.STRUCTURE_VIEW_POPUP);
    }

    private boolean isDevKitConfig(XmlTag tag, XmlFile baseFile) {
        Module module = ModuleUtilCore.findModuleForPsiElement(baseFile);

        String namespace = tag.getNamespace();
        List<XmlSchemaProvider> providers = XmlSchemaProvider.getAvailableProviders(baseFile);

        for (XmlSchemaProvider provider : providers) {
            Set<String> locations = provider.getLocations(namespace, baseFile);
            for (String location : locations) {
                XmlFile schema = provider.getSchema(location, module, baseFile);
                if (schema != null) {
                    String schemaFile = schema.getText();
                    if (schemaFile.contains("http://www.mulesoft.org/schema/mule/devkit")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
