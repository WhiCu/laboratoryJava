package les_9;

public class Task2 {
    private String input;

    public Task2(String input) {
        this.input = input;
    }

    public String decryptMessage() {
        String[] words = input.split(" ");
        StringBuilder decryptedMessage = new StringBuilder();
        for (String word : words) {
            decryptedMessage.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        return decryptedMessage.toString().trim();
    }
}