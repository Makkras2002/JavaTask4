package com.makkras.task4.service.comparator.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.service.comparator.CustomCompositeComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphsBySentenceAmountComparator implements CustomCompositeComparator {
    private static Logger logger = LogManager.getLogger();
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        try {
            if(o1.getTopChildren().size() > o2.getTopChildren().size()){
                return 1;
            }else if(o1.getTopChildren().size() < o2.getTopChildren().size()){
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
