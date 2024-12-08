package les_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем массив (ArrayList) школьников
        ArrayList<Schoolboy> schoolboys = new ArrayList<>();
        schoolboys.add(new Schoolboy("Иванова", "женский", 15,null , null));
        schoolboys.add(new Schoolboy("Королёва", "женский", 17,null , null));
        schoolboys.add(new Schoolboy("Петров", "мужской", 16, null, null));

        //Создаем оценки
        Map<String,Integer> grades = new HashMap<>();
        grades.put("математика",5);
        grades.put("русский",5);
        grades.put("история",5);
        grades.put("английский",5);
        grades.put("обществознание",4);
        schoolboys.getFirst().addGrade(grades);

        grades = new HashMap<>();
        grades.put("математика",3);
        grades.put("русский",5);
        grades.put("история",5);
        grades.put("английский",4);
        schoolboys.get(1).addGrade(grades);

        grades = new HashMap<>();
        grades.put("математика",5);
        grades.put("русский",5);
        grades.put("история",5);
        grades.put("английский",5);
        grades.put("обществознание",3);
        schoolboys.get(2).addGrade(grades);
        //

        //Создаем олимпиады
        Map<String,Integer> olympiads = new HashMap<>();
        grades.put("городская",2);
        grades.put("школьная",1);
        schoolboys.get(0).addOlympiads(grades);

        olympiads = new HashMap<>();
        grades.put("областная",1);
        grades.put("городская",1);
        grades.put("школьная",1);
        schoolboys.get(1).addOlympiads(grades);

        olympiads = new HashMap<>();
        grades.put("городская",3);
        grades.put("школьная",1);
        schoolboys.get(2).addOlympiads(grades);
        //

        // Вывод информации о девочках, получивших первые места на олимпиадах
        System.out.println("Девочки, получившие первые места на олимпиадах:");
        for (Schoolboy schoolboy : schoolboys) {
            if (schoolboy.isFirstPlaceGirl()) {
                System.out.println(schoolboy);
            }
        }

        // Создаем массив (ArrayList) студентов
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Сидоров", "мужской", 20, null, null));
        students.add(new Student("Королёв", "мужской", 19, null, null));
        students.add(new Student("Кузнецова", "женский", 21, null, null));

        //Создаем оценки
        grades = new HashMap<>();
        grades.put("математика",5);
        grades.put("русский",5);
        grades.put("история",5);
        grades.put("английский",5);
        students.getFirst().addGrade(grades);

        grades = new HashMap<>();
        grades.put("математика",3);
        grades.put("русский",5);
        grades.put("история",3);
        grades.put("английский",4);
        students.get(1).addGrade(grades);
        //

        //Создаем курсовые
        ArrayList<Integer>  courseworkGrades = new ArrayList<>();
         courseworkGrades.add(5);
         courseworkGrades.add(5);
        students.getFirst().addCourseworkGrades( courseworkGrades);

         courseworkGrades = new ArrayList<>();
         courseworkGrades.add(5);
         courseworkGrades.add(3);
        students.get(1).addCourseworkGrades( courseworkGrades);

        // Вывод информации о студентах, у которых есть оценки за курсовые работы
        System.out.println("\nСтуденты с оценками за курсовые работы:");
        for (Student student : students) {
            if (student.countCourseworkGrades() > 0) {
                System.out.println(student);
            }
        }

        // Создаем общий список для формирования списка кандидатов на специальную стипендию

        ArrayList<Learner> scholarshipCandidates = new ArrayList<>(schoolboys);
        scholarshipCandidates.addAll(students);

        // Печатаем общий список кандидатов на специальную стипендию
        System.out.println("\nКандидаты на специальную стипендию:");
        for (Learner candidate : scholarshipCandidates) {
            if (candidate.isEligibleForScholarship())
                System.out.println(candidate);
        }
    }
}