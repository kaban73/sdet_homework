package lection4;

import java.util.*;

public class Main {
    public static final Set<Student> students = new HashSet<>();
    private static void removeBadStudent(Set<Student> badStudents) {
        students.removeAll(badStudents);
    }
    private static void upCourseGoodStudent(Student student) {
        student.upCourse();
    }
    private static List<Student> printStudents(Set<Student> students, int course) {
        List<Student> listStudentsForCourse = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse() == course)
                listStudentsForCourse.add(student);
        }
        return listStudentsForCourse;
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
        Set<Student> badStudents = new HashSet<>();
        for (Student student : students) {
            if (student.getAverageResults() < 3)
                badStudents.add(student);
            else
                upCourseGoodStudent(student);
        }
        removeBadStudent(badStudents);

        List<Student> students1 = printStudents(students, 1);
        List<Student> students2 = printStudents(students, 2);
        List<Student> students3 = printStudents(students, 3);
        List<Student> students4 = printStudents(students, 4);
        List<Student> students5 = printStudents(students, 5);
        System.out.println(students1);
        System.out.println(students2);
        System.out.println(students3);
        System.out.println(students4);
        System.out.println(students5);
    }
}