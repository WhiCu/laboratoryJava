package les_5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

abstract class Learner {
    protected String name;
    protected String gender;
    protected int age;
    //protected Map<String, ArrayList<Integer>> grades;
    protected Map<String, Integer> grades;

    public Learner(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void addGrade(Map<String, Integer> grades) {
        this.grades = grades;
    }
    public void addGrade(String subject, int grade) {
        grades.put(subject.toLowerCase(),grade);
    }

    public int getGrade(String subject) {
        if(!grades.containsKey(subject.toLowerCase()))
            return 0;
        return grades.get(subject.toLowerCase());
    }

    public abstract boolean isEligibleForScholarship();
    public String getName() {
        return name;
    }
}