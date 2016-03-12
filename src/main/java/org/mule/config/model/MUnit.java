// Generated on Fri Nov 20 15:04:02 ART 2015
// DTD/Schema  :  http://www.mulesoft.org/schema/mule/munit

package org.mule.config.model;

import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.Required;
import org.jetbrains.annotations.NotNull;

/**
 * http://www.mulesoft.org/schema/mule/munit:munitType interface.
 */
public interface MUnit extends Mule {


    /**
     * Returns the value of the test child.
     * <pre>
     * <h3>Element http://www.mulesoft.org/schema/mule/munit:test documentation</h3>
     * An MUnit test
     * </pre>
     *
     * @return the value of the test child.
     */
    @NotNull
    @Required
    java.util.List<MUnitTest> getMUnitTests();

    MUnitTest addMUnitTests();


}
