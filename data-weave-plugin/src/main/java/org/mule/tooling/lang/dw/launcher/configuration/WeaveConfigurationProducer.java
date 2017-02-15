package org.mule.tooling.lang.dw.launcher.configuration;

import com.intellij.execution.Location;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.junit.JavaRunConfigurationProducerBase;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.apache.commons.lang.StringUtils;
import org.mule.tooling.lang.dw.WeaveFileType;
import org.mule.tooling.lang.dw.launcher.configuration.ui.WeaveInput;
import org.mule.tooling.lang.dw.parser.psi.*;
import org.mule.tooling.lang.dw.parser.psi.WeavePsiUtils;

import java.util.ArrayList;
import java.util.List;

public class WeaveConfigurationProducer extends JavaRunConfigurationProducerBase<WeaveConfiguration> {
  protected WeaveConfigurationProducer() {
    super(WeaveConfigurationType.getInstance());
  }

  @Override
  protected boolean setupConfigurationFromContext(WeaveConfiguration weaveConfiguration, ConfigurationContext configurationContext, Ref<PsiElement> ref) {
    final Location location = configurationContext.getLocation();
    if (location != null) {
      final PsiFile containingFile = location.getPsiElement().getContainingFile();
      if (containingFile != null) {
        final boolean weaveFile = containingFile.getFileType() == WeaveFileType.getInstance();
        if (weaveFile) {
          final List<WeaveInput> weaveInputs = new ArrayList<>();
          WeaveDocument document = WeavePsiUtils.getDocument(location.getPsiElement());
          if (document != null) {
            final WeaveHeader header = document.getHeader();
            if (header != null) {
              final List<WeaveDirective> directiveList = header.getDirectiveList();
              for (WeaveDirective weaveDirective : directiveList) {
                if (weaveDirective instanceof WeaveInputDirective) {
                  final WeaveIdentifier identifier = ((WeaveInputDirective) weaveDirective).getIdentifier();
                  if (identifier != null) {
                    weaveInputs.add(new WeaveInput(identifier.getName(), ""));
                  }
                }
              }
            }
          }
          weaveConfiguration.setWeaveInputs(weaveInputs);
          weaveConfiguration.setWeaveFile(containingFile.getVirtualFile().getCanonicalPath());
          weaveConfiguration.setModule(configurationContext.getModule());
          weaveConfiguration.setName(StringUtils.capitalize(containingFile.getVirtualFile().getName()));
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public boolean isConfigurationFromContext(WeaveConfiguration muleConfiguration, ConfigurationContext configurationContext) {
    final Module module = configurationContext.getModule();
    final PsiFile containingFile = configurationContext.getPsiLocation().getContainingFile();
    if (containingFile == null) {
      return false;
    }
    final String canonicalPath = containingFile.getVirtualFile().getCanonicalPath();
    final String weaveFile = muleConfiguration.getWeaveFile();
    if (weaveFile == null) {
      return false;
    }
    return module != null && module.equals(muleConfiguration.getModule()) && weaveFile.equals(canonicalPath);
  }
}
