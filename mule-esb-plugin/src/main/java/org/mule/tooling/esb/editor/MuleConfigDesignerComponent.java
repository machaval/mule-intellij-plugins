package org.mule.tooling.esb.editor;


import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.graph.GraphManager;
import com.intellij.openapi.graph.base.Node;
import com.intellij.openapi.graph.builder.GraphBuilder;
import com.intellij.openapi.graph.builder.GraphBuilderFactory;
import com.intellij.openapi.graph.builder.dnd.GraphDnDUtils;
import com.intellij.openapi.graph.builder.dnd.SimpleDnDPanel;
import com.intellij.openapi.graph.builder.util.GraphViewUtil;
import com.intellij.openapi.graph.geom.YRectangle;
import com.intellij.openapi.graph.view.Graph2D;
import com.intellij.openapi.graph.view.Graph2DView;
import com.intellij.openapi.graph.view.Overview;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Splitter;
import com.intellij.openapi.util.Disposer;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.DomElementNavigationProvider;
import com.intellij.util.xml.DomEventAdapter;
import com.intellij.util.xml.DomManager;
import com.intellij.util.xml.events.DomEvent;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.editor.dnd.MuleConfigDndSupport;
import org.mule.tooling.esb.graph.MessageProcessorNode;
import org.mule.tooling.esb.graph.MuleConfigDataModel;
import org.mule.tooling.esb.graph.MuleConfigPresentationModel;
import org.mule.tooling.esb.graph.TransitionPresentationNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: Sergey.Vasiliev
 */
public class MuleConfigDesignerComponent extends JPanel implements DataProvider, Disposable {
  @NonNls
  public static final String JPDL_DESIGNER_COMPONENT = "JPDL_DESIGNER_COMPONENT";
  @NonNls
  private static final String JPDL_DESIGNER_NAVIGATION_PROVIDER_NAME = "JPDL_DESIGNER_NAVIGATION_PROVIDER_NAME";

  @NonNls
  private final SeamProcessDesignerNavigationProvider myNavigationProvider = new SeamProcessDesignerNavigationProvider();

  private final GraphBuilder<MessageProcessorNode, TransitionPresentationNode> myBuilder;
  private final XmlFile myXmlFile;
  private final MuleConfigDataModel myDataModel;

  public MuleConfigDesignerComponent(final XmlFile xmlFile) {
    myXmlFile = xmlFile;
    final Project project = xmlFile.getProject();

    final Graph2D graph = GraphManager.getGraphManager().createGraph2D();
    final Graph2DView view = GraphManager.getGraphManager().createGraph2DView();
    myDataModel = new MuleConfigDataModel(xmlFile);
    MuleConfigPresentationModel presentationModel = new MuleConfigPresentationModel(graph, project);

    myBuilder = GraphBuilderFactory.getInstance(project).createGraphBuilder(graph, view, myDataModel, presentationModel);

    GraphViewUtil.addDataProvider(view, new MyDataProvider(myBuilder));

    final Splitter splitter = new Splitter(false, 0.85f);

    setLayout(new BorderLayout());

    final SimpleDnDPanel simpleDnDPanel = GraphDnDUtils.createDnDActions(project, myBuilder, new MuleConfigDndSupport(myDataModel));
    final JComponent graphComponent = myBuilder.getView().getJComponent();

    splitter.setSecondComponent(simpleDnDPanel.getTree());

    splitter.setFirstComponent(graphComponent);
    splitter.setDividerWidth(5);

    add(createToolbarPanel(), BorderLayout.NORTH);
    add(splitter, BorderLayout.CENTER);

    Disposer.register(this, myBuilder);

    myBuilder.initialize();

    DomManager.getDomManager(myBuilder.getProject()).addDomEventListener(new DomEventAdapter() {
      public void eventOccured(final DomEvent event) {
        if (isShowing()) {
          simpleDnDPanel.getBuilder().updateFromRoot();
          myBuilder.queueUpdate();
        }
      }
    }, this);
  }

