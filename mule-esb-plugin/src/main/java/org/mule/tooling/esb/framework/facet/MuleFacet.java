package org.mule.tooling.esb.framework.facet;

import com.intellij.facet.*;
import com.intellij.openapi.module.Module;

public class MuleFacet extends Facet<MuleFacetConfiguration> {
  public static final String ID = "MULE_FACET_ID";

  public MuleFacet(FacetType facetType,
                   Module module,
                   String name,
                   MuleFacetConfiguration configuration,
                   Facet underlyingFacet) {
    super(facetType, module, name, configuration, underlyingFacet);
  }
}
