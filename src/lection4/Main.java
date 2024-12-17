package lection4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final Set<Student> students = new HashSet<>();
    private static void removeBadStudent() {
        Set<Student> badStudents = students.stream()
                .filter(student -> (student.getAverageResults() < 3))
                .collect(Collectors.toSet());
        students.removeAll(badStudents);
    }
    private static void upCourseGoodStudent() {
        students.stream()
                .filter(student -> (student.getAverageResults() >= 3))
                .forEach(student -> {
                    student.upCourse();
                });
    }
    private static void printStudents(int course) {
        System.out.println(
                students.stream()
                        .filter(student -> student.getCourse() == course)
                        .map(student -> student.getName() + " - " + student.getAverageResults())
                        .toList()
        );
    }
    public static void main(String[] args) {
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
        printStudents(1);
        printStudents(2);
        printStudents(3);
        printStudents(4);
        printStudents(5);
        System.out.println("---------------------------------------");
        removeBadStudent();
        upCourseGoodStudent();
        printStudents(1);
        printStudents(2);
        printStudents(3);
        printStudents(4);
        printStudents(5);
    }
}
