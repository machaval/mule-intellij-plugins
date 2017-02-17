package org.mule.tooling.esb.graph;


public class TransitionPresentationNode {

  private MessageProcessorPresentationNode source;
  private MessageProcessorPresentationNode target;

  public TransitionPresentationNode(MessageProcessorPresentationNode source, MessageProcessorPresentationNode target) {
    this.source = source;
    this.target = target;
  }

  public MessageProcessorPresentationNode getSource() {
    return source;
  }

  public MessageProcessorPresentationNode getTarget() {
    return target;
  }
}
