package com.makkras.task4.parser;

import com.makkras.task4.entity.TextComponent;

import java.util.List;

public interface CustomHandler {
    List<TextComponent> handleRequest(String source);
}

