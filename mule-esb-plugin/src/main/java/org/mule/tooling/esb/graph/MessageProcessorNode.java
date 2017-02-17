package org.mule.tooling.esb.graph;

import com.intellij.psi.xml.XmlTag;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;

public class MessageProcessorNode {

  private XmlTag tag;

  public MessageProcessorNode(XmlTag tag) {
    this.tag = tag;
  }

  public String getName() {
    return tag.getName();
  }

  public Icon getIcon() {
    return MuleIcons.MuleIcon;
  }


  public XmlTag getIdentifyingElement() {
    return tag;
  }
}
