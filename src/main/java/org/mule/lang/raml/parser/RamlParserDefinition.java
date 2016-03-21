package org.mule.lang.raml.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.mule.lang.raml.lexer.RamlLexer;
import org.mule.lang.raml.lexer.RamlTokenTypes;
import org.mule.lang.raml.psi.impl.*;
import org.jetbrains.annotations.NotNull;

public class RamlParserDefinition implements ParserDefinition {
	@NotNull
	@Override
	public Lexer createLexer(Project project) {
		return new RamlLexer();
	}

	@Override
	public PsiParser createParser(Project project) {
		return new RamlParser();
	}

	@Override
	public IFileElementType getFileNodeType() {
		return RamlElementTypes.FILE;
	}

	@NotNull
	@Override
	public TokenSet getWhitespaceTokens() {
		return RamlTokenTypes.WHITESPACES;
	}

	@NotNull
	@Override
	public TokenSet getCommentTokens() {
		return RamlTokenTypes.COMMENTS;
	}

	@NotNull
	@Override
	public TokenSet getStringLiteralElements() {
		return RamlTokenTypes.STRING_LITERALS;
	}

	@NotNull
	@Override
	public PsiElement createElement(ASTNode node) {
		IElementType type = node.getElementType();

		if (type == RamlElementTypes.KEY_VALUE_PAIR) return new YamlKeyValPairImpl(node);
		else if (type == RamlElementTypes.KEY) return new YamlKeyImpl(node);
		else if (type == RamlElementTypes.COMPOUND_VALUE) return new YamlArrayImpl(node);
		else if (type == RamlElementTypes.ARRAY) return new YamlArrayImpl(node);
		else if (type == RamlElementTypes.SEQUENCE) return new YamlSectionImpl(node);
		else if (type == RamlElementTypes.SCALAR_VALUE) return new YamlScalarImpl(node);
		else if (type == RamlElementTypes.ENTITY) return new YamlEntityImpl(node);
		else if (type == RamlElementTypes.JINJA) return new YamlJinjaImpl(node);
		else if (type == RamlElementTypes.REFERENCE) return new YamlReferenceImpl(node);
		else if (type == RamlElementTypes.ARGS) return new YamlArrayImpl(node); // FIXME: will it work?
		else return new YamlPsiElementImpl(node);
	}

	@Override
	public PsiFile createFile(FileViewProvider viewProvider) {
		return new YamlFileImpl(viewProvider);
	}

	@Override
	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
		return SpaceRequirements.MAY;
	}
}
