package org.mule.tooling.lang.dw.editor;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * Created by eberman on 11/15/16.
 */
public class OpenSchemaAction extends AnAction {

  final static Logger logger = Logger.getInstance(OpenSchemaAction.class);
  final static Icon loadSchemaIcon = IconLoader.findIcon("/openschema.png");

  public OpenSchemaAction() {
    super("Load Schema", "Load XSD or Json Schema", loadSchemaIcon);
  }

  @Override
  public void actionPerformed(AnActionEvent anActionEvent) {
    logger.debug("Loading schema!");
  }

}
