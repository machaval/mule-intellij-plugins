package org.mule.tooling.lang.dw.parser;

import com.intellij.lang.ASTNode;
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
import org.mule.tooling.lang.dw.WeaveFile;
import org.mule.tooling.lang.dw.WeaveLanguage;
import org.mule.tooling.lang.dw.lexer.WeaveLexer;
import org.mule.tooling.lang.dw.parser.psi.WeaveTypes;


public class WeaveParserDefinition implements ParserDefinition {

    static TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    static TokenSet COMMENTS = TokenSet.create(WeaveTypes.LINE_COMMENT);
    static IFileElementType FILE = new IFileElementType(WeaveLanguage.getInstance());


    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new WeaveLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new WeaveParser();
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
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.create(WeaveTypes.DOUBLE_QUOTED_STRING, WeaveTypes.SINGLE_QUOTED_STRING);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return WeaveTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        if (viewProvider != null) {
            return new WeaveFile(viewProvider);
        } else {
            throw new RuntimeException("Invalid file viewer null!!!");
        }
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MAY;
    }
}
