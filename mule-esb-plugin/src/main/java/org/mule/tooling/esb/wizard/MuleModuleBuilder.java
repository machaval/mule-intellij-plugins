package org.mule.tooling.esb.wizard;

import com.intellij.openapi.module.Module;

/**
 * Created by eberman on 10/25/16.
 */
public interface MuleModuleBuilder {
    public void setMuleVersion(String muleVersion);
    public void setMuleFacet(Module module);
}
