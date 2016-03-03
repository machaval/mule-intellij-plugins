package org.mule.lang.raml.lexer;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;

import java.io.StringReader;

/**
 * User: plducharme
 * Date: 06/02/14
 * Time: 2:37 PM
 * Description:
 */
public class RamlBaseLexer extends LexerBase implements RamlDocTokenTypes {

    private int currStartOffset;
    private int currEndOffset;
    private int tokenStart;
    private int tokenEnd;
    private int lastState;
    private CharSequence buffer;
    private int lineIdx = 0;
    private IElementType myTokenType = null;
    private IElementType prevTokenType = null;

    private Yaml yaml;
    private Iterable<Event> events;
    private Event currEvent;

    private String[] lines;

    private static final String RAML_VERSION_0_8 = "#%RAML 0.8";

    public RamlBaseLexer() {
        super();
    }

    @Override
    public void start(CharSequence charSequence, int startOffset, int endOffset, int state) {
        buffer = charSequence;
        currStartOffset = startOffset;
        currEndOffset = endOffset;
        lastState = state;
        lines = buffer.toString().split("\\r?\\n");
        yaml = new Yaml();
        events = yaml.parse(new StringReader(charSequence.toString()));
    }

    @Override
    public int getState() {
        lastState = 0;
        return lastState;
    }

    @Nullable
    @Override
    public IElementType getTokenType() {
        locateToken();
        return myTokenType;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTokenStart() {
        locateToken();
        return tokenStart;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTokenEnd() {
        locateToken();
        return tokenEnd;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void advance() {
        locateToken();
        myTokenType = null;
    }

    @Override
    public CharSequence getBufferSequence() {
        return buffer;
    }

    @Override
    public int getBufferEnd() {
        return buffer.length();  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void locateToken(){

        prevTokenType = myTokenType;
        myTokenType = null;

        if(!events.iterator().hasNext()){
            return;
        }

        currEvent = events.iterator().next();

        if(currEvent instanceof StreamStartEvent){
            StreamStartEvent startEvent = (StreamStartEvent) currEvent;
            if(buffer.toString().startsWith(RAML_VERSION_0_8)){
                myTokenType = RDOC_VERSION_TOKEN;
                tokenStart = currEvent.getStartMark().getIndex();
                tokenEnd = tokenStart + RAML_VERSION_0_8.length()+1;
                return;
            } else {
                //todo unsupported RAML version
            }

        }

        while(!(currEvent instanceof ScalarEvent)){
            if(events.iterator().hasNext()){
                currEvent = events.iterator().next();
            } else {
                return;
            }
        }
        ScalarEvent scalarEvent = (ScalarEvent) currEvent;

        tokenStart = currEvent.getStartMark().getIndex();
        tokenEnd = currEvent.getEndMark().getIndex();

        if(prevTokenType == RDOC_VERSION_TOKEN){
            if(!scalarEvent.getValue().equals("title")){
                //todo missing title
            }
            myTokenType = RDOC_TITLE_TOKEN;
            return;
        } else if(prevTokenType == RDOC_TITLE_TOKEN){
            myTokenType = RDOC_TITLE_VALUE_TOKEN;
            return;
        } else if(scalarEvent.getValue().startsWith("/{")){
            myTokenType = RDOC_URL_PARAM_TOKEN;
            return;
        } else if(scalarEvent.getValue().startsWith("/")){
            myTokenType = RDOC_URL_PATH_TOKEN;
            return;
        }else {
            myTokenType = RDOC_UNKNOWN_TOKEN;
            return;
        }


        /*
        if(currEndOffset == tokenEnd){
            myTokenType = null;
            currStartOffset = currEndOffset;
        }




        if(lineIdx == 0){
            if(lines[lineIdx].equals(RAML_VERSION_0_8)){
                currEndOffset = currStartOffset + RAML_VERSION_0_8.length()+1;
                tokenStart = currStartOffset;
                tokenEnd = currEndOffset;
                myTokenType = RDOC_VERSION_TOKEN;
                lineIdx++;
            }
        }

        while(lineIdx <= lines.length){

        }
        */



    }

}
