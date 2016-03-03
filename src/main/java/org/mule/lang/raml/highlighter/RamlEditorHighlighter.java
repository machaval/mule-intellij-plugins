package org.mule.lang.raml.highlighter;

import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.ex.util.LayeredLexerEditorHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

/**
 * User: plducharme
 * Date: 06/02/14
 * Time: 11:17 AM
 * Description:
 */
public class RamlEditorHighlighter extends LayeredLexerEditorHighlighter{
    public RamlEditorHighlighter(@NotNull EditorColorsScheme editorColorsScheme) {
        super(new RamlSyntaxHighlighter(), editorColorsScheme);

        //SyntaxHighlighter RamlDocHighlighter =
    }
}
