package org.mule.tooling.esb.editor.dnd;

import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.graph.builder.dnd.GraphDnDSupport;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.XmlElementFactory;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.Function;
import org.mule.tooling.esb.editor.MessageProcessorType;
import org.mule.tooling.esb.graph.MessageProcessorNode;
import org.mule.tooling.esb.graph.MuleConfigDataModel;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: Sergey.Vasiliev
 */
public class MuleConfigDndSupport implements GraphDnDSupport<MessageProcessorNode, MessageProcessorType> {
  private final MuleConfigDataModel myDataModel;
  private static final String UNKNOWN = "unknown";

  public MuleConfigDndSupport(final MuleConfigDataModel dataModel) {
    myDataModel = dataModel;
  }


  public Map<MessageProcessorType, Pair<String, Icon>> getDnDActions() {
    Map<MessageProcessorType, Pair<String, Icon>> nodes = new LinkedHashMap<MessageProcessorType, Pair<String, Icon>>();

    nodes.put(MessageProcessorType.LOGGER, new Pair<String, Icon>("Logger", MuleIcons.MuleIcon));


    return nodes;
  }

  public boolean canStartDragging(final MessageProcessorType jpdlNodeType) {
    return true;
  }

  public MessageProcessorNode drop(final MessageProcessorType jpdlNodeType) {
    return startInWCA(myDataModel.getProject(), jpdlNodeType, getLoggerFunction());
  }

  public Function<MessageProcessorType, MessageProcessorNode> getLoggerFunction() {
    return new Function<MessageProcessorType, MessageProcessorNode>() {
      public MessageProcessorNode fun(final MessageProcessorType processDefinition) {
        XmlTag logger = XmlElementFactory.getInstance(getDataModel().getProject()).createTagFromText("<logger message=\"\"/>");
        MessageProcessorNode messageProcessorNode = new MessageProcessorNode(logger);
        getDataModel().addMessageProcessor(messageProcessorNode);
        return messageProcessorNode;


      }
    };
  }


  private MessageProcessorNode startInWCA(final Project project,
                                          MessageProcessorType processDefinition,
                                          final Function<MessageProcessorType, MessageProcessorNode> function) {
    return new WriteCommandAction<MessageProcessorNode>(project, myDataModel.getMyFile()) {
      protected void run(final Result<MessageProcessorNode> result) throws Throwable {
        result.setResult(function.fun(processDefinition));
      }
    }.execute().getResultObject();
  }


  public MuleConfigDataModel getDataModel() {
    return myDataModel;
  }
}