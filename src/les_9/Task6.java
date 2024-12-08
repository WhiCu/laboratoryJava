package les_9;

import java.util.ArrayList;
import java.util.List;

public class Task6 {
    private String text;

    public Task6(String text) {
        this.text = text;
    }

    public List<String> findSentences(String keyword) {
        String[] sentences = text.split("[.!?]");
        List<String> result = new ArrayList<>();
        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            for(String word : words){
                if (word.equals(keyword)) {
                    result.add(sentence.trim());
                    break;
                }
            }

        }
        return result;
    }
}