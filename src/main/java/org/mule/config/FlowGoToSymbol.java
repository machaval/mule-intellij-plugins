package org.mule.config;


import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.module.Module;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.model.gotosymbol.GoToSymbolProvider;
import org.jetbrains.annotations.NotNull;
import org.mule.util.MuleIcons;
import org.mule.util.MuleConfigUtils;

import java.util.List;
import java.util.Set;

public class FlowGoToSymbol extends GoToSymbolProvider {
    @Override
    protected void addNames(@NotNull Module module, Set<String> set) {
        set.addAll(ContainerUtil.mapNotNull(MuleConfigUtils.getFlows(module), new Function<DomElement, String>() {
            @Override
            public String fun(DomElement domElement) {
                return domElement.getXmlTag().getAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE);
            }
        }));
    }

    @Override
    protected void addItems(@NotNull Module module, String name, List<NavigationItem> list) {
        final XmlTag flow = MuleConfigUtils.findFlow(module, name);
        if (flow != null) {
            final String flowName = flow.getAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE);
            if (flowName != null) {
                list.add(createNavigationItem(flow, flowName, MuleIcons.MuleFlow));
            }
        }
    }

    @Override
    protected boolean acceptModule(Module module) {
        return true;
    }
}
