package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.entity.TextComposite;
import com.makkras.task4.entity.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexemeHandler implements CustomHandler {
    private CustomHandler successor = new CharacterHandler();
    private final static String LEXEMES_DELIMITER_PATTERN = " ";
    private final static String EMPTY_WORD_PATTERN = "";
    @Override
    public List<TextComponent> handleRequest(String source){
        List<TextComponent> lexemes = new ArrayList<>();
        List<String> lexemesInString = Arrays.asList(source.split(LEXEMES_DELIMITER_PATTERN).clone());
        int lexemesLoopCounter = 0;
        for(String lexeme : lexemesInString){
            if(!lexeme.equals(EMPTY_WORD_PATTERN)){
                lexemes.add(new TextComposite(TextElementName.LEXEME));
                for(TextComponent symbol : successor.handleRequest(lexeme)){
                    lexemes.get(lexemesLoopCounter).addChild(symbol);
                }
                lexemesLoopCounter++;
            }
        }
        return lexemes;
    }
}
