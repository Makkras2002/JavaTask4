package com.makkras.task4.entity;

import java.util.List;

public interface TextComponent {
    String conversionOperation();
    boolean addChild(TextComponent textComponent);
    boolean removeChild(TextComponent textComponent);
    TextElementName getElementName();
    List<TextComponent> getTopChildren();
}
