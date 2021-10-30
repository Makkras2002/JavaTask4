package com.makkras.task4.entity.composite.impl;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;

import java.util.List;

public class Letter implements TextComponent {
    private TextElementName elementName;
    private String symbolValue;
    public Letter(String symbolValue){
        this.symbolValue = symbolValue;
        elementName = TextElementName.LETTER;
    }
    @Override
    public String conversionOperation() {
        return getValue();
    }
    @Override
    public boolean addChild(TextComponent textComponent) throws InteractionException {
        throw new InteractionException("Can not invoke this method for leaf component.");
    }

    @Override
    public boolean removeChild(TextComponent textComponent) throws InteractionException {
        throw new InteractionException("Can not invoke this method for leaf component.");
    }

    private String getValue() {
        return symbolValue;
    }
    @Override
    public TextElementName getElementName() {
        return elementName;
    }

    @Override
    public List<TextComponent> getTopChildren() throws InteractionException {
        throw new InteractionException("Can not invoke this method for leaf component.");
    }
}
