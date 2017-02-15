package org.mule.tooling.lang.dw;

import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;


public class DataWeaveParserTestSuite extends TestSuite {

  public static final String WEV = ".wev";

  public DataWeaveParserTestSuite() {
    File parentFile = new File(getClass().getResource("Simple.wev").getPath()).getParentFile();
    String[] list = parentFile.list((dir, name) -> name.endsWith(WEV));
    for (String testName : list) {
      WeaveParserTest test = new WeaveParserTest(testName.substring(0, testName.length() - WEV.length()));
      test.setName("testParser");

      addTest(test);
    }


  }

  public static Test suite() {
    return new DataWeaveParserTestSuite();
  }

}
