package com.makkras.task4.main;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.composite.impl.Letter;
import com.makkras.task4.entity.composite.impl.Punctuation;
import com.makkras.task4.entity.composite.impl.TextComposite;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;
import com.makkras.task4.fileop.impl.CustomFileReader;
import com.makkras.task4.parser.impl.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private  static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
//        TextComposite text = new TextComposite(TextElementName.TEXT);
//        TextComposite paragraph1= new TextComposite(TextElementName.PARAGRAPH);
//
//        TextComposite paragraph2= new TextComposite(TextElementName.PARAGRAPH);
//
//        TextComposite sentence1 = new TextComposite(TextElementName.SENTENCE);
//
//        TextComposite sentence2 = new TextComposite(TextElementName.SENTENCE);
//
//
//        TextComposite word1 = new TextComposite(TextElementName.LEXEME);
//        Punctuation p1 = new Punctuation("");
//        Letter letter1 = new Letter("a");
//        Letter letter2 = new Letter("b");
//        TextComposite word2 = new TextComposite(TextElementName.LEXEME);
//        Punctuation p2 = new Punctuation("");
//        Letter letter3 = new Letter("c");
//        Letter letter4 = new Letter("d");
//        Letter letter5 = new Letter("e");
//        TextComposite word3 = new TextComposite(TextElementName.LEXEME);
//        Punctuation p3 = new Punctuation(".");
//        Letter letter6 = new Letter("f");
//        Letter letter7 = new Letter("g");
//        Letter letter8 = new Letter("h");
//        Letter letter9 = new Letter("i");
//
//        TextComposite word4 = new TextComposite(TextElementName.LEXEME);
//        Punctuation p4 = new Punctuation("");
//        Letter letter10 = new Letter("a");
//        Letter letter11 = new Letter("b");
//        TextComposite word5 = new TextComposite(TextElementName.LEXEME);
//        Punctuation p5 = new Punctuation(".");
//        Letter letter12 = new Letter("a");
//        Letter letter13 = new Letter("b");
//        Letter letter14 = new Letter("c");
//        Letter letter15 = new Letter("d");
//
//        word1.addChild(letter1);
//        word1.addChild(letter2);
//        word1.addChild(p1);
//
//        word2.addChild(letter3);
//        word2.addChild(letter4);
//        word2.addChild(letter5);
//        word2.addChild(p2);
//
//        word3.addChild(letter6);
//        word3.addChild(letter7);
//        word3.addChild(letter8);
//        word3.addChild(letter9);
//        word3.addChild(p3);
//
//        word4.addChild(letter10);
//        word4.addChild(letter11);
//        word4.addChild(p4);
//
//        word5.addChild(letter12);
//        word5.addChild(letter13);
//        word5.addChild(letter14);
//        word5.addChild(letter15);
//        word5.addChild(p5);
//
//        sentence1.addChild(word1);
//        sentence1.addChild(word2);
//        sentence1.addChild(word3);
//
//        sentence2.addChild(word4);
//        sentence2.addChild(word5);
//
//
//        paragraph1.addChild(sentence1);
//        paragraph1.addChild(sentence2);
//        paragraph1.addChild(sentence1);
//        paragraph1.addChild(sentence1);
//        paragraph1.addChild(sentence2);
//        paragraph1.addChild(sentence1);
//        paragraph1.addChild(sentence1);
//        paragraph1.addChild(sentence2);
//        paragraph1.addChild(sentence1);
//        paragraph1.addChild(sentence1);
//        paragraph1.addChild(sentence2);
//        paragraph1.addChild(sentence1);
//
//        paragraph2.addChild(sentence2);
//        paragraph2.addChild(sentence1);
//        paragraph2.addChild(sentence2);
//
//        text.addChild(paragraph1);
//
//        text.addChild(paragraph2);
//
//        System.out.println(text.conversionOperation());
//
//        try {
//            System.out.println(CustomFileReader.getInstance().readDataFromFile("filesrc/text.txt"));
//        } catch (InteractionException e) {
//            e.printStackTrace();
//        }
        TextHandler handler = new TextHandler();
        try {
            TextComponent textComposite = handler.handleRequest(CustomFileReader.getInstance().readDataFromFile("filesrc/text.txt")).get(0);
            logger.info(textComposite.conversionOperation());
        } catch (InteractionException e) {
            logger.error(e);
        }
    }
}
