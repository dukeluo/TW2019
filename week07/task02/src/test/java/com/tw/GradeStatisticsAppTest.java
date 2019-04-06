package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GradeStatisticsAppTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GradeStatisticsApp app;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        app = new GradeStatisticsApp(true);
    }

    @Test
    public void should_return_true_when_app_is_on() throws Exception {
        boolean result = app.isOn();
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_false_when_app_is_off() throws Exception {
        boolean result;
        boolean expectedResult = false;

        app.exitHandler();
        result = app.isOn();
        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_a_line_from_input() throws Exception {
        GradeStatisticsApp mockedApp = mock(GradeStatisticsApp.class);

        when(mockedApp.getLine()).thenReturn("1\n");

        assertEquals("1\n", mockedApp.getLine());
    }

    @Test
    public void should_print_menu_text() throws Exception {
        String expectedResult = "1. 添加学生\n" +
                                "2. 生成成绩单\n" +
                                "3. 退出\n" +
                                "请输入你的选择（1～3）：\n";

        app.printMenu();
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void should_return_true_when_add_student_correctly() throws Exception {
        Student s = new Student("张三", "001", 75, 95, 80, 80);
        boolean result = app.addStudentToKlass(s);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_false_when_add_student_with_same_id() throws Exception {
        Student s = new Student("张三", "001", 75, 95, 80, 80);

        assertEquals(true, app.addStudentToKlass(s));
        assertEquals(false, app.addStudentToKlass(s));
    }

    @Test
    public void should_return_null_when_input_format_of_adding_student_is_incorrect() throws Exception {
        String input = "张三; 001; 数学: 100; 语文: 100; 英语: 100; 编程: 100";

        assertEquals(null, app.parseStudent(input));
    }

    @Test
    public void should_return_student_obj_when_input_format_of_adding_student_is_correct() throws Exception {
        String input = "张三, 001, 数学: 100, 语文: 100, 英语: 100, 编程: 100";
        Student expectedResult = new Student("张三", "001", 100, 100, 100, 100);

        assertEquals(expectedResult, app.parseStudent(input));
    }

    @Test
    public void should_return_null_when_input_format_of_printing_report_card_is_incorrect() throws Exception {
        Student s1 = new Student("张三", "001", 75, 95, 80, 80);
        Student s2 = new Student("李四", "002", 85, 80, 70, 90);
        String input = "001; 002";

        assertEquals(true, app.addStudentToKlass(s1));
        assertEquals(true, app.addStudentToKlass(s2));
        assertEquals(null, app.parseIds(input));
    }

    @Test
    public void should_return_a_id_list_when_input_format_of_printing_report_card_is_correct() throws Exception {
        Student s1 = new Student("张三", "001", 75, 95, 80, 80);
        Student s2 = new Student("李四", "002", 85, 80, 70, 90);
        String input = "001, 002";
        List<String> expectedResult= new LinkedList<String>();

        expectedResult.add("001");
        expectedResult.add("002");
        assertEquals(true, app.addStudentToKlass(s1));
        assertEquals(true, app.addStudentToKlass(s2));
        assertEquals(expectedResult, app.parseIds(input));
    }

    @Test
    public void should_return_a_selected_student_list() throws Exception {
        Student s1 = new Student("张三", "001", 75, 95, 80, 80);
        Student s2 = new Student("李四", "002", 85, 80, 70, 90);
        List<String> ids = new LinkedList<String>();
        List<Student> expectedResult= new LinkedList<Student>();

        expectedResult.add(s1);
        expectedResult.add(s2);
        ids.add("001");
        ids.add("002");
        ids.add("003");
        assertEquals(true, app.addStudentToKlass(s1));
        assertEquals(true, app.addStudentToKlass(s2));
        assertEquals(expectedResult, app.getSelectedStudents(expectedResult, ids));
    }
}