package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.entity.TextComposite;
import com.makkras.task4.entity.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.parser.CustomHandler;

import java.util.ArrayList;
import java.util.List;


public class TextHandler implements CustomHandler {
    private CustomHandler successor = new ParagraphHandler();
    @Override
    public List<TextComponent> handleRequest(String source){
        List<TextComponent> texts = new ArrayList<>();
        texts.add(new TextComposite(TextElementName.TEXT));
        for(TextComponent paragraph : successor.handleRequest(source)){
            texts.get(0).addChild(paragraph);
        }
        return texts;
    }
}
