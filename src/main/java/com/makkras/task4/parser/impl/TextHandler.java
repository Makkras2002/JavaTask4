package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.composite.impl.TextComposite;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.parser.CustomHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class TextHandler implements CustomHandler {
    private CustomHandler successor = new ParagraphHandler();
    @Override
    public List<TextComponent> handleRequest(String source) throws InteractionException {
        List<TextComponent> texts = new ArrayList<>();
        texts.add(new TextComposite(TextElementName.TEXT));
        for(TextComponent o: texts){
            for(TextComponent s : successor.handleRequest(source)){
                o.addChild(s);
            }
        }
        return texts;
    }
}
