package les_4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Reader A = new Reader("Петров", new Book("Java 8. Полное руководство", "Г. Шилдт", LocalDate.of(2024, 4, 1)));
        Reader B = new Reader("Васечкин", new Book("Крейцерова соната", "Л. Толстой", LocalDate.of(2024, 3, 25)));
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), 3, 29);
        if(A.isBookReturnedOnTime(date)){
            System.out.println("A - сдал вовремя");
        } else {
            System.out.println("A - сдал не вовремя");
        }
        if(B.isBookReturnedOnTime(date)){
            System.out.println("B - сдал вовремя");
        } else {
            System.out.println("B - сдал не вовремя");
        }
    }
}
