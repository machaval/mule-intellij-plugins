package org.mule.tooling.esb.graph;


import com.intellij.openapi.graph.builder.GraphBuilder;
import com.intellij.openapi.graph.builder.renderer.BasicGraphNodeRenderer;
import com.intellij.openapi.util.ModificationTracker;

import javax.swing.*;
import java.awt.*;


public class DefaultMPPresentationNodeRenderer extends BasicGraphNodeRenderer<MessageProcessorPresentationNode, TransitionPresentationNode> {

  public DefaultMPPresentationNodeRenderer(GraphBuilder<MessageProcessorPresentationNode, TransitionPresentationNode> builder) {
    super(builder, ModificationTracker.EVER_CHANGED);
  }

  protected JComponent getPresenationComponent(final String text) {
    return super.getPresenationComponent(text);
  }

  protected Icon getIcon(final MessageProcessorPresentationNode node) {
    return node.getIcon();
  }

  protected String getNodeName(final MessageProcessorPresentationNode node) {
    return node.getName();
  }

  protected Color getBackground(final MessageProcessorPresentationNode node) {
    return Color.LIGHT_GRAY.brighter();
  }

  protected int getSelectionBorderWidth() {
    return 1;
  }


}
