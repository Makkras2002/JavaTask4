package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.composite.impl.TextComposite;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexemeHandler implements CustomHandler {
    private CustomHandler successor = new CharacterHandler();
    private final static String LEXEMES_DELIMITER_PATTERN = " ";
    @Override
    public List<TextComponent> handleRequest(String source) throws InteractionException {
        List<TextComponent> lexemes = new ArrayList<>();
        List<String> lexemesInString = Arrays.asList(source.split(LEXEMES_DELIMITER_PATTERN).clone());
        int lexemesLoopCounter = 0;
        for(String o : lexemesInString){
            lexemes.add(new TextComposite(TextElementName.LEXEME));
            for(TextComponent s : successor.handleRequest(o)){
                lexemes.get(lexemesLoopCounter).addChild(s);
            }
            lexemesLoopCounter++;
        }
        return lexemes;
    }
}
