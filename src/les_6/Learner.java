package les_6;

import java.util.List;

// Интерфейсы для сравнения
interface ComparableByPerformance {
    double getAverageGrade();
}

interface ComparableByName {
    String getLastName();
}

// Базовый класс 'Учащийся'
abstract class Learner implements ComparableByPerformance, ComparableByName {
    protected String firstName;
    protected String lastName;
    protected List<Integer> grades;

    public Learner(String firstName, String lastName, List<Integer> grades) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrades(grades);
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || !Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Имя должно начинаться с большой буквы.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой.");
        }
        this.lastName = lastName;
    }

    public void setGrades(List<Integer> grades) {
        for (Integer grade : grades) {
            if (grade < 2 || grade > 5) {
                throw new IllegalArgumentException("Оценки должны быть в диапазоне от 2 до 5.");
            }
        }
        this.grades = grades;
    }

    @Override
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String getLastName() {
        return lastName;
    }
}
