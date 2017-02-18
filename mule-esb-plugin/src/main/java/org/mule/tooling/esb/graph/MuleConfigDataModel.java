package org.mule.tooling.esb.graph;

import com.intellij.openapi.graph.builder.GraphDataModel;
import com.intellij.openapi.graph.builder.NodesGroup;
import com.intellij.openapi.project.Project;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.util.XmlUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.security.utils.XMLUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MuleConfigDataModel extends GraphDataModel<MessageProcessorNode, TransitionPresentationNode> {
  private final List<MessageProcessorNode> myNodes = new ArrayList<>();
  private final List<TransitionPresentationNode> myEdges = new ArrayList<>();


  private final Project myProject;
  private final XmlFile myFile;


  public MuleConfigDataModel(final XmlFile file) {
    myFile = file;
    myProject = file.getProject();
  }

  public XmlFile getMyFile() {
    return myFile;
  }

  public Project getProject() {
    return myProject;
  }

  @NotNull
  public Collection<MessageProcessorNode> getNodes() {
    refreshDataModel();
    return myNodes;
  }

  @NotNull
  public Collection<TransitionPresentationNode> getEdges() {
    return myEdges;
  }

  @NotNull
  public MessageProcessorNode getSourceNode(final TransitionPresentationNode jpdlBasicEdge) {
    return jpdlBasicEdge.getSource();
  }

  @NotNull
  public MessageProcessorNode getTargetNode(final TransitionPresentationNode jpdlBasicEdge) {
    return jpdlBasicEdge.getTarget();
  }

  @NotNull
  public String getNodeName(final MessageProcessorNode jpdlBasicNode) {
    return jpdlBasicNode.getName();
  }

  @NotNull
  public String getEdgeName(final TransitionPresentationNode jpdlBasicEdge) {
    return "";
  }

  public TransitionPresentationNode createEdge(@NotNull final MessageProcessorNode from, @NotNull final MessageProcessorNode to) {
    return null;
  }


  @Nullable
  @Override
  public NodesGroup getGroup(MessageProcessorNode messageProcessorNode) {
    return super.getGroup(messageProcessorNode);
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
        myNodes.add(new MessageProcessorNode(subTag));
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

//  public static XmlTag createChildTag(final XmlTag xmlTag,
//                                      String localName,
//                                      String namespace,
//                                      @Nullable String bodyText,
//                                      boolean enforceNamespacesDeep)

  public void addMessageProcessor(MessageProcessorNode messageProcessorNode) {
    XmlTag identifyingElement = messageProcessorNode.getIdentifyingElement();
    XmlTag targetFlow = getFlows(myFile.getRootTag()).get(0);
    targetFlow.addSubTag(XmlUtil.createChildTag(targetFlow, identifyingElement.getLocalName(), "", null, false), true);
    myNodes.clear();
    myEdges.clear();
  }
}
