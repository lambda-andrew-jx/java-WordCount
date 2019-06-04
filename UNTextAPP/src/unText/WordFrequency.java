package unText;

public class WordFrequency {
    private String text;
    private HashMap<String, Integer> wordCount = new HashMap<>();

    public WordFrequency(String text) {
        this.text = text;
        cleanText();
        addWordsToMap();
    }
}