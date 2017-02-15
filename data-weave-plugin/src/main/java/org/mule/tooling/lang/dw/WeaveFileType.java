package org.mule.tooling.lang.dw;


import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class WeaveFileType extends LanguageFileType {

  private static WeaveFileType instance = new WeaveFileType();

  protected WeaveFileType() {
    super(WeaveLanguage.getInstance());
  }

  @NotNull
  @Override
  public String getName() {
    return "Weave";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "DataWeave transformation file.";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "wev";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return WeaveIcons.DataFileType;
  }


  public static WeaveFileType getInstance() {
    return instance;
  }
}
