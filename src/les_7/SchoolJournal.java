package les_7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SchoolJournal {

    private Map<Integer, List<Student>> classMap = new HashMap<>();
    private Map<String, Map<Integer, List<Student>>> subjectMap = new HashMap<>();

    public void loadStudentsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 5) continue;

                String lastName = parts[0];
                String firstName = parts[1];
                int grade = Integer.parseInt(parts[2]);
                String subject = parts[3];
                int score = Integer.parseInt(parts[4]);

                Student student = new Student(lastName, firstName, grade, subject, score);
                classMap.computeIfAbsent(grade, k -> new ArrayList<>()).add(student);
                subjectMap.computeIfAbsent(subject, k -> new HashMap<>())
                        .computeIfAbsent(grade, k -> new ArrayList<>()).add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printStudentsByGrade(int grade) {
        List<Student> students = classMap.get(grade);
        if (students != null) {
            System.out.println("Учащиеся в классе " + grade + ":");
            for (Student student : students) {
                System.out.println(student.lastName + " " + student.firstName + " - " + student.score);
            }
        } else {
            System.out.println("Класс " + grade + " пуст.");
        }
    }

    public void sortClassesByAverageScore() {
        System.out.println("Классы отсортированы по средней успеваемости:");
        List<Map.Entry<Integer, Double>> averages = classMap.entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), getAverageScore(entry.getValue())))
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Double> entry : averages) {
            System.out.println("Класс " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public double getAverageScore(List<Student> students) {
        if (students.isEmpty()) return 0;
        return students.stream().mapToInt(s -> s.score).average().orElse(0);
    }

    public void printStudentsBySubject(String subject) {
        List<Student> allStudents = subjectMap.getOrDefault(subject, new HashMap<>())
                .values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        allStudents.sort(Comparator.comparing(s -> s.lastName));
        System.out.println("Учащиеся по предмету " + subject + ":");
        for (Student student : allStudents) {
            System.out.println(student.lastName + " " + student.firstName + " - " + student.score);
        }
    }

    public void printGradeReports(int grade) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("class_report_" + grade + ".txt"))) {
            List<Student> students = classMap.get(grade);
            if (students != null) {
                Map<String, List<Student>> subjectWise = students.stream()
                        .collect(Collectors.groupingBy(s -> s.subject));

                for (Map.Entry<String, List<Student>> entry : subjectWise.entrySet()) {
                    writer.write("Предмет: " + entry.getKey() + "\n");
                    for (Student student : entry.getValue()) {
                        writer.write(student.lastName + " " + student.firstName + " - " + student.score + "\n");
                    }
                    writer.write("\n");
                }
                System.out.println("Ведомость класса " + grade + " записана в файл class_report_" + grade + ".txt.");
            } else {
                System.out.println("Нет учеников в классе " + grade + ".");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findClassByName(String lastName, String firstName) {
        for (Map.Entry<Integer, List<Student>> entry : classMap.entrySet()) {
            for (Student student : entry.getValue()) {
                if (student.lastName.equals(lastName) && student.firstName.equals(firstName)) {
                    System.out.println(lastName + " " + firstName + " учится в классе " + entry.getKey());
                    return;
                }
            }
        }
        System.out.println(lastName + " " + firstName + " не найден.");
    }

    public void findSubjectWithHighestAverageScore() {
        Map<String, Double> averageScores = new HashMap<>();
        for (Map.Entry<String, Map<Integer, List<Student>>> entry : subjectMap.entrySet()) {
            List<Student> allStudents = entry.getValue().values().stream().flatMap(Collection::stream).collect(Collectors.toList());
            double avg = getAverageScore(allStudents);
            averageScores.put(entry.getKey(), avg);
        }

        String bestSubject = Collections.max(averageScores.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Предмет с самой высокой средней успеваемостью: " + bestSubject);
    }
}