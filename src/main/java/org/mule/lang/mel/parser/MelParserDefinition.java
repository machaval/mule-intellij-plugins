package org.mule.lang.mel.parser;


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

import org.mule.lang.mel.MelFile;
import org.mule.lang.mel.MelLanguage;
import org.mule.lang.mel.parser.psi.MelTypes;

public class MelParserDefinition implements ParserDefinition {


    static TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    static TokenSet COMMENTS = TokenSet.create();
    static IFileElementType FILE = new IFileElementType(MelLanguage.getInstance());

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new MelLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new MelParser();
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
        return TokenSet.create(MelTypes.LINE_COMMENT);
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.create(MelTypes.CHARACTER_LITERAL, MelTypes.STRING_LITERAL);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return MelTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        if (fileViewProvider != null) {
            return new MelFile(fileViewProvider);
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
