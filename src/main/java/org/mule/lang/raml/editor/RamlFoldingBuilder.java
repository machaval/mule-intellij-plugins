package org.mule.lang.raml.editor;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.mule.lang.raml.lexer.RamlTokenTypes;
import org.mule.lang.raml.parser.RamlElementTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * Fold sections in Yaml
 */
public class RamlFoldingBuilder implements FoldingBuilder, RamlTokenTypes
{
	private static final TokenSet COMPOUND_VALUE = TokenSet.create(
		RamlElementTypes.COMPOUND_VALUE,
		RamlElementTypes.HASH
	);

	@NotNull
	public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode astNode, @NotNull Document document) {
		List descriptors = new LinkedList();
		collectDescriptors(astNode, descriptors);
		return (FoldingDescriptor[]) descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
	}

	@Nullable
	public String getPlaceholderText(@NotNull ASTNode node) {
		IElementType type = node.getElementType();
		if (type == RamlElementTypes.KEY_VALUE_PAIR) {
			return node.getFirstChildNode().getText();
		}
		if (type == RamlElementTypes.SCALAR_VALUE) {
			return node.getText().substring(0, 1);
		}
		return "...";
	}

	public boolean isCollapsedByDefault(@NotNull ASTNode node) {
		return false;
	}


	private static void collectDescriptors(@NotNull ASTNode node, @NotNull List<FoldingDescriptor> descriptors) {
		IElementType type = node.getElementType();
		TextRange nodeTextRange = node.getTextRange();
		if ((!StringUtil.isEmptyOrSpaces(node.getText())) && (nodeTextRange.getLength() >= 2)) {
			if (type == RamlElementTypes.KEY_VALUE_PAIR) {
				ASTNode[] children = node.getChildren(COMPOUND_VALUE);

				if ((children.length > 0) && (!StringUtil.isEmpty(children[0].getText().trim()))) {
					descriptors.add(new FoldingDescriptor(node, nodeTextRange));
				}
			}
			if (type == RamlElementTypes.SCALAR_VALUE) {
				descriptors.add(new FoldingDescriptor(node, nodeTextRange));
			}
		}
		for (ASTNode child : node.getChildren(null)) {
			collectDescriptors(child, descriptors);
		}
	}
}
