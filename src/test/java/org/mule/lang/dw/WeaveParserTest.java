package org.mule.lang.dw;

import com.intellij.testFramework.ParsingTestCase;
import org.mule.lang.dw.parser.WeaveParserDefinition;

import java.io.File;

public class WeaveParserTest extends ParsingTestCase
{
    public WeaveParserTest()
    {
        super("", "wev", new WeaveParserDefinition());
    }


    public void testSimple()
    {
        doTest(true);
    }

    public void testArray()
    {
        doTest(true);
    }

    public void testArrayContains()
    {
        doTest(true);
    }

    public void testAttributes()
    {
        doTest(true);
    }

    public void testComment()
    {
        doTest(true);
    }

    public void testString()
    {
        doTest(true);
    }

    public void testMatch()
    {
        doTest(true);
    }

    public void testFunctions()
    {
        doTest(true);
    }

    public void testBigDW()
    {
        doTest(true);
    }

    public void testConditionalArrayElements()
    {
        doTest(true);
    }

    public void testConditionalAttributes()
    {
        doTest(true);
    }


    @Override
    protected String getTestDataPath()
    {
        return new File(getClass().getResource("Simple.wev").getPath()).getParent();
    }
}
