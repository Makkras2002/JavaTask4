package com.makkras.task4.service.comparator.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.service.comparator.CustomCompositeComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LexemesByWordSizeComparator implements CustomCompositeComparator {
    private static Logger logger = LogManager.getLogger();
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        try {
            List<TextComponent> lettersAndPunctuationInO1 = o1.getTopChildren();
            List<TextComponent> lettersAndPunctuationInO2 = o2.getTopChildren();
            int numberOfLettersInO1 = 0;
            int numberOfLettersInO2 = 0;
            for(TextComponent o : lettersAndPunctuationInO1){
                if(o.getElementName() == TextElementName.LETTER){
                    numberOfLettersInO1++;
                }
            }
            for(TextComponent o : lettersAndPunctuationInO2){
                if(o.getElementName() == TextElementName.LETTER){
                    numberOfLettersInO2++;
                }
            }
            if(numberOfLettersInO1 > numberOfLettersInO2){
                return 1;
            }else if(numberOfLettersInO1 < numberOfLettersInO2){
                return -1;
            }else {
                return  0;
            }
        } catch (InteractionException e) {
            logger.error(e);
        }
        return 0;
    }
}
