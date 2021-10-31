package com.makkras.task4.service.comparator;

import java.util.Comparator;

public interface CustomIntegerComparator extends Comparator<Integer> {
    @Override
    int compare(Integer o1, Integer o2);
}
