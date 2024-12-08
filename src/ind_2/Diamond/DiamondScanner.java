package ind_2.Diamond;

import ind_2.Diamond.Quality.Clarity;
import ind_2.Diamond.Quality.Color;
import ind_2.Diamond.Quality.Cut;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class DiamondScanner {
    public static List<Diamond> from(Scanner scanner) {
        List<Diamond> diamonds = new ArrayList<>();
        byte count = 0;

        while (scanner.hasNextLine()) {
            try {
                count = 0;
                Long index = Long.parseLong(scanner.nextLine().trim());
                count++;
                Double carat = Double.parseDouble(scanner.nextLine().trim());
                count++;
                Cut cut = Cut.Stoc(scanner.nextLine().trim());
                count++;
                Color color = Color.Stoc(scanner.nextLine().trim());
                count++;
                Clarity clarity = Clarity.Stoc(scanner.nextLine().trim());
                count++;
                Double depth = Double.parseDouble(scanner.nextLine().trim());
                count++;
                Double percentageOfWidth = Double.parseDouble(scanner.nextLine().trim());
                count++;
                Double cost = Double.parseDouble(scanner.nextLine().trim());
                count++;
                Double length = Double.parseDouble(scanner.nextLine().trim());
                count++;
                Double width = Double.parseDouble(scanner.nextLine().trim());

                diamonds.add(new Diamond(index, carat, cut, color, clarity, depth, percentageOfWidth, cost, length, width));
            } catch (NumberFormatException e) {
                System.err.println("Ошибка при преобразовании числа: " + e.getMessage());
                for (int i = count; i < 9 && scanner.hasNextLine(); i++) {
                    scanner.nextLine();
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Некорректные данные, пропуск: " + e.getMessage());
                for (int i = count; i < 9 && scanner.hasNextLine(); i++) {
                    scanner.nextLine();
                }
            }
        }

        return diamonds;
    }

    public static List<Diamond> from(String path) {

        try {
            Scanner scanner = new Scanner(new FileReader(path));
            return from(scanner);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
