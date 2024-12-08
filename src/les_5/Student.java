package les_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Student extends Learner {
    private ArrayList<Integer> courseworkGrades; // Оценки за курсовые работы

    public Student(String name, String gender, int age, Map<String, Integer> grades, ArrayList<Integer> courseworkGrades) {
        super(name, gender, age);
        this.grades = Objects.requireNonNullElseGet(grades, HashMap::new);
        this.courseworkGrades = Objects.requireNonNullElseGet(courseworkGrades, ArrayList::new);

    }

    public void addCourseworkGrades(ArrayList<Integer> courseworkGrades) {
        this.courseworkGrades = courseworkGrades;
    }
    public Integer[] getCourseworkGrades() {
        return (Integer[]) courseworkGrades.toArray();
    }
    public int countCourseworkGrades(){
        return courseworkGrades.size();
    }


    public boolean isEligibleForScholarship() {
        // Условия для специальной стипендии
        if (averageGrade() >= 4.75 && hasAllCourseworkGradesFive()) {
            return true;
        }
        return false;
    }

    public int averageGrade() {
        if (grades.isEmpty())
            return 0;
        int average = 0;
        for (var value : grades.values()) {
            average += value;
        }
        return average / grades.size();
    }

    private boolean hasAllCourseworkGradesFive() {
        if(courseworkGrades.isEmpty())
            return false;
        for (int grade : courseworkGrades) {
            if (grade != 5) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Gender: " + gender + ", Age: " + age;
    }
}