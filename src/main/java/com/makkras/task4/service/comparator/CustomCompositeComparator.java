package com.makkras.task4.service.comparator;

import com.makkras.task4.entity.TextComponent;

import java.util.Comparator;

public interface CustomCompositeComparator extends Comparator<TextComponent> {
    @Override
    int compare(TextComponent o1, TextComponent o2);
}
