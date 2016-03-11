// Generated on Fri Nov 20 15:04:02 ART 2015
// DTD/Schema  :    http://www.mulesoft.org/schema/mule/munit

package org.mule.config.model;

import com.intellij.ide.presentation.Presentation;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.Required;
import org.jetbrains.annotations.NotNull;
import org.mule.config.model.presentation.FlowPresentationProvider;
import org.mule.config.model.presentation.MUnitTestPresentationProvider;

/**
 * http://www.mulesoft.org/schema/mule/munit:munitTestType interface.
 */
@Presentation(provider = MUnitTestPresentationProvider.class)
public interface MUnitTest extends Flow {

    /**
     * Returns the value of the ignore attribute.
     * <pre>
     * <h3>Attribute null:ignore documentation</h3>
     * Defines if the test must be ignored.
     * </pre>
     *
     * @return the value of the ignore child.
     */
    @NotNull
    @Required
    GenericAttributeValue<String> getIgnore();


    /**
     * Returns the value of the expectException child.
     * <pre>
     * <h3>Attribute null:expectException documentation</h3>
     * Exception expression to match
     * </pre>
     *
     * @return the value of the expectException child.
     */
    @NotNull
    GenericAttributeValue<String> getExpectException();


}
