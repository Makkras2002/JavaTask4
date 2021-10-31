package com.makkras.task4.main;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.fileop.impl.CustomFileReader;
import com.makkras.task4.parser.impl.TextHandler;
import com.makkras.task4.service.impl.TextCompositeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private  static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        TextHandler handler = new TextHandler();
        try {
            TextComponent textComposite = handler.handleRequest(CustomFileReader.getInstance().readDataFromFile("filesrc/text.txt")).get(0);
//            TextCompositeService.getInstance().removeFromTextSentencesWithWordAmountLessThenWritten(7,textComposite);
            logger.info(textComposite.conversionOperation());
//            TextCompositeService.getInstance().sortParagraphsInTextCompositeBySentenceAmount(textComposite);
//            logger.info(textComposite.conversionOperation());
//            TextComponent sentence = TextCompositeService.getInstance().findSentenceWithTheLongestWord(textComposite);
//            logger.info(sentence.conversionOperation());
        } catch (InteractionException e) {
            logger.error(e);
        }
    }
}
