package ind_2.Diamond;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DiamondHandler {
    public void sortDiamonds() {
        diamonds = diamonds.stream()
                .sorted(Comparator.comparing(Diamond::getCut).reversed()
                        .thenComparing(Diamond::getColor)
                        .thenComparing(Diamond::getClarity)
                        .thenComparing(Comparator.comparing(Diamond::getCarat).reversed()))
                .collect(Collectors.toList());
    }

    private List<Diamond> diamonds;

    public DiamondHandler(List<Diamond> diamonds) {
        this.diamonds = diamonds;
    }

    public List<Diamond> filterAndSortDiamonds(Double minLength, Double maxLength, Double minWidth, Double maxWidth, Double minDepth, Double maxDepth, List<String> sortOrder) {
        List<Diamond> filteredDiamonds = diamonds.stream()
                .filter(d -> d.length >= minLength && d.length <= maxLength)
                .filter(d -> d.width >= minWidth && d.width <= maxWidth)
                .filter(d -> d.depth >= minDepth && d.depth <= maxDepth)
                .toList();


        Comparator<Diamond> comparator = createComparator(sortOrder);
        List<Diamond> sortedDiamonds = filteredDiamonds.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        for(Diamond diamond : sortedDiamonds){
            System.out.println(diamond);
        }
        logRequest(minLength, maxLength, minWidth, maxWidth, minDepth, maxDepth, sortOrder, sortedDiamonds);

        return sortedDiamonds;
    }

    private Comparator<Diamond> createComparator(List<String> sortOrder) {
        Comparator<Diamond> comparator = null; // начальный компаратор
        for (String sortParam : sortOrder) {
            if (comparator == null) {
                comparator = switch (sortParam.toLowerCase()) {
                    case "cut" -> Comparator.comparing(Diamond::getCut).reversed();
                    case "color" -> Comparator.comparing(Diamond::getColor);
                    case "clarity" -> Comparator.comparing(Diamond::getClarity);
                    case "carat" -> Comparator.comparing(Diamond::getCarat).reversed();
                    default -> comparator;
                };
                break;
            }
            comparator = switch (sortParam.toLowerCase()) {
                case "cut" -> comparator.thenComparing(Comparator.comparing(Diamond::getCut).reversed());
                case "color" -> comparator.thenComparing(Comparator.comparing(Diamond::getColor));
                case "clarity" -> comparator.thenComparing(Comparator.comparing(Diamond::getClarity));
                case "carat" -> comparator.thenComparing(Comparator.comparing(Diamond::getCarat).reversed());
                default -> comparator;
            };
        }

        return comparator;
    }

    public void wtof(){
        try (FileWriter writer = new FileWriter("diamonds.txt", false)) {
            for(Diamond diamond : diamonds){
                writer.write(diamond.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private void logRequest(Double minLength, Double maxLength, Double minWidth, Double maxWidth, Double minDepth, Double maxDepth, List<String> sortOrder, List<Diamond> sortedDiamonds) {
        try (FileWriter writer = new FileWriter("diamond_requests_log.txt", false)) {
            writer.write("Запрос от " + LocalDateTime.now() + "\n");
            writer.write("Диапазон длины: " + minLength + " - " + maxLength + "\n");
            writer.write("Диапазон ширины: " + minWidth + " - " + maxWidth + "\n");
            writer.write("Диапазон глубины: " + minDepth + " - " + maxDepth + "\n");
            writer.write("Порядок сортировки: " + String.join(", ", sortOrder) + "\n");
            writer.write("Индексы отобранных бриллиантов: " + sortedDiamonds.stream()
                    .map(d -> d.index.toString())
                    .collect(Collectors.joining(", ")) + "\n");
            writer.write("---------------------------------------------------------\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}