package org.mule.tooling.esb.graph;

import com.intellij.openapi.graph.builder.GraphDataModel;
import com.intellij.openapi.project.Project;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MuleConfigDataModel extends GraphDataModel<MessageProcessorPresentationNode, TransitionPresentationNode> {
  private final List<MessageProcessorPresentationNode> myNodes = new ArrayList<>();
  private final List<TransitionPresentationNode> myEdges = new ArrayList<>();


  private final Project myProject;
  private final XmlFile myFile;


  public MuleConfigDataModel(final XmlFile file) {
    myFile = file;
    myProject = file.getProject();
  }

  public Project getProject() {
    return myProject;
  }

  @NotNull
  public Collection<MessageProcessorPresentationNode> getNodes() {
    refreshDataModel();
    return myNodes;
  }

  @NotNull
  public Collection<TransitionPresentationNode> getEdges() {
    return myEdges;
  }

  @NotNull
  public MessageProcessorPresentationNode getSourceNode(final TransitionPresentationNode jpdlBasicEdge) {
    return jpdlBasicEdge.getSource();
  }

  @NotNull
  public MessageProcessorPresentationNode getTargetNode(final TransitionPresentationNode jpdlBasicEdge) {
    return jpdlBasicEdge.getTarget();
  }

  @NotNull
  public String getNodeName(final MessageProcessorPresentationNode jpdlBasicNode) {
    return jpdlBasicNode.getName();
  }

  @NotNull
  public String getEdgeName(final TransitionPresentationNode jpdlBasicEdge) {
    return "";
  }

  public TransitionPresentationNode createEdge(@NotNull final MessageProcessorPresentationNode from, @NotNull final MessageProcessorPresentationNode to) {
    return null;
  }

  public void dispose() {
  }


  private void refreshDataModel() {
    clearAll();
    updateDataModel();
  }

  private void clearAll() {
    myNodes.clear();
    myEdges.clear();
  }

  private void updateDataModel() {
    XmlTag muleConfig = myFile.getRootTag();
    List<XmlTag> flows = getFlows(muleConfig);
    for (XmlTag flow : flows) {
      XmlTag[] subTags = flow.getSubTags();
      for (int i = 0; i < subTags.length; i++) {
        XmlTag subTag = subTags[i];
        myNodes.add(new MessageProcessorPresentationNode(subTag));
        if (i > 0) {
          myEdges.add(new TransitionPresentationNode(myNodes.get(i - 1), myNodes.get(i)));
        }
      }
    }
  }

  private List<XmlTag> getFlows(XmlTag muleConfig) {
    List<XmlTag> flows = new ArrayList<>();
    XmlTag[] subTags = muleConfig.getSubTags();
    for (XmlTag subTag : subTags) {
      if (subTag.getLocalName().equals("flow")) {
        flows.add(subTag);
      }
    }
    return flows;
  }

}
