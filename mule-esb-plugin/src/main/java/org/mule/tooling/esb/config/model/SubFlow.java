// Generated on Fri Nov 20 15:04:02 ART 2015
// DTD/Schema  :    http://www.mulesoft.org/schema/mule/core

package org.mule.tooling.esb.config.model;

import com.intellij.ide.presentation.Presentation;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.Required;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.config.model.presentation.SubFlowPresentationProvider;

/**
 * http://www.mulesoft.org/schema/mule/core:subFlowType interface.
 */
@Presentation(provider = SubFlowPresentationProvider.class)
public interface SubFlow extends DomElement, Annotated {

    /**
     * Returns the value of the name child.
     * <pre>
     * <h3>Attribute null:name documentation</h3>
     * The name used to identify this flow construct.
     * </pre>
     *
     * @return the value of the name child.
     */
    @NotNull
    @Required
    GenericAttributeValue<String> getName();


    /**
     * Returns the value of the annotations child.
     *
     * @return the value of the annotations child.
     */
    @NotNull
    Annotations getAnnotations();


    /**
     * Returns the value of the description child.
     * <pre>
     * <h3>Element http://www.mulesoft.org/schema/mule/core:description documentation</h3>
     * This can hold any kind of documentation related to the flow construct. It is intended to be "human readable" only and is not used by the system.
     * </pre>
     *
     * @return the value of the description child.
     */
    @NotNull
    GenericDomValue<String> getDescription();


}
