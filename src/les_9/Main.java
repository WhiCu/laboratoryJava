package les_9;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Пример использования каждой задачи

        // Task 1
        Task1 task1 = new Task1("HelloWorld");
        System.out.println(task1.removeCapitalLetters());

        // Task 2
        Task2 task2 = new Task2("olleH dlroW");
        System.out.println(task2.decryptMessage());

        // Task 3
        Task3 task3 = new Task3("one two cat dog");
        System.out.println(task3.countThreeLetterWords());

        // Task 4
        Task4 task4 = new Task4("Pas@sw0rd!");
        System.out.println(task4.validatePassword());

        // Task 5
        Task5 task5 = new Task5("The numbers 5, 61 and -12 are here.");
        System.out.println(task5.sumIntegers());

        // Task 6
        Task6 task6 = new Task6("Hello! How are you? Welcome to Java. WelcomHowe to Java.");
        List<String> result = task6.findSentences("How");
        for (String sentence : result) {
            System.out.println(sentence);
        }

        // Task 7
        Task7 task7 = new Task7("The cat, is good, to go,");
        int cost = task7.calculateTelegramCost();
        System.out.println("Cost: " + cost);
    }
}