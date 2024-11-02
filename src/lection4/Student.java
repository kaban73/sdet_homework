package lection4;

import java.util.Map;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> results;
    public Student(
            String name,
            String group,
            int course,
            Map<String, Integer> results
    ) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.results = results;
    }
    public int getAverageResults() {
        int general = 0;
        for (int res : this.results.values()) {
            general += res;
        }
        return general / this.results.size();
    }
    public void upCourse() {
        this.course += 1;
    }
    public int getCourse() {
        return this.course;
    }
}
