package org.mule.tooling.lang.dw;


import com.intellij.lang.CodeDocumentationAwareCommenter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.parser.WeaveParserDefinition;
import org.mule.tooling.lang.dw.parser.psi.WeaveTypes;

public class WeaveCommenter implements CodeDocumentationAwareCommenter {
  @Nullable
  @Override
  public String getLineCommentPrefix() {
    return "//";
  }

  @Nullable
  @Override
  public String getBlockCommentPrefix() {
    return "/*";
  }

  @Nullable
  @Override
  public String getBlockCommentSuffix() {
    return "*/";
  }

  @Nullable
  @Override
  public String getCommentedBlockCommentPrefix() {
    return null;
  }

  @Nullable
  @Override
  public String getCommentedBlockCommentSuffix() {
    return null;
  }

  @Nullable
  @Override
  public IElementType getLineCommentTokenType() {
    return WeaveTypes.LINE_COMMENT;
  }

  @Nullable
  @Override
  public IElementType getBlockCommentTokenType() {
    return WeaveParserDefinition.MULTILINE_COMMENT;
  }

  @Nullable
  @Override
  public IElementType getDocumentationCommentTokenType() {
    return null;
  }

  @Override
  public String getDocumentationCommentPrefix() {
    return "/**";
  }

  @Override
  public String getDocumentationCommentLinePrefix() {
    return "*";
  }

  @Override
  public String getDocumentationCommentSuffix() {
    return "*/";
  }

  @Override
  public boolean isDocumentationComment(PsiComment comment) {
    return false;
  }

}
