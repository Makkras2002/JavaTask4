package com.makkras.task4.service;

import com.makkras.task4.entity.TextComponent;
import com.makkras.task4.exception.InteractionException;

import java.util.Map;

public interface CustomCompositeService {
    void sortParagraphsInTextCompositeBySentenceAmount(TextComponent text) throws InteractionException;
    TextComponent findSentenceWithTheLongestWord(TextComponent text) throws InteractionException;
    void removeFromTextSentencesWithWordAmountLessThenWritten(Integer wordsAmount, TextComponent text) throws InteractionException;
    Map<TextComponent,Integer> findRepetitiveWordsAndTheirNumber(TextComponent text) throws InteractionException;
    String countNumberOfConsonantsAndVowelsInSentence(Integer paragraphNumber,Integer sentenceInParagraphNumber,TextComponent text)throws InteractionException;
}
