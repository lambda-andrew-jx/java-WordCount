package unText;

import java.util.*;

public class WordFrequency {
    private String text;
    public HashMap<String, Integer> wordcount = new HashMap<>();

    public WordFrequency(String text) {
        this.text = text;
    }
}