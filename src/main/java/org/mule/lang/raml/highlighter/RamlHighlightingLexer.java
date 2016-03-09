package org.mule.lang.raml.highlighter;

import com.intellij.lexer.LayeredLexer;
import com.intellij.lexer.Lexer;
import com.intellij.lexer.LookAheadLexer;
import com.intellij.psi.tree.IElementType;
import org.mule.lang.raml.parser.RamlLexer;
import org.mule.lang.raml.parser.RamlTokenTypes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Lexer used for syntax highlighting
 *
 * It reuses the simple lexer, changing types of some tokens
 */
public class RamlHighlightingLexer extends LookAheadLexer {

    private static final Set<String> KEYWORDS = new HashSet<String>(Arrays.asList(
            new String[]{
                    "true", "True", "TRUE", "yes", "Yes", "YES", "on", "On", "ON",
                    "false", "False", "FALSE", "no", "No", "NO", "off", "Off", "OFF",
                    "null", "Null", "NULL",
                    "title", "baseUri", "version", "schemas", "traits", "headers", "description", "is", "get", "post", "put", "delete", "patch",
                    "description", "body", "example", "schema", "responses"
            }
    ));

    public RamlHighlightingLexer(Lexer baseLexer) {
        super(baseLexer, 1);
    }

    @Override
    protected void lookAhead(Lexer baseLexer) {
        IElementType currentToken = baseLexer.getTokenType();

        if (currentToken == RamlTokenTypes.RAML_LITERAL && KEYWORDS.contains(baseLexer.getTokenText())) {
            advanceLexer(baseLexer);
            replaceCachedType(0, RamlTokenTypes.RAML_KEYWORD);

        } else if (currentToken == RamlTokenTypes.RAML_LITERAL || currentToken == RamlTokenTypes.RAML_STRING) {
            advanceLexer(baseLexer);

            if (baseLexer.getTokenType() == RamlTokenTypes.RAML_WHITESPACE) {
                advanceLexer(baseLexer);
            }

            if (baseLexer.getTokenType() == RamlTokenTypes.RAML_COLON) {
                advanceLexer(baseLexer);
                replaceCachedType(0, RamlTokenTypes.RAML_KEY);
            }

        } else {
            super.lookAhead(baseLexer);
        }
    }
}
