package practice10;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.fest.assertions.api.Assertions.assertThat;

public class Practice10Test {
    private Klass klass2;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        klass2 = new Klass(2);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_person_have_id_name_and_age() throws Exception {
        Person person = new Person(1, "Tom", 21);
        assertThat(person.getName()).isEqualTo("Tom");
        assertThat(person.getAge()).isEqualTo(21);
    }

    @Test
    public void should_person_with_same_id_be_same_one() throws Exception {
        Person person1 = new Person(1, "Tom", 21);
        Person person2 = new Person(1, "Tom", 21);
        assertThat(person1).isEqualTo(person2);
    }

    @Test
    public void should_person_have_an_introduce_method_which_introduce_person_with_name_and_age() throws Exception {
        Person tom = new Person(1, "Tom", 21);
        String introduce = tom.introduce();
        assertThat(introduce).isEqualTo("My name is Tom. I am 21 years old.");
    }

    @Test
    public void should_class_have_a_number() throws Exception {
        assertThat(klass2.getNumber()).isEqualTo(2);
    }

    @Test
    public void should_class_get_display_name() throws Exception {
        assertThat(klass2.getDisplayName()).isEqualTo("Class 2");
    }

    @Test
    public void should_class_not_assign_a_student_as_leader_when_student_is_not_a_member() throws Exception {
        Student jerry = new Student(1, "Jerry", 8, new Klass(5));

        klass2.assignLeader(jerry);

        assertThat(systemOut()).isEqualTo("It is not one of us.\n");
        assertThat(klass2.getLeader()).isNotEqualTo(jerry);
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_class_assign_a_member_student_as_leader() throws Exception {
        Student jerry = new Student(1, "Jerry", 8, klass2);
        klass2.appendMember(jerry);
        klass2.assignLeader(jerry);
        assertThat(klass2.getLeader()).isEqualTo(jerry);
    }

    @Test
    public void should_student_have_name_age_and_class_number() throws Exception {
        Student tom = new Student(1, "Tom", 21, klass2);
        assertThat(tom.getName()).isEqualTo("Tom");
        assertThat(tom.getAge()).isEqualTo(21);
        assertThat(tom.getKlass()).isEqualTo(klass2);
    }

    @Test
    public void should_student_introduce_with_class() throws Exception {
        Student tom = new Student(1, "Tom", 21, klass2);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");
    }

    @Test
    public void should_student_introduce_itself_as_class_leader() throws Exception {
        Student tom = new Student(1, "Tom", 21, klass2);
        klass2.appendMember(tom);
        klass2.assignLeader(tom);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.");
    }

    @Test
    public void should_teacher_have_name_and_age_and_classes() throws Exception {
        LinkedList<practice10.Klass> linkedList = new LinkedList<Klass>();
        linkedList.add(klass2);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        assertThat(tom.getName()).isEqualTo("Tom");
        assertThat(tom.getAge()).isEqualTo(21);
        assertThat(tom.getClasses().size()).isEqualTo(1);
        assertThat(tom.getClasses().toArray()[0]).isEqualTo(klass2);
    }

    @Test
    public void should_teacher_introduce_itself_with_which_classes_it_teaches() throws Exception {
        LinkedList<practice10.Klass> linkedList = new LinkedList<Klass>();
        Klass klass3 = new Klass(3);
        linkedList.add(klass2);
        linkedList.add(klass3);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2, 3.");
    }

    @Test
    public void should_teacher_introduce_itself_with_no_class_teaching() throws Exception {
        Teacher tom = new Teacher(1, "Tom", 21);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
    }

    @Test
    public void should_teacher_isTeaching_return_true_when_the_student_is_in_any_classes_the_teacher_teaches() throws Exception {
        LinkedList<practice10.Klass> linkedList = new LinkedList<Klass>();
        Klass klass3 = new Klass(3);
        linkedList.add(klass2);
        linkedList.add(klass3);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        Student jerry = new Student(1, "Jerry", 8, klass2);

        assertThat(tom.isTeaching(jerry)).isTrue();
    }

    @Test
    public void should_teacher_isTeaching_return_false_when_the_student_is_not_in_all_the_classes_the_teacher_teaches() throws Exception {
        LinkedList<practice10.Klass> linkedList = new LinkedList<Klass>();
        linkedList.add(klass2);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        Student jerry = new Student(1, "Jerry", 8, new Klass(3));

        assertThat(tom.isTeaching(jerry)).isFalse();
    }

    @Test
    public void should_teacher_introduce_a_student_it_teaches() throws Exception {
        LinkedList<practice10.Klass> linkedList = new LinkedList<Klass>();
        linkedList.add(klass2);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        Student jerry = new Student(1, "Jerry", 8, klass2);
        assertThat(tom.introduceWith(jerry)).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry.");
    }

    @Test
    public void should_teacher_introduce_a_student_it_does_not_teach() throws Exception {
        LinkedList<practice10.Klass> linkedList = new LinkedList<Klass>();
        Klass klass1 = new Klass(1);
        linkedList.add(klass1);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        Student jerry = new Student(1, "Jerry", 8, new Klass(2));
        assertThat(tom.introduceWith(jerry)).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry.");
    }
}
