package org.mule.tooling.esb.toolwindow.globalconfigs;

import com.intellij.ide.CommonActionsManager;
import com.intellij.ide.TreeExpander;
import com.intellij.ide.dnd.aware.DnDAwareTree;
import com.intellij.ide.ui.customization.CustomizationUtil;
import com.intellij.ide.util.treeView.AbstractTreeBuilder;
import com.intellij.ide.util.treeView.IndexComparator;
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
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.treeStructure.SimpleNode;
import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.ui.treeStructure.SimpleTreeBuilder;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.EditSourceOnDoubleClickHandler;
import com.intellij.util.OpenSourceUtil;
import com.intellij.util.ui.tree.TreeUtil;
import com.intellij.util.ui.tree.WideSelectionTreeUI;
import com.intellij.util.xml.DomFileElement;
import com.intellij.util.xml.DomManager;
import com.intellij.xml.XmlSchemaProvider;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.config.model.Mule;
import org.mule.tooling.esb.util.MuleConfigUtils;
import org.mule.tooling.esb.util.MuleElementType;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by eberman on 3/27/17.
 */
public class GlobalConfigsToolWindowPanel extends SimpleToolWindowPanel implements Disposable {

    private static final String TOOL_WINDOW_TOOLBAR_ID = "Mule.GlobalConfigsActionsToolbar";

    private Project myProject;

    //private DnDAwareTree myTree;
    private Tree myTree;
    private GlobalConfigsTreeStructure myStructure;

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
        myStructure = new GlobalConfigsTreeStructure(myProject);
        final DefaultMutableTreeNode root = new DefaultMutableTreeNode();
        final SimpleNode rootNode = (SimpleNode)myStructure.getRootElement();
        final DefaultTreeModel model = new DefaultTreeModel(root);
        myTree = new SimpleTree(model);
//        final AbstractTreeBuilder myTreeBuilder =
//                new AbstractTreeBuilder(myTree, model, myStructure, null);
        final SimpleTreeBuilder myTreeBuilder =
                new SimpleTreeBuilder(myTree, model, myStructure, null);
       // myTree.invalidate();
        myTree.setRootVisible(false);

        PsiManager.getInstance(myProject).addPsiTreeChangeListener(new PsiTreeChangeAdapter() {
            @Override
            public void childAdded(@NotNull PsiTreeChangeEvent event) {
                _treeChange(event);
            }

            @Override
            public void childRemoved(@NotNull PsiTreeChangeEvent event) {
                _treeChange(event);
            }

            @Override
            public void childReplaced(@NotNull PsiTreeChangeEvent event) {
                _treeChange(event);
            }

            @Override
            public void childMoved(@NotNull PsiTreeChangeEvent event) {
                _treeChange(event);
            }

            @Override
            public void childrenChanged(@NotNull PsiTreeChangeEvent event) {
                _treeChange(event);
            }

            @Override
            public void propertyChanged(@NotNull PsiTreeChangeEvent event) {
                _treeChange(event);
            }

            private void _treeChange(@NotNull PsiTreeChangeEvent event) {
                //TODO
            /*
                Check if the change is in the file (i.e. no file added or deleted)
                if yes - locate the node
                         rebuild
                         if node was expanded - expand
                if no - rebuild the tree
             */

                myTreeBuilder.updateFromRoot(true);
            }
        });

        this.setContent(ScrollPaneFactory.createScrollPane(myTree));
        this.setToolbar(createActionsToolbar());

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

    public Tree getTree() {
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
                GlobalConfigsTreeStructure.GlobalConfigNode configNode = (GlobalConfigsTreeStructure.GlobalConfigNode)selectedElement.getUserObject();
                if (configNode == null)
                    return;
                PsiElement element = configNode.getXmlTag();
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
//
//    @Nullable
//    @Override
//    public Object getData(@NonNls String dataId) {
//        if (LocalDataKeys.PROCESSES_PROJECTS_TREE.is(dataId))
//            return myTree;
//        if (LocalDataKeys.PROCESSES_PROJECTS_TREE_STRUCTURE.is(dataId))
//            return myStructure;
//        return super.getData(dataId);
//    }
}
