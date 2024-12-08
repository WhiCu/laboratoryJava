package les_9;

import java.util.Arrays;

public class Task7 {
    private String input;

    public Task7(String input) {
        this.input = input;
    }

    public int calculateTelegramCost() {
        String[] words = input.split("[ ,]+"); // Разделяем по пробелам и запятым
        int count = 0;
        StringBuilder transformedText = new StringBuilder();

        for (String word : words) {
            if (word.length() <= 2) { // Пропускаем предлоги
                continue;
            }
            if (word.equals(",")) {
                transformedText.append("zpt "); // Заменяем запятые
            } else {
                transformedText.append(word).append(" ");
                count++;
            }
        }

        int cost = count * 10;
        System.out.println("Transformed Text: " + transformedText.toString().trim());
        return cost;
    }
}