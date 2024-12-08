package les_4;

import java.time.LocalDate;

public class Book {
    private String title;          // Название книги
    private String author;         // Автор книги
    private LocalDate returnDate;  // День сдачи книги

    // Конструктор
    public Book(String title, String author, LocalDate returnDate) {
        this.title = title;
        this.author = author;
        this.returnDate = returnDate;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }


    // Сеттеры
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Книга{" +
                "название='" + title + '\'' +
                ", автор='" + author + '\'' +
                ", день сдачи книги=" + returnDate +
                ", месяц сдачи книги=" + returnDate.getMonthValue() +
                '}';
    }
}
