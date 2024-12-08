package les_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Schoolboy extends Learner {
    private Map<String, Integer> olympiads; // Участие в олимпиадах: [областная, городская, школьная]

    public Schoolboy(String name, String gender, int age, Map<String, Integer> grades, Map<String, Integer> olympiads) {
        super(name, gender, age);
        this.grades = Objects.requireNonNullElseGet(grades, HashMap::new);
        this.olympiads = Objects.requireNonNullElseGet(olympiads, HashMap::new);
    }
    public void addOlympiads(Map<String, Integer> olympiads){
        this.olympiads = olympiads;
    }

    public boolean isEligibleForScholarship() {
        if(!grades.containsKey("математика")) {
            System.out.println("Не учил математику");
            return false;
        }
        if(!grades.containsKey("русский")) {
            System.out.println("Не учил русский");
            return false;
        }
        if(!grades.containsKey("история")) {
            System.out.println("Не учил историю");
            return false;
        }
        if(!grades.containsKey("английский")) {
            System.out.println("Не учил английский");
            return false;
        }
        if(!olympiads.containsKey("школьная")){
            System.out.println("Не участвовал в олимпиаде");
            return false;
        }
        // Условия для специальной стипендии
        // математика, русский, история, английский
        return grades.values().stream().allMatch(x -> x >= 4) && (olympiads.get("школьная") == 1 || olympiads.get("городская") >= 3);
    }

    public boolean isFirstPlaceGirl() {
        return gender.equals("женский") && olympiads.values().stream().anyMatch(x -> x==1); // Первое место в школьной олимпиаде
    }

    @Override
    public String toString() {
        return "Schoolboy: " + name + ", Gender: " + gender + ", Age: " + age;
    }
}