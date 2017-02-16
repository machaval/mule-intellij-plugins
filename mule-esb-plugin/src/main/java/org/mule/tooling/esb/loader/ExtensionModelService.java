package org.mule.tooling.esb.loader;

import org.apache.commons.io.IOUtils;
import org.mule.runtime.api.meta.model.ExtensionModel;
import org.mule.runtime.extension.api.persistence.ExtensionModelJsonSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ExtensionModelService {

  private static ExtensionModelService ourInstance = new ExtensionModelService();
  private Map<String, ExtensionModel> extensionModels = new HashMap<>();

  public static ExtensionModelService getInstance() {
    return ourInstance;
  }

  public ExtensionModel get(String namespaceUri){
    return extensionModels.get(namespaceUri);
  }

  private ExtensionModelService() {
    load("extension-models/mule-module-core-extension-model.json");
    load("extension-models/mule-module-http-extension-model.json");
  }

  private void load(String jsonResource) {
    final URL resource = Thread.currentThread().getContextClassLoader().getResource(jsonResource);
    if (resource == null){
      throw new RuntimeException(String.format("There was an issue looking for the [%s] resource", jsonResource));
    }
    try(InputStream is = resource.openStream()) {
      String extModelStr = IOUtils.toString(is);
      final ExtensionModel extensionModel = new ExtensionModelJsonSerializer().deserialize(extModelStr);
      extensionModels.put(extensionModel.getXmlDslModel().getNamespaceUri(), extensionModel);
    } catch (IOException e) {
      throw new RuntimeException(String.format("There was an IO error working with the [%s] resource", jsonResource), e);
    }
  }
}
