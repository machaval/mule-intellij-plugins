package org.mule.tooling.lang.dw.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class WeaveSdk {

  public static boolean isValidWeaveHome(String weaveHome) {
    return new File(weaveHome, "lib").exists();
  }

  public static List<File> getJars(String weaveHome) {
    final File[] libs = new File(weaveHome, "lib").listFiles();
    return Arrays.asList(libs);
  }

}
