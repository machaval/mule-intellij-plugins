package org.mule.lang.raml.parser;


import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageUtil;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.raml.RamlFile;
import org.mule.lang.raml.RamlLanguage;
import org.mule.lang.raml.parser.psi.RamlTypes;

import java.io.Reader;

public class RamlParserDefinition implements ParserDefinition {


    static TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    static TokenSet COMMENTS = TokenSet.create();
    static IFileElementType FILE = new IFileElementType(RamlLanguage.getInstance());

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new RamlLexer((Reader) null);
    }

    @Override
    public PsiParser createParser(Project project) {
        return new RamlParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return TokenSet.create(RamlTypes.RAML_COMMENT);
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.create(RamlTypes.XCHAR);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return RamlTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        if (fileViewProvider != null) {
            return new RamlFile(fileViewProvider);
        } else {
            throw new RuntimeException("Invalid file viewer null!!!");
        }
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        final Lexer lexer = createLexer(left.getPsi().getProject());
        return LanguageUtil.canStickTokensTogetherByLexer(left, right, lexer);
    }
}
