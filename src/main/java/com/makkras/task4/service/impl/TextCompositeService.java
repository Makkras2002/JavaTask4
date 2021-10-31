package com.makkras.task4.service.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.composite.impl.TextComposite;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.service.CustomCompositeService;
import com.makkras.task4.service.comparator.impl.IndexesComparator;
import com.makkras.task4.service.comparator.impl.LexemesByWordSizeComparator;
import com.makkras.task4.service.comparator.impl.ParagraphsBySentenceAmountComparator;

import java.util.*;

public class TextCompositeService implements CustomCompositeService {
    private static TextCompositeService instance;
    private TextCompositeService(){}
    public static TextCompositeService getInstance() {
        if(instance == null){
            instance = new TextCompositeService();
        }
        return instance;
    }
    public void sortParagraphsInTextCompositeBySentenceAmount(TextComponent text) throws InteractionException {
        TextComponent sortedText = new TextComposite(TextElementName.TEXT);
        if(text.getElementName()!= TextElementName.TEXT){
            throw new InteractionException("Invalid text element was passed into method.");
        }else {
            List<TextComponent> paragraphs = text.getTopChildren();
            paragraphs.sort(new ParagraphsBySentenceAmountComparator());
            for(TextComponent o : paragraphs){
                sortedText.addChild(o);
            }
        }
        text = sortedText;
    }
    public TextComponent findSentenceWithTheLongestWord(TextComponent text) throws InteractionException{
        TextComponent sentence = new TextComposite(TextElementName.SENTENCE);
        if(text.getElementName()!= TextElementName.TEXT){
            throw new InteractionException("Invalid text element was passed into method.");
        }else {
            Map<Integer, TextComponent> sentenceAndBiggestWordSizeInText = new HashMap<>();
            List<TextComponent> paragraphs = text.getTopChildren();
            for(TextComponent o : paragraphs){
                List<TextComponent> initialSentences = o.getTopChildren();
                Map<Integer, TextComponent> sentenceAndBiggestWordSizeInParagraph = new HashMap<>();
                for(TextComponent a : initialSentences){
                    List<TextComponent> initialLexemes = a.getTopChildren();
                    TextComponent biggestWord = initialLexemes.stream().max(new LexemesByWordSizeComparator()).get();
                    sentenceAndBiggestWordSizeInParagraph.put(getLettersAmountInLexeme(biggestWord),a);
                }
                int biggestLettersNumberInParagraph = sentenceAndBiggestWordSizeInParagraph.keySet().stream().max(new IndexesComparator()).get();
                sentenceAndBiggestWordSizeInText.put(biggestLettersNumberInParagraph,
                        sentenceAndBiggestWordSizeInParagraph.get(biggestLettersNumberInParagraph));
            }
            int biggestLettersNumberInText =sentenceAndBiggestWordSizeInText.keySet().stream().max(new IndexesComparator()).get();
            sentence = sentenceAndBiggestWordSizeInText.get(biggestLettersNumberInText);
        }
        return sentence;

    }
    public void removeFromTextSentencesWithWordAmountLessThenWritten(Integer wordsAmount, TextComponent text) throws InteractionException {
       if(text.getElementName() != TextElementName.TEXT){
           throw new InteractionException("Invalid text element was passed into method.");
       }else {
           Map<Integer,Map<Integer,TextComponent>> sentencesToRemove = new HashMap<>();
           int paragraphNumber = 0;
           int outerMapCounter = 0;
           for(TextComponent o : text.getTopChildren()){
               for(TextComponent a : o.getTopChildren()){
                   int sentenceSize = a.getTopChildren().size();
                   if(sentenceSize < wordsAmount){
                       Map<Integer,TextComponent> innerMap = new HashMap<>();
                       innerMap.put(paragraphNumber,a);
                       sentencesToRemove.put(outerMapCounter,innerMap);
                       outerMapCounter++;
                   }
               }
               paragraphNumber++;
           }
           int tempCounter =0;
           while (tempCounter < outerMapCounter){
               for(Integer o : sentencesToRemove.get(tempCounter).keySet()){
                   text.getTopChildren().get(o).removeChild(sentencesToRemove.get(tempCounter).get(o));
               }
               tempCounter++;
           }
       }
    }
    private Integer getLettersAmountInLexeme(TextComponent lexeme) throws InteractionException {
        if(lexeme.getElementName() != TextElementName.LEXEME){
            throw new InteractionException("Invalid text element was passed into method.");
        }else {
            int lettersCounter = 0;
            for(TextComponent o : lexeme.getTopChildren()){
                if(o.getElementName() == TextElementName.LETTER){
                    lettersCounter++;
                }
            }
            return lettersCounter;
        }
    }
}
