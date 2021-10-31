package com.makkras.task4.service.comparator.impl;

import com.makkras.task4.service.comparator.CustomIntegerComparator;

public class IndexesComparator implements CustomIntegerComparator {
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1>o2){
            return 1;
        }else if(o1<o2){
            return -1;
        }else {
            return 0;
        }
    }
}
