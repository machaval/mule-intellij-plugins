package org.mule.tooling.esb.graph;


public class TransitionPresentationNode {

  private MessageProcessorNode source;
  private MessageProcessorNode target;

  public TransitionPresentationNode(MessageProcessorNode source, MessageProcessorNode target) {
    this.source = source;
    this.target = target;
  }

  public MessageProcessorNode getSource() {
    return source;
  }

  public MessageProcessorNode getTarget() {
    return target;
  }
}
