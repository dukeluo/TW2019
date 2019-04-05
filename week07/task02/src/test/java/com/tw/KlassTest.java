package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class KlassTest {
    private Student s1 = null;
    private Student s2 = null;
    private Klass klass = null;
    private List<Student> studentList = null;

    @Before
    public void setUp() throws Exception {
        s1 = new Student("张三", "001", 75, 95, 80, 80);
        s2 = new Student("李四", "002", 85, 80, 70, 90);
        studentList = new LinkedList<Student>();

        studentList.add(s1);
        studentList.add(s2);
        klass = new Klass(studentList);
    }

    @Test
    public void should_join_a_student_successfully() throws Exception {
        Klass mockedKlass = mock(Klass.class);

        mockedKlass.join(s1);
        verify(mockedKlass).join(s1);
    }

    @Test
    public void should_return_true_when_klass_has_the_student() throws Exception {
        boolean result = true;
        boolean expectedResult = klass.has(s1);

        assertEquals(result, expectedResult);
    }

    @Test
    public void should_return_false_when_klass_doesnt_have_the_student() throws Exception {
        Student s = new Student("王五", "007", 66, 66, 66, 66);
        boolean result = false;
        boolean expectedResult = klass.has(s);

        assertEquals(result, expectedResult);
    }

    @Test
    public void should_return_a_list_of_students() throws Exception {
        List<Student> result = studentList;
        List<Student> expectedResult = klass.getStudents();

        assertEquals(result, expectedResult);
    }

    @Test
    public void should_return_the_average_total_grade_of_a_klass() throws Exception {
        double result = klass.getKlassAverage();
        double expectedResult = 327.5;
        double delta = 0.001;

        assertEquals(result, expectedResult, delta);
    }

    @Test
    public void should_return_the_median_total_grade_of_a_klass() throws Exception {
        double result = klass.getKlassMedian();
        double expectedResult = 327.5;
        double delta = 0.001;

        assertEquals(result, expectedResult, delta);
    }
}
