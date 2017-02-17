package org.mule.tooling.esb.graph;

import com.intellij.psi.xml.XmlTag;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;

public class MessageProcessorPresentationNode {

  private XmlTag tag;

  public MessageProcessorPresentationNode(XmlTag tag) {
    this.tag = tag;
  }

  public String getName() {
    String attributeValue = tag.getAttributeValue("doc:name");
    return attributeValue == null ? tag.getName() : attributeValue;
  }

  public Icon getIcon() {
    return MuleIcons.MuleIcon;
  }


  public XmlTag getIdentifyingElement() {
    return tag;
  }
}
