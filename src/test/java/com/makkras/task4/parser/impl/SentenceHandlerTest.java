package com.makkras.task4.parser.impl;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.entity.TextComposite;
import com.makkras.task4.entity.TextElementName;
import com.makkras.task4.parser.CustomHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceHandlerTest {
    private String sentence;
    CustomHandler textHandler;
    TextComponent component;
    @BeforeMethod
    public void setUp() {
        sentence = "Hello my name is Maksim. ";
        textHandler = new SentenceHandler();
        component = new TextComposite(TextElementName.SENTENCE);
    }
    @Test
    public void testSentenceHandlerSize(){
        component = textHandler.handleRequest(sentence).get(0);
        assertEquals(component.getTopChildren().size(),5);
    }
    @Test
    public void testSentenceHandlerCorrectness(){
        component = textHandler.handleRequest(sentence).get(0);
        assertEquals(component.conversionOperation(),sentence);
    }
}