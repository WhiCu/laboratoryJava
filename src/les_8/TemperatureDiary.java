package les_8;

import java.util.Arrays;

public class TemperatureDiary {
    public static void main(String[] args) {
        int[] temperatures = {-2, -5, -2, -4, 3, -6, -2,  -1, 5, 1, 1, 0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11};

        // 1. Количество дней с отрицательной температурой
        long negativeDays = Arrays.stream(temperatures)
                .filter(temp -> temp < 0)
                .count();
        System.out.println("Количество дней с отрицательной температурой: " + negativeDays);

        // 2. Были ли дни, когда температура оказалась выше 10 градусов
        boolean hasAboveTen = Arrays.stream(temperatures)
                .anyMatch(temp -> temp > 10);
        System.out.println("Были ли дни с температурой выше 10 градусов: " + (hasAboveTen ? "Да" : "Нет"));

        // 3. Максимальная температура в первую неделю марта (7 первых дней)
        int maxTemperatureFirstWeek = Arrays.stream(temperatures, 0, 7)
                .max().orElse(Integer.MIN_VALUE);
        System.out.println("Максимальная температура в первую неделю марта: " + maxTemperatureFirstWeek);

        // Дополнительно: средняя температура за месяц
        double averageTemperature = Arrays.stream(temperatures)
                .average().orElse(Double.NaN);
        System.out.println("Средняя температура за месяц: " + averageTemperature);
    }
}