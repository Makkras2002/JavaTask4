package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.entity.TextComposite;
import com.makkras.task4.entity.TextElementName;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphHandler implements CustomHandler {
    private final static String PARAGRAPH_DELIMITER_PATTERN = "(?m)(?=^\\s{4})";
    private final static String NEW_LINE_PATTERN = "\n";
    private CustomHandler successor = new SentenceHandler();
    @Override
    public List<TextComponent> handleRequest(String source){
        List<TextComponent> paragraphs = new ArrayList<>();
        List<String> paragraphsInString = Arrays.asList(source.split(PARAGRAPH_DELIMITER_PATTERN).clone());
        int paragraphLoopCounter = 0;
        for(String paragraph : paragraphsInString){
            if(!paragraph.equals(NEW_LINE_PATTERN)){
                paragraphs.add(new TextComposite(TextElementName.PARAGRAPH));
                for(TextComponent s : successor.handleRequest(paragraph)){
                    paragraphs.get(paragraphLoopCounter).addChild(s);
                }
                paragraphLoopCounter++;
            }
        }
        return paragraphs;
    }
}
