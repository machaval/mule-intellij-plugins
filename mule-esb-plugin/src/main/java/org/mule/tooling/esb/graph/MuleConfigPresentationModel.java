package org.mule.tooling.esb.graph;


import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.graph.GraphManager;
import com.intellij.openapi.graph.builder.components.BasicGraphPresentationModel;
import com.intellij.openapi.graph.builder.renderer.BasicGraphNodeRenderer;
import com.intellij.openapi.graph.builder.util.GraphViewUtil;
import com.intellij.openapi.graph.layout.OrientationLayouter;
import com.intellij.openapi.graph.layout.hierarchic.HierarchicGroupLayouter;
import com.intellij.openapi.graph.layout.hierarchic.HierarchicLayouter;
import com.intellij.openapi.graph.settings.GraphSettings;
import com.intellij.openapi.graph.settings.GraphSettingsProvider;
import com.intellij.openapi.graph.view.Arrow;
import com.intellij.openapi.graph.view.EdgeRealizer;
import com.intellij.openapi.graph.view.EditMode;
import com.intellij.openapi.graph.view.Graph2D;
import com.intellij.openapi.graph.view.Graph2DView;
import com.intellij.openapi.graph.view.LineType;
import com.intellij.openapi.graph.view.NodeRealizer;
import com.intellij.openapi.graph.view.PolyLineEdgeRealizer;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class MuleConfigPresentationModel extends BasicGraphPresentationModel<MessageProcessorNode, TransitionPresentationNode> {
  private final Project myProject;
  private BasicGraphNodeRenderer myRenderer;

  public MuleConfigPresentationModel(final Graph2D graph, Project project) {
    super(graph);
    myProject = project;
    setShowEdgeLabels(true);

    customizeDefaultSettings(GraphSettingsProvider.getInstance(project).getSettings(graph));
  }

  private static void customizeDefaultSettings(final GraphSettings settings) {
    final HierarchicGroupLayouter groupLayouter = settings.getGroupLayouter();

    groupLayouter.setOrientationLayouter(GraphManager.getGraphManager().createOrientationLayouter(OrientationLayouter.TOP_TO_BOTTOM));
    groupLayouter.setMinimalNodeDistance(20);
    groupLayouter.setMinimalLayerDistance(50);
    groupLayouter.setRoutingStyle(HierarchicLayouter.ROUTE_POLYLINE);
  }

  @NotNull
  public NodeRealizer getNodeRealizer(final MessageProcessorNode node) {

    return GraphViewUtil.createNodeRealizer("MPPresentationNodeRenderer", getRenderer());
  }

  public BasicGraphNodeRenderer getRenderer() {
    if (myRenderer == null) {
      myRenderer = new DefaultMPPresentationNodeRenderer(getGraphBuilder());
    }
    return myRenderer;
  }

  @NotNull
  public EdgeRealizer getEdgeRealizer(final TransitionPresentationNode edge) {
    final PolyLineEdgeRealizer edgeRealizer = GraphManager.getGraphManager().createPolyLineEdgeRealizer();

    edgeRealizer.setLineType(LineType.LINE_1);
    edgeRealizer.setLineColor(Color.GRAY);
    edgeRealizer.setArrow(Arrow.STANDARD);

    return edgeRealizer;
  }

  public boolean editNode(final MessageProcessorNode node) {
    return super.editNode(node);
  }

  public boolean editEdge(final TransitionPresentationNode jpdlEdge) {
//    final XmlElement xmlElement = jpdlEdge.getIdentifyingElement().getXmlElement();
//    if (xmlElement instanceof Navigatable) {
//      OpenSourceUtil.navigate(new Navigatable[]{(Navigatable)xmlElement}, true);
//      return true;
//    }
    return super.editEdge(jpdlEdge);
  }

  public Project getProject() {
    return myProject;
  }


  public String getNodeTooltip(final MessageProcessorNode node) {
      return node.getName();
  }

//  public String getEdgeTooltip(final TransitionPresentationNode edge) {
//      final XmlElement xmlElement = edge.getIdentifyingElement().getXmlElement();
//      if (xmlElement != null) {
//          return xmlElement.getText();
//      }
//      return edge.getName();
//  }

  public void customizeSettings(final Graph2DView view, final EditMode editMode) {
    editMode.allowEdgeCreation(true);
    editMode.allowBendCreation(false);

    view.setFitContentOnResize(false);
    view.fitContent();
  }

//  public DeleteProvider getDeleteProvider() {
//    return new DeleteProvider<MessageProcessorNode, TransitionPresentationNode>() {
//      public boolean canDeleteNode(@NotNull final MessageProcessorNode node) {
//        return !((CellEditorMode)getGraphBuilder().getEditMode().getEditNodeMode()).isCellEditing();
//      }
//
//      public boolean canDeleteEdge(@NotNull final TransitionPresentationNode edge) {
//        return true;
//      }
//
//      public boolean deleteNode(@NotNull final MessageProcessorNode node) {
//        new WriteCommandAction(getProject()) {
//          protected void run(final Result result) throws Throwable {
//             node.getIdentifyingElement().undefine();
//          }
//        }.execute();
//
//        return true;
//      }
//
//      public boolean deleteEdge(@NotNull final TransitionPresentationNode edge) {
//        new WriteCommandAction(getProject()) {
//          protected void run(final Result result) throws Throwable {
//             edge.getIdentifyingElement().undefine();
//          }
//        }.execute();
//
//        return true;
//      }
//    };
//  }
//
//  public NodeCellEditor getCustomNodeCellEditor(final MessageProcessorNode jpdlNode) {
//    return new SimpleNodeCellEditor<MessageProcessorNode>(jpdlNode, getProject()) {
//      protected String getEditorValue(final MessageProcessorNode value) {
//        final String s = value.getName();
//        return s == null ? "" : s;
//      }
//
//      protected void setEditorValue(final MessageProcessorNode value, final String newValue) {
//        final DomElement element = value.getIdentifyingElement();
//        if (element instanceof JpdlNamedActivity) {
//          new WriteCommandAction(myProject) {
//            protected void run(final Result result) throws Throwable {
//              ((JpdlNamedActivity)element).getName().setStringValue(newValue);
//            }
//          }.execute();
//        }
//
//        IdeFocusManager.getInstance(getProject()).requestFocus(getGraphBuilder().getView().getJComponent(), true);
//      }
//    };
//  }

  public DefaultActionGroup getNodeActionGroup(final MessageProcessorNode jpdlNode) {
    final DefaultActionGroup group = super.getNodeActionGroup(jpdlNode);

    group.add(ActionManager.getInstance().getAction("Jpdl.Designer"), Constraints.FIRST);

    return group;
  }


}
