package les_6;

import java.util.List;

// Производный класс 'Школьник'
class Schoolboy extends Learner {
    private String schoolNumber;

    public Schoolboy(String firstName, String lastName, List<Integer> grades, String schoolNumber) {
        super(firstName, lastName, grades);
        this.schoolNumber = schoolNumber;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }
}