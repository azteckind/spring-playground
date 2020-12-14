package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void testingWordCounter() {
        WordCounter wordCounter = new WordCounter();
        Map<String, Integer> output = wordCounter.count("this is the way");
        assertEquals("{this = 1, is = 1, the = 1, way = 1}", output.toString());

    }

}
