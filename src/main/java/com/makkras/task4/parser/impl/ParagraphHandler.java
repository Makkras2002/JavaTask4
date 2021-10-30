package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.composite.impl.TextComposite;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphHandler implements CustomHandler {
    private final static String PARAGRAPH_DELIMITER_PATTERN = "(?m)(?=^\\\\s{4})";
    private CustomHandler successor = new SentenceHandler();
    @Override
    public List<TextComponent> handleRequest(String source) throws InteractionException {
        List<TextComponent> paragraphs = new ArrayList<>();
        List<String> paragraphsInString = Arrays.asList(source.split(PARAGRAPH_DELIMITER_PATTERN).clone());
        int paragraphLoopCounter = 0;
        for(String o : paragraphsInString){
            paragraphs.add(new TextComposite(TextElementName.PARAGRAPH));
            for(TextComponent s : successor.handleRequest(o)){
                paragraphs.get(paragraphLoopCounter).addChild(s);
            }
            paragraphLoopCounter++;
        }
        return paragraphs;
    }
}
