package com.makkras.task4.service.impl;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.entity.TextComposite;
import com.makkras.task4.entity.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.fileio.impl.CustomFileReader;
import com.makkras.task4.parser.impl.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextCompositeServiceTest {
    TextHandler textHandler;
    TextComponent composite;
    TextComponent sentenceComposite;
    private static Logger logger = LogManager.getLogger();
    @BeforeMethod
    public void setUp() {
        sentenceComposite = new TextComposite(TextElementName.SENTENCE);
        textHandler = new TextHandler();
        composite = new TextComposite(TextElementName.TEXT);
    }
    @Test
    public void countNumberOfConsonantsAndVowelsInSentenceTest(){
        try {
            composite = textHandler.handleRequest(CustomFileReader.getInstance().readDataFromFile("filesrc/text.txt")).get(0);
            assertEquals(TextCompositeService.getInstance().countNumberOfConsonantsAndVowelsInSentence(4,1,composite),"vowels: 29, consonants: 39.");
        } catch (InteractionException e) {
            logger.error(e.getMessage());
        }
    }
    @Test(expectedExceptions = {InteractionException.class})
    public void testErrorElementPassingExceptionThrowing() throws InteractionException{
        TextCompositeService.getInstance().sortParagraphsInTextCompositeBySentenceAmount(sentenceComposite);
    }
}