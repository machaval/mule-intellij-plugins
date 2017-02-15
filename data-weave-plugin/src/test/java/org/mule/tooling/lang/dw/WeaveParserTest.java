package org.mule.tooling.lang.dw;

import com.intellij.openapi.fileEditor.impl.LoadTextUtil;
import com.intellij.psi.util.PsiUtil;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.testFramework.LightVirtualFile;
import com.intellij.testFramework.ParsingTestCase;
import junit.framework.Test;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.lang.dw.parser.WeaveParserDefinition;

import java.io.File;
import java.io.IOException;

public class WeaveParserTest extends ParsingTestCase  {
  private String name;

  public WeaveParserTest(String name) {
    super("", "wev", new WeaveParserDefinition());
    this.name = name;
  }


  public void testParser() {
    try {
      String text = loadFile(name + "." + myFileExt);
      myFile = createPsiFile(name, text);
      ensureParsed(myFile);
      assertEquals("light virtual file text mismatch", text, ((LightVirtualFile) myFile.getVirtualFile()).getContent().toString());
      assertEquals("virtual file text mismatch", text, LoadTextUtil.loadText(myFile.getVirtualFile()));
      assertEquals("doc text mismatch", text, myFile.getViewProvider().getDocument().getText());
      assertEquals("psi text mismatch", text, myFile.getText());
      ensureCorrectReparse(myFile);
      
      checkResult(name, myFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @NotNull
  @Override
  protected String getTestName(boolean lowercaseFirstLetter) {
    return name;
  }

  @Override
  protected String getTestDataPath() {
    return new File(getClass().getResource("Simple.wev").getPath()).getParent();
  }
}
