package org.mule.tooling.esb.editor;


public class MessageProcessorType {
  private String id;

  public MessageProcessorType(String id) {
    this.id = id;
  }

  public static MessageProcessorType LOGGER = new MessageProcessorType("http://mule.com/logger");
}
