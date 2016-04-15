
package org.mule.templates;

import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider;

public class MuleConfigLiveTemplatesProvider implements DefaultLiveTemplatesProvider {
  @Override
  public String[] getDefaultLiveTemplateFiles() {
    return new String[]{"/liveTemplates/mule_config"};
  }

  @Override
  public String[] getHiddenLiveTemplateFiles() {
    return null;
  }
}
