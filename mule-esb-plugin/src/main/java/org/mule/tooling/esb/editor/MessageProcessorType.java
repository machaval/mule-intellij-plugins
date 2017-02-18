package org.mule.tooling.esb.editor;


public class MessageProcessorType {
  private String id;

  public MessageProcessorType(String id) {
    this.id = id;
  }

  public static MessageProcessorType LOGGER = new MessageProcessorType("http://mule.com/logger");
  public static MessageProcessorType SET_VAR = new MessageProcessorType("http://mule.com/set-variable");
  public static MessageProcessorType HTTP_REQUEST = new MessageProcessorType("http://mule.com/http");
}
