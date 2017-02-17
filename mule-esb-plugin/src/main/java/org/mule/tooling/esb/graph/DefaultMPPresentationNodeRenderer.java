package org.mule.tooling.esb.graph;


import com.intellij.openapi.graph.builder.GraphBuilder;
import com.intellij.openapi.graph.builder.renderer.BasicGraphNodeRenderer;
import com.intellij.openapi.util.ModificationTracker;

import javax.swing.*;
import java.awt.*;


public class DefaultMPPresentationNodeRenderer extends BasicGraphNodeRenderer<MessageProcessorNode, TransitionPresentationNode> {

  public DefaultMPPresentationNodeRenderer(GraphBuilder<MessageProcessorNode, TransitionPresentationNode> builder) {
    super(builder, ModificationTracker.EVER_CHANGED);
  }

  protected JComponent getPresenationComponent(final String text) {
    return super.getPresenationComponent(text);
  }

  protected Icon getIcon(final MessageProcessorNode node) {
    return node.getIcon();
  }

  protected String getNodeName(final MessageProcessorNode node) {
    return node.getName();
  }

  protected Color getBackground(final MessageProcessorNode node) {
    return Color.LIGHT_GRAY.brighter();
  }

  protected int getSelectionBorderWidth() {
    return 1;
  }


}
