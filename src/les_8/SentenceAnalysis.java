package les_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SentenceAnalysis {
    public static void main(String[] args) {
        String sentence = "They used 233 features including 227 stylometric features and six novel social network-specific features like character-based ones numbers of alphabets, uppercase characters, special characters, word-based ones the total number of words, average word length, the number of words with 1 char, syntactic ones numbers of punctuation marks and functional words, the total number of sentences and many others";

        // 1. Подсчитать количество слов, заканчивающихся на "es"
        long countWordsEndingWithEs = Arrays.stream(sentence.split("[ ,]+"))
                .filter(word -> word.endsWith("es"))
                .count();
        System.out.println("Количество слов, заканчивающихся на \"es\": " + countWordsEndingWithEs);

        // 2. Вывести слова, упорядоченные по возрастанию длины
        List<String> sortedWordsByLength = Arrays.stream(sentence.split("[ ,]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println("Слова, упорядоченные по возрастанию длины: " + sortedWordsByLength);

        // Дополнительно: подсчитать сумму целых чисел в предложении
        int sumOfIntegers = Arrays.stream(sentence.split("[ ,]+"))
                .filter(word -> word.matches("-?\\d+")) // проверка, является ли слово целым числом
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("Сумма целых чисел в предложении: " + sumOfIntegers);
    }
}