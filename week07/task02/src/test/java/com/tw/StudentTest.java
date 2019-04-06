package com.tw;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private Student s = null;

    @Before
    public void setUp() throws Exception {
        s = new Student("张三", "001", 75, 95, 80, 80);
    }

    @Test
    public void should_return_its_name() throws Exception {
        String result = s.getName();
        String expectedResult = "张三";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_its_id() throws Exception {
        String result = s.getId();
        String expectedResult = "001";

        assertEquals(expectedResult, result);
    }

    @Test
    public void should_return_its_total_grade() throws Exception {
        int result = s.getTotal();
        int exceptedResult = 330;

        assertEquals(exceptedResult, result);
    }

    @Test
    public void should_return_its_average_grade() throws Exception {
        double result = s.getAverage();
        double exceptedResult = 82.5;
        double delta = 0.001;

        assertEquals(exceptedResult, result, delta);
    }

    @Test
    public void should_return_its_grade_string() throws Exception {
        String result = s.getGradeString();
        String exceptedResult = "张三|75|95|80|80|82.50|330";

        assertEquals(exceptedResult, result);
    }

    @Test
    public void should_return_true_when_two_student_object_have_same_literal_value() throws Exception {
        Student same = new Student("张三", "001", 75, 95, 80, 80);
        boolean result = s.equals(same);

        assertEquals(true, result);
    }

    @Test
    public void should_return_false_when_two_student_object_have_different_literal_value() throws Exception {
        Student same = new Student("张三", "002", 75, 95, 80, 80);
        boolean result = s.equals(same);

        assertEquals(false, result);
    }
}
