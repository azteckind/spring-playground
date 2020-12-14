package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WordCounterController {

    private WordCounter wordCounter;

    public WordCounterController(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @PostMapping("/words/count")
    public Map<String, Integer> count(@RequestBody String input) {
        return wordCounter.count(input);
    }

}
