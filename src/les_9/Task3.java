package les_9;

public class Task3 {
    private String input;

    public Task3(String input) {
        this.input = input;
    }

    public int countThreeLetterWords() {
        String[] words = input.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.length() == 3) {
                count++;
            }
        }
        return count;
    }
}