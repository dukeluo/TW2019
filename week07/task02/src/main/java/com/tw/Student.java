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

    public boolean equals(Object x) {
        Student that;

        if (this == x) {
            return true;
        }
        if (x == null) {
            return false;
        }
        if (this.getClass() != x.getClass()) {
            return false;
        }
        that = (Student) x;
        if (!this.name.equals(that.name)) {
            return false;
        }
        if (!this.id.equals(that.id)) {
            return false;
        }
        if (this.math != that.math) {
            return false;
        }
        if (this.chinese != that.chinese) {
            return false;
        }
        if (this.english != that.english) {
            return false;
        }
        if (this.program != that.program) {
            return false;
        }
        return true;
    }
}
