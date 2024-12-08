package les_4;

import java.time.LocalDate;

public class Reader {
    private String name;    // Имя читателя
    private Book book;      // Книга, которую взял читатель

    // Конструктор
    public Reader(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Book getBook() {
        return book;
    }

    // Метод для проверки, вовремя ли сдана книга
    public boolean isBookReturnedOnTime() {
        LocalDate currentDate = LocalDate.now(); // Текущая дата
        return !currentDate.isAfter(book.getReturnDate()); // Если текущая дата не позже даты сдачи
    }
    public boolean isBookReturnedOnTime(LocalDate currentDate) {
        return !currentDate.isAfter(book.getReturnDate()); // Если текущая дата не позже даты сдачи
    }

    @Override
    public String toString() {
        return "Читатель{" +
                "имя='" + name + '\'' +
                ", книга=" + book +
                '}';
    }
}
