package org.mule.lang.mel;


import com.intellij.testFramework.ParsingTestCase;
import org.mule.lang.mel.parser.MelParserDefinition;

import java.io.File;

public class MelParserTest extends ParsingTestCase {
    public MelParserTest() {
        super("", "mel", new MelParserDefinition());
    }


    /**
     * Test the minimal mel functionality
     */
    public void testSimple() {
        doTest(true);
    }

    public void testFunctionCall() {
        doTest(true);
    }

    public void testConditional() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        final String path = getClass().getResource("Simple.mel").getPath();
        return new File(path).getParent();
    }


}