  private JComponent createToolbarPanel() {
    DefaultActionGroup actions = new DefaultActionGroup();
    // todo add custom actions

    actions.add(GraphViewUtil.getBasicToolbar(myBuilder));

    final ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, actions, true);

    return actionToolbar.getComponent();
  }

  public List<XmlTag> getSelectedDomElements() {
    List<XmlTag> selected = new ArrayList<XmlTag>();
    final Graph2D graph = myBuilder.getGraph();
    for (Node n : graph.getNodeArray()) {
      if (graph.isSelected(n)) {
        final MessageProcessorNode nodeObject = myBuilder.getNodeObject(n);
        if (nodeObject != null) {
          ContainerUtil.addIfNotNull(nodeObject.getIdentifyingElement(), selected);
        }
      }
    }
    return selected;
  }

  public void setSelectedDomElement(final XmlTag domElement) {
    if (domElement == null) return;


    Node selectedNode = findNode(domElement);

    if (selectedNode != null) {
      final Graph2D graph = myBuilder.getGraph();

      for (Node n : graph.getNodeArray()) {
        final boolean selected = n.equals(selectedNode);
        graph.setSelected(n, selected);
        if (selected) {
          final YRectangle yRectangle = graph.getRectangle(n);
          if (!myBuilder.getView().getVisibleRect().contains(
                  new Rectangle((int) yRectangle.getX(), (int) yRectangle.getY(), (int) yRectangle.getWidth(), (int) yRectangle.getHeight()))) {
            myBuilder.getView().setCenter(graph.getX(n), graph.getY(n));
          }
        }
      }
    }
    myBuilder.getView().updateView();
  }

  @Nullable
  private Node findNode(@Nullable XmlTag activity) {
    if (activity == null) return null;

    final Collection<MessageProcessorNode> nodeObjects = myBuilder.getNodeObjects();
    for (MessageProcessorNode jpdlNode : nodeObjects) {
      if (activity.equals(jpdlNode.getIdentifyingElement())) {
        return myBuilder.getNode(jpdlNode);
      }
    }
    return null;
  }

  public GraphBuilder getBuilder() {
    return myBuilder;
  }

  public Overview getOverview() {
    return GraphManager.getGraphManager().createOverview(myBuilder.getView());
  }

  public void dispose() {
  }

  private class SeamProcessDesignerNavigationProvider extends DomElementNavigationProvider {
    public String getProviderName() {
      return JPDL_DESIGNER_NAVIGATION_PROVIDER_NAME;
    }

    public void navigate(final DomElement domElement, final boolean requestFocus) {
      if (domElement instanceof XmlTag) {
        setSelectedDomElement((XmlTag) domElement);
      }
    }

    public boolean canNavigate(final DomElement domElement) {
      return domElement.isValid();
    }
  }

  public SeamProcessDesignerNavigationProvider getNavigationProvider() {
    return myNavigationProvider;
  }

  public XmlFile getXmlFile() {
    return myXmlFile;
  }

  @Nullable
  public Object getData(@NonNls final String dataId) {
    if (dataId.equals(JPDL_DESIGNER_COMPONENT)) return this;

    return null;
  }

  public MuleConfigDataModel getDataModel() {
    return myDataModel;
  }

  private class MyDataProvider implements DataProvider {
    private final Project myProject;
    private final Graph2D myGraph;

    public MyDataProvider(final GraphBuilder<MessageProcessorNode, TransitionPresentationNode> builder) {
      myProject = builder.getProject();
      myGraph = builder.getGraph();
    }

    @Nullable
    public Object getData(@NonNls String dataId) {
      if (dataId.equals(DataConstants.PROJECT)) {
        return myProject;
      } else if (dataId.equals(DataConstants.PSI_ELEMENT)) {
        for (Node node : myGraph.getNodeArray()) {
          if (myGraph.getRealizer(node).isSelected()) {
            final MessageProcessorNode jpdlNode = myBuilder.getNodeObject(node);
            if (jpdlNode != null) {
              return jpdlNode.getIdentifyingElement();
            }
          }
        }
      }
      return null;
    }
  }
}