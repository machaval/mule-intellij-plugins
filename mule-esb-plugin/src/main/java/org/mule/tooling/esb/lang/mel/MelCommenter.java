package org.mule.tooling.esb.lang.mel;


import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

public class MelCommenter implements Commenter {

    public static final String COMMENT_LINE = "//";

    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return COMMENT_LINE;
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return COMMENT_LINE;
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return COMMENT_LINE;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return COMMENT_LINE;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return "";
    }
}
