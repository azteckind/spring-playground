package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WordCounter {

    public Map<String, Integer> count(String input) {
        String[] words = input.replaceAll("[^a-zA-Z]", "").toLowerCase().split(" ");
        Map<String, Integer> output = new HashMap<>();
        for(String word : words) {
            if(!output.containsKey(word)) {
                output.put(word, 1);
            }//end of if-statement
            else {
                output.put(word, output.get(word) + 1);
            }//end of else-statement
        }//end of for-loop
        return output;
    }
}
