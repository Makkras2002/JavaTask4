package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.entity.Letter;
import com.makkras.task4.entity.Punctuation;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CharacterHandler implements CustomHandler {
    private final static String CHARACTERS_DELIMITER_PATTERN = "";
    private final static String PUNCTUATION_PATTERN ="\\p{Punct}";
    @Override
    public List<TextComponent> handleRequest(String source) {
        List<TextComponent> characters = new ArrayList<>();
        List<String> charactersInString = Arrays.asList(source.split(CHARACTERS_DELIMITER_PATTERN).clone());
        for(String character : charactersInString){
            if(Pattern.matches(PUNCTUATION_PATTERN,character)){
                characters.add(new Punctuation(character));
            }else {
                characters.add(new Letter(character));
            }
        }
        return characters;
    }
}
