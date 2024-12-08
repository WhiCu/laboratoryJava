package les_9;

import java.util.regex.*;

public class Task5 {
    private String input;

    public Task5(String input) {
        this.input = input;
    }

    public int sumIntegers() {
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return sum;
    }
}