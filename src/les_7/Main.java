package les_7;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filename = "data_school.txt";

        // Создать экземпляр SchoolJournal
        SchoolJournal schoolJournal = new SchoolJournal();

        // Загружать студентов из файла
        schoolJournal.loadStudentsFromFile(filename);

        // 1. Выводить список учеников с заданной оценкой
        int gradeToShow = 5;
        System.out.println("Учащиеся в классе " + gradeToShow + ":");
        schoolJournal.printStudentsByGrade(gradeToShow);

        // 2. Сортировать классы по средней успеваемости
        schoolJournal.sortClassesByAverageScore();

        // 3. Для заданного предмета выводит список из учеников всех классов, отсортированный по фамилии
        String subjectToShow = "Математика";
        System.out.println("Учащиеся по предмету " + subjectToShow + ":");
        schoolJournal.printStudentsBySubject(subjectToShow);

        // 4. Вывод ведомости заданного класса по каждому предмету
        int reportGrade = 6;
        schoolJournal.printGradeReports(reportGrade);

        // 5. По имени и фамилии определяет класс, в котором учится ученик
        String lastNameToFind = "Иванов";
        String firstNameToFind = "Иван";
        schoolJournal.findClassByName(lastNameToFind, firstNameToFind);

        // 6. Определяет предмет с самой высокой средней успеваемостью
        schoolJournal.findSubjectWithHighestAverageScore();
    }
}