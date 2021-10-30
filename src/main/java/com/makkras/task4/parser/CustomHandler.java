package com.makkras.task4.parser;

import com.makkras.task4.entity.composite.TextComponent;
import com.makkras.task4.exception.InteractionException;

import java.util.List;

public interface CustomHandler {
    List<TextComponent> handleRequest(String source) throws InteractionException;
}

