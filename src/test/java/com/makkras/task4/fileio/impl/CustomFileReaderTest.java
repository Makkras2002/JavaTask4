package com.makkras.task4.fileio.impl;

import com.makkras.task4.exception.InteractionException;
import org.testng.annotations.Test;

public class CustomFileReaderTest {
    String text;
    @Test(expectedExceptions = {InteractionException.class})
    public void testFilePathIncorrectness() throws InteractionException {
        text = CustomFileReader.getInstance().readDataFromFile("errorPath.txt");
    }
}