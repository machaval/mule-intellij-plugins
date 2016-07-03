package org.mule.tooling.lang.raml;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.NotNull;

/**
 * Comment line/block
 */
public class RamlCommenter implements Commenter {
	@NotNull
	@Override
	public String getLineCommentPrefix() {
		return "#";
	}

	@Override
	public String getBlockCommentPrefix() {
		return null;
	}

	@Override
	public String getBlockCommentSuffix() {
		return null;
	}

	@Override
	public String getCommentedBlockCommentPrefix() {
		return null;
	}

	@Override
	public String getCommentedBlockCommentSuffix() {
		return null;
	}
}
