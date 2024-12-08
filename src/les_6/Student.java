package les_6;

import java.util.List;

class Student extends Learner {
    private String universityName;

    public Student(String firstName, String lastName, List<Integer> grades, String universityName) {
        super(firstName, lastName, grades);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }
}