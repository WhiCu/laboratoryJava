package les_6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Основной класс для выполнения задач  
public class Main {
    public static void main(String[] args) {
        List<Learner> studentsAndSchoolboys = new ArrayList<>();

        // Пример добавления Studentов и Schoolboyов  
        studentsAndSchoolboys.add(new Schoolboy("Иван", "Иванов", List.of(3, 4, 5), "123"));
        studentsAndSchoolboys.add(new Student("Петр", "Петров", List.of(5, 4, 4), "МГУ"));
        studentsAndSchoolboys.add(new Schoolboy("Анна", "Сидорова", List.of(4, 2, 5), "456"));
        studentsAndSchoolboys.add(new Student("Мария", "Павлова", List.of(5, 5, 5), "СПбГУ"));

        // Сортировка по фамилиям  
        studentsAndSchoolboys.sort(Comparator.comparing(Learner::getLastName));

        // Вывод общего списка  
        System.out.println("Общий список стипендиатов:");
        for (Learner u : studentsAndSchoolboys) {
            System.out.println(u.getLastName() + " с успеваемостью: " + u.getAverageGrade());
        }

        System.out.println();
        // Сортировка Schoolboyов по рейтингу успеваемости и номеру школы  
        List<Schoolboy> schoolboys = new ArrayList<>();
        for (Learner u : studentsAndSchoolboys) {
            if (u instanceof Schoolboy) {
                schoolboys.add((Schoolboy) u);
            }
        }

        schoolboys.sort(Comparator.comparing(Schoolboy::getAverageGrade)
                .thenComparing(Schoolboy::getSchoolNumber).reversed());


        System.out.println("Список Schoolboyов по успеваемости и номеру школы:");
        for (Schoolboy sb : schoolboys) {
            System.out.println(sb.getLastName() + " номер школы " + sb.getSchoolNumber() + " успеваемость: " + sb.getAverageGrade());
        }

        System.out.println();
        // Сортировка Studentов по рейтингу успеваемости  
        List<Student> students = new ArrayList<>();
        for (Learner u : studentsAndSchoolboys) {
            if (u instanceof Student) {
                students.add((Student) u);
            }
        }

        students.sort(Comparator.comparing(Student::getAverageGrade).reversed());

        System.out.println("Список Studentов по успеваемости:");
        for (Student st : students) {
            System.out.println(st.getLastName() + " название университета " + st.getUniversityName() + " успеваемость: " + st.getAverageGrade());
        }

        System.out.println();
        // Находим лучшего Studentа и Schoolboyа
        Learner bestLearner = Collections.max(studentsAndSchoolboys, Comparator.comparing(Learner::getAverageGrade));
        Student bestStudent = Collections.max(students, Comparator.comparing(Learner::getAverageGrade));
        Schoolboy bestSchoolboy= Collections.max(schoolboys, Comparator.comparing(Learner::getAverageGrade));

        System.out.println("Лучший учащийся: " + bestLearner.getLastName() + " с успеваемостью: " + bestLearner.getAverageGrade());
        System.out.println("Лучший школьник: " + bestSchoolboy.getLastName() + " с успеваемостью: " + bestSchoolboy.getAverageGrade());
        System.out.println("Лучший студент: " + bestStudent.getLastName() + " с успеваемостью: " + bestStudent.getAverageGrade());
    }
}  
