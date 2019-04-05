package com.tw;

import java.util.List;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Klass {
    private List<Student> students = new LinkedList<Student>();
    private List<String> ids = new LinkedList<String>();

    public Klass() {
    }

    public Klass(List<Student> students) {
        this.students = students;
        ids = students.stream()
                      .map(s -> s.getId())
                      .collect(Collectors.toList());
    }

    public void join(Student s) {
        students.add(s);
        ids.add(s.getId());
    }

    public boolean has(Student s) {
        return ids.contains(s.getId());
    }

    public List<Student> getStudents() {
        return students;
    }

    public double getKlassAverage() {
        return students.stream()
                       .map(s -> s.getTotal())
                       .mapToInt(Integer::intValue)
                       .summaryStatistics()
                       .getAverage();
    }

    public double getKlassMedian() {
        int[] totals = students.stream()
                               .map(s -> s.getTotal())
                               .mapToInt(Integer::intValue)
                               .sorted()
                               .toArray();
        int length = totals.length;

        if (length % 2 == 0) {
            return (totals[length/2] + totals[length/2-1]) / 2.0;
        } else {
            return totals[length/2] + 0.0;
        }
    }
}
