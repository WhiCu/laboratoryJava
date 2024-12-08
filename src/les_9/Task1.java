package les_9;

public class Task1 {
    private String input;

    public Task1(String input) {
        this.input = input;
    }

    public String removeCapitalLetters() {
        return input.replaceAll("[A-Z]", "");
    }
}