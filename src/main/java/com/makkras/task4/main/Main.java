package com.makkras.task4.main;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.fileio.impl.CustomFileReader;
import com.makkras.task4.parser.impl.TextHandler;
import com.makkras.task4.service.impl.TextCompositeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class Main {
    private  static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        TextHandler handler = new TextHandler();
        try {
            TextComponent textComposite = handler.handleRequest(CustomFileReader.getInstance().readDataFromFile("filesrc/text.txt")).get(0);
            logger.info(textComposite.conversionOperation());
            logger.info(TextCompositeService.getInstance().countNumberOfConsonantsAndVowelsInSentence(2,2,textComposite));
//            Map<TextComponent,Integer> wordMap = TextCompositeService.getInstance().findRepetitiveWordsAndTheirNumber(textComposite);
//            for (TextComponent a : wordMap.keySet()){
//                if(wordMap.get(a) >1){
//                    logger.info("\"" + a.conversionOperation() + "\": "+ wordMap.get(a));
//                }
//            }
//            TextCompositeService.getInstance().removeFromTextSentencesWithWordAmountLessThenWritten(16,textComposite);
//            logger.info(textComposite.conversionOperation());
//            TextCompositeService.getInstance().sortParagraphsInTextCompositeBySentenceAmount(textComposite);
//            logger.info(textComposite.conversionOperation());
//            TextComponent sentence = TextCompositeService.getInstance().findSentenceWithTheLongestWord(textComposite);
//            logger.info(sentence.conversionOperation());
        } catch (InteractionException e) {
            logger.error(e);
        }
    }
}
