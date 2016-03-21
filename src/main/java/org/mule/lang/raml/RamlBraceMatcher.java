package org.mule.lang.raml;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.raml.lexer.RamlTokenTypes;

/**
 * Matches starting-closing braces in neon
 */
public class RamlBraceMatcher implements PairedBraceMatcher, RamlTokenTypes {
	private static final BracePair[] PAIRS = {
			new BracePair(RAML_LBRACE_CURLY, RAML_RBRACE_CURLY, true),  // {}
			new BracePair(RAML_LBRACE_SQUARE, RAML_RBRACE_SQUARE, true), // []
	};

	@Override
	public BracePair[] getPairs() {
		return PAIRS;
	}

	@Override
	public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType iElementType, @Nullable IElementType iElementType1) {
		return true;
	}

	@Override
	public int getCodeConstructStart(PsiFile psiFile, int openingBraceOffset) {
		return openingBraceOffset;
	}
}
