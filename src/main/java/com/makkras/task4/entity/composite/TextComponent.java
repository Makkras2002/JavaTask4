package com.makkras.task4.entity.composite;

import com.makkras.task4.entity.textenum.TextElementName;
import com.makkras.task4.exception.InteractionException;

import java.util.List;

public interface TextComponent {
    String conversionOperation();
    boolean addChild(TextComponent textComponent) throws InteractionException;
    boolean removeChild(TextComponent textComponent) throws InteractionException;
    TextElementName getElementName();
    List<TextComponent> getTopChildren() throws InteractionException;
}
