package com.tw;

import java.util.List;
import java.util.stream.Stream;

public class BuildText {
    private final String promptToAddStudent = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：";
    private final String promptWhenAddStudentIncorrectly = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：";
    private final String promptTemplateWhenAddStudentWithSameId = "学号%s已存在";
    private final String promptTemplateWhenAddStudentCorrectly = "学生%s的成绩被添加";
    private final String promptToPrintCard = "请输入要打印的学生的学号（格式： 学号, 学号, ...），按回车提交：";
    private final String promptWhenInputIdsIncorrectly = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号, ...），按回车提交：";
    private final String menu = "1. 添加学生\n" +
                                "2. 生成成绩单\n" +
                                "3. 退出\n" +
                                "请输入你的选择（1～3）：";
    private final String reportCardTemplate = "成绩单\n" +
                                              "姓名|数学|语文|英语|编程|平均分|总分\n" +
                                              "========================\n" +
                                              "%s\n" +
                                              "========================\n" +
                                              "全班总分平均数：%.2f\n" +
                                              "全班总分中位数：%.2f";

    public String buildMenuText() {
        return menu;
    }

    public String buildPromptToAddStudent() {
        return promptToAddStudent;
    }

    public String buildPromptWhenAddStudentIncorrectly() {
        return promptWhenAddStudentIncorrectly;
    }

    public String buildPromptWhenAddStudentWithSameId(Student s) {
        return String.format(promptTemplateWhenAddStudentWithSameId, s.getId());
    }

    public String buildPromptWhenAddStudentCorrectly(Student s) {
        return String.format(promptTemplateWhenAddStudentCorrectly, s.getName());
    }

    public String buildPromptToPrintCard() {
        return promptToPrintCard;
    }

    public String buildPromptWhenInputIdsIncorrectly() {
        return promptWhenInputIdsIncorrectly;
    }

    public String buildReportCard(List<Student> students) {
        Klass klass = new Klass(students);
        return buildReportCard(klass);
    }

    public String buildReportCard(Klass k) {
        List<Student> students = k.getStudents();
        String[] gradeStrings = students.stream()
                                        .map(s -> s.getGradeString())
                                        .toArray(String[]::new);

        return String.format(reportCardTemplate, String.join("\n", gradeStrings), k.getKlassAverage(), k.getKlassMedian());
    }
}
