package com.tw;

import java.util.List;
import java.util.LinkedList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GradeStatisticsApp {
    private final String addStudentInputPattern = "([\\u4E00-\\u9FA5]+),\\s*(\\d{3}),\\s*([\\u4E00-\\u9FA5]{2}\\:\\s*(\\d{1,3}),?\\s*){4}";
    private final String gradePairPattern = "([\\u4E00-\\u9FA5]{2})\\:\\s*(\\d{1,3}),?\\s*";
    private final String idsInputPattern = "((\\d{3}),?\\s*)+";
    private final String singleIdPattern = "(\\d{3}),?\\s*";

    private Pattern addStudentInputMatcher = Pattern.compile(addStudentInputPattern);
    private Pattern gradePairMatcher = Pattern.compile(gradePairPattern);
    private Pattern inputIdsMatcher = Pattern.compile(idsInputPattern);
    private Pattern singleIdMatcher = Pattern.compile(singleIdPattern);
    private Scanner scan = new Scanner(System.in);
    private BuildText buildText = new BuildText();
    private Klass klass = new Klass();
    private boolean on;

    GradeStatisticsApp(boolean on) {
        this.on = on;
    }

    private void println(String s) {
        System.out.println(s);
    }

    private void printBlankLine() {
        System.out.println();
    }

    private int parseInt(String s) {
        return Integer.parseInt(s);
    }

    boolean isOn() {
        return on;
    }

    String getLine() {
        return on && scan.hasNextLine() ? scan.nextLine() : "";
    }

    void printMenu() {
        println(buildText.buildMenuText());
    }

    boolean addStudentToKlass(Student s) {
        if (klass.has(s)) {
            return false;
        }
        klass.join(s);
        return true;
    }

    Student parseStudent(String s) {
        String name = null;
        String id = null;
        int math = 0;
        int chinese = 0;
        int english = 0;
        int program = 0;
        Matcher m = null;

        m = addStudentInputMatcher.matcher(s);
        if (!m.matches()) {
            return null;
        }
        name = m.group(1);
        id = m.group(2);
        m = gradePairMatcher.matcher(s);
        while (m.find()) {
            switch (m.group(1)) {
                case "数学":
                    math = parseInt(m.group(2));
                    break;

                case "语文":
                    chinese = parseInt(m.group(2));
                    break;

                case "英语":
                    english = parseInt(m.group(2));
                    break;

                case "编程":
                    program = parseInt(m.group(2));
                    break;
            }
        }
        return new Student(name, id, math, chinese, english, program);
    }

    void addStudentHandler() {
        boolean flag = true;
        boolean isAdded;
        String line;
        Student s;

        println(buildText.buildPromptToAddStudent());
        while (flag) {
            line = getLine();
            s = parseStudent(line);
            if (s == null) {
                println(buildText.buildPromptWhenAddStudentIncorrectly());
                continue;
            }

            isAdded = addStudentToKlass(s);
            if (isAdded) {
                println(buildText.buildPromptWhenAddStudentCorrectly(s));
            } else {
                println(buildText.buildPromptWhenAddStudentWithSameId(s));
            }
            flag = false;
        }
    }

    List<String> parseIds(String s) {
        Matcher m = null;
        List<String> ids = new LinkedList<String>();

        m = inputIdsMatcher.matcher(s);
        if (!m.matches()) {
            return null;
        }
        m = singleIdMatcher.matcher(s);
        while (m.find()) {
            ids.add(m.group(1));
        }
        return ids;
    }

    List<Student> getSelectedStudents(List<Student> students, List<String> ids) {
        return students.stream()
                       .filter(s -> ids.contains(s.getId()))
                       .collect(Collectors.toList());
    }

    void printCardHandler() {
        boolean flag = true;
        List<String> ids = null;
        List<Student> selectedStudents = null;
        String line;

        println(buildText.buildPromptToPrintCard());
        while (flag) {
            line = getLine();
            ids = parseIds(line);
            if (ids == null) {
                println(buildText.buildPromptWhenInputIdsIncorrectly());
            } else {
                selectedStudents = getSelectedStudents(klass.getStudents(), ids);
                if (selectedStudents.size() == 0) {
                    println(buildText.buildPromptWhenInputIdsIncorrectly());
                } else {
                    println(buildText.buildReportCard(selectedStudents));
                    flag = false;
                }
            }
        }
    }

    void exitHandler() {
        scan.close();
        on = false;
    }

    public static void main(String[] args) {
        GradeStatisticsApp app = new GradeStatisticsApp(true);
        String option;

        while (app.isOn()) {
            app.printMenu();
            option = app.getLine();
            switch (option) {
                case "1":
                    app.addStudentHandler();
                    app.printBlankLine();
                    break;

                case "2":
                    app.printCardHandler();
                    app.printBlankLine();
                    break;

                case "3":
                    app.exitHandler();
                    break;
            }
        }
    }
}
