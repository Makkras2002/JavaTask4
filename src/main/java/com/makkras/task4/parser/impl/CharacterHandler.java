package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.composite.impl.Letter;
import com.makkras.task4.entity.composite.impl.Punctuation;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterHandler implements CustomHandler {
    private final static String CHARACTERS_DELIMITER_PATTERN = "";
    @Override
    public List<TextComponent> handleRequest(String source) {
        List<TextComponent> characters = new ArrayList<>();
        List<String> charactersInString = Arrays.asList(source.split(CHARACTERS_DELIMITER_PATTERN).clone());
        for(String o : charactersInString){
            if(o.equals(".") || o.equals("?") || o.equals(",") || o.equals("!") || o.equals(",") || o.equals(")") ||
                    o.equals("(")|| o.equals("\"") || o.equals("\'") || o.equals(":") || o.equals("=")){
                characters.add(new Punctuation(o));
            }else {
                characters.add(new Letter(o));
            }
        }
        return characters;
    }
}
