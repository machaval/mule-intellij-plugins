package org.mule.framework;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import org.junit.Test;
import org.mule.runtime.api.meta.model.ExtensionModel;
import org.mule.tooling.esb.loader.ExtensionModelService;

import java.io.IOException;

public class ExtensionModelServiceTest {

  @Test
  public void loadCoreExtensionModel() throws IOException {
    final ExtensionModel extensionModel =
      ExtensionModelService.getInstance().get("http://www.mulesoft.org/schema/mule/core");

    assertThat(extensionModel, is(notNullValue()));
    assertThat(extensionModel.getName(), is("core"));
    assertThat(extensionModel.getOperationModels().size(), is(3));

  }

  @Test
  public void loadHttpExtensionModel() throws IOException {
    final ExtensionModel extensionModel =
      ExtensionModelService.getInstance().get("http://www.mulesoft.org/schema/mule/httpn");

    assertThat(extensionModel, is(notNullValue()));
    assertThat(extensionModel.getName(), is("HTTP"));
  }

}
