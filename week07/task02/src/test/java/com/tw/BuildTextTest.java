package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BuildTextTest {
    private BuildText buildTextObj;

    @Before
    public void setUp() throws Exception {
        buildTextObj = new BuildText();
    }

    @Test
    public void should_return_menu_string() throws Exception {
        String result = buildTextObj.buildMenuText();
        String expectedResult = "1. 添加学生\n" +
                                "2. 生成成绩单\n" +
                                "3. 退出\n" +
                                "请输入你的选择（1～3）：";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_prompt_string_when_adding_a_student() throws Exception {
        String result = buildTextObj.buildPromptToAddStudent();
        String expectedResult = "请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_prompt_string_when_adding_a_student_incorrectly() throws Exception {
        String result = buildTextObj.buildPromptWhenAddStudentIncorrectly();
        String expectedResult = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_prompt_string_when_adding_a_student_with_the_same_id() throws Exception {
        Student s = new Student("张三", "001", 75, 95, 80, 80);
        String result = buildTextObj.buildPromptWhenAddStudentWithSameId(s);
        String expectedResult = "学号001已存在";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_prompt_string_when_adding_a_student_correctly() throws Exception {
        Student s = new Student("张三", "001", 75, 95, 80, 80);
        String result = buildTextObj.buildPromptWhenAddStudentCorrectly(s);
        String expectedResult = "学生张三的成绩被添加";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_prompt_string_when_printing_report_card() throws Exception {
        String result = buildTextObj.buildPromptToPrintCard();
        String expectedResult = "请输入要打印的学生的学号（格式： 学号, 学号, ...），按回车提交：";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_prompt_string_when_printing_report_card_with_incorrect_input_format() throws Exception {
        String result = buildTextObj.buildPromptWhenInputIdsIncorrectly();
        String expectedResult = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号, ...），按回车提交：";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_report_card_string() throws Exception {
        Student s1 = new Student("张三", "001", 75, 95, 80, 80);
        Student s2 = new Student("李四", "002", 85, 80, 70, 90);
        Klass klass = new Klass();

        klass.join(s1);
        klass.join(s2);
        String result = buildTextObj.buildReportCard(klass);
        String expectedResult = "成绩单\n" +
                                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                                "========================\n" +
                                "张三|75|95|80|80|82.50|330\n" +
                                "李四|85|80|70|90|81.25|325\n" +
                                "========================\n" +
                                "全班总分平均数：327.50\n" +
                                "全班总分中位数：327.50";;
        assertEquals(expectedResult, result);
    }
}