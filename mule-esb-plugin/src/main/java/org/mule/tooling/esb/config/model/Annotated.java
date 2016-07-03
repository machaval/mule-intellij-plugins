package org.mule.tooling.esb.config.model;

import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;

/**
 * http://www.mulesoft.org/schema/mule/core:annotatedType interface.
 */
public interface Annotated extends DomElement {

	/**
	 * Returns the value of the annotations child.
	 * @return the value of the annotations child.
	 */
	@NotNull
	Annotations getAnnotations();


}