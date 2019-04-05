package com.tw;

public class Student {
    private String name;
    private String id;
    private int math;
    private int chinese;
    private int english;
    private int program;

    public Student(String name, String id, int math, int chinese, int english, int program) {
        this.name = name;
        this.id = id;
        this.math = math;
        this.chinese = chinese;
        this.english = english;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getTotal() {
        return math + chinese + english + program;
    }

    public double getAverage() {
        return getTotal() / 4.0;
    }

    public String getGradeString() {
        return String.format("%s|%d|%d|%d|%d|%.2f|%d", name, math, chinese, english, program, getAverage(), getTotal());
    }
}
