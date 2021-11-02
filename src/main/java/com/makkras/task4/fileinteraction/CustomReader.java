package com.makkras.task4.fileinteraction;

import com.makkras.task4.exception.InteractionException;

public interface CustomReader {
    String readDataFromFile(String filePath) throws InteractionException;
}
