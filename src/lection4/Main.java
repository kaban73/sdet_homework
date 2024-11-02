package lection4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static void removeBadStudent(Set<Student> students) {
        students.removeIf(student -> student.getAverageResults() < 3);
    }
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            String name = "Student " + (i + 1);
            String group = "Group " + (i % 3 + 1); // Группы 1, 2, 3
            int course = (i % 4) + 1; // Курсы от 1 до 4

            Map<String, Integer> results = new HashMap<>();
            results.put("Math", (int)(Math.random() * 5) + 1); // Случайная оценка от 1 до 100
            results.put("Physics", (int)(Math.random() * 5) + 1);
            results.put("Chemistry", (int)(Math.random() * 5) + 1);

            students.add(new Student(name, group, course, results));
        }
        removeBadStudent(students);
    }
}