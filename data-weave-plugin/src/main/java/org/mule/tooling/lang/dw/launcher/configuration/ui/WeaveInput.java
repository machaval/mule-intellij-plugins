package org.mule.tooling.lang.dw.launcher.configuration.ui;

import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;

public class WeaveInput implements JDOMExternalizable {
  public static final String WEAVE_INPUT_NAME = "WeaveInputName";
  public static final String WEAVE_INPUT_PATH = "WeaveInputPath";
  private String name;
  private String path;

  public WeaveInput() {
  }

  public WeaveInput(String name, String path) {
    this.name = name;
    this.path = path;
  }

  public String getName() {
    return name;
  }

  public String getPath() {
    return path;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    setName(element.getAttributeValue(WEAVE_INPUT_NAME, ""));
    setPath(element.getAttributeValue(WEAVE_INPUT_PATH, ""));
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    element.setAttribute(WEAVE_INPUT_NAME, getName());
    element.setAttribute(WEAVE_INPUT_PATH, getPath());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    WeaveInput that = (WeaveInput) o;
    if (name != null ? !name.equals(that.name) : that.name != null)
      return false;
    return path != null ? path.equals(that.path) : that.path == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (path != null ? path.hashCode() : 0);
    return result;
  }
}
