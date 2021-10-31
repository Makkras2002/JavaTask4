package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.composite.impl.TextComposite;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceHandler implements CustomHandler {
    private CustomHandler successor = new LexemeHandler();
    private final static String SENTENCES_DELIMITER_PATTERN = "(?<=[.!?])\\s* ";
    @Override
    public List<TextComponent> handleRequest(String source) throws InteractionException {
        List<TextComponent> sentences = new ArrayList<>();
        List<String> sentencesInString = Arrays.asList(source.split(SENTENCES_DELIMITER_PATTERN).clone());
        int sentencesLoopCounter = 0;
        for(String o : sentencesInString){
            if(!o.equals("\n")){
                sentences.add(new TextComposite(TextElementName.SENTENCE));
                for(TextComponent s : successor.handleRequest(o)){
                    sentences.get(sentencesLoopCounter).addChild(s);
                }
                sentencesLoopCounter++;
            }
        }
        return sentences;
    }
}
