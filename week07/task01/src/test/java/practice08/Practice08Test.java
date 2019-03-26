package practice08;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class Practice08Test {
    private Klass klass;

    @Before
    public void setup() {
        klass = new Klass(2);
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
        assertThat(klass.getNumber()).isEqualTo(2);
    }

    @Test
    public void should_class_get_display_name() throws Exception {
        assertThat(klass.getDisplayName()).isEqualTo("Class 2");
    }

    @Test
    public void should_class_assign_a_leader() throws Exception {
        Student jerry = new Student(1, "Jerry", 8, klass);
        klass.assignLeader(jerry);
        assertThat(klass.getLeader()).isEqualTo(jerry);
    }

    @Test
    public void should_student_have_name_age_and_class_number() throws Exception {
        Student tom = new Student(1, "Tom", 21, klass);
        assertThat(tom.getName()).isEqualTo("Tom");
        assertThat(tom.getAge()).isEqualTo(21);
        assertThat(tom.getKlass()).isEqualTo(klass);
    }

    @Test
    public void should_student_introduce_with_class() throws Exception {
        Student tom = new Student(1, "Tom", 21, klass);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");
    }

    @Test
    public void should_student_introduce_itself_as_class_leader() throws Exception {
        Student tom = new Student(1, "Tom", 21, klass);
        klass.assignLeader(tom);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.");
    }

    @Test
    public void should_teacher_have_name_and_age_and_class() throws Exception {
        Teacher tom = new Teacher(1, "Tom", 21, klass);
        assertThat(tom.getName()).isEqualTo("Tom");
        assertThat(tom.getAge()).isEqualTo(21);
        assertThat(tom.getKlass()).isEqualTo(klass);
    }

    @Test
    public void should_teacher_introduce_itself_with_which_class_it_teaches() throws Exception {
        Teacher tom = new Teacher(1, "Tom", 21, klass);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.");
    }

    @Test
    public void should_teacher_introduce_itself_with_no_class_teaching() throws Exception {
        Teacher tom = new Teacher(1, "Tom", 21);
        assertThat(tom.introduce()).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
    }

    @Test
    public void should_teacher_introduce_a_student_it_teaches() throws Exception {
        Teacher tom = new Teacher(1, "Tom", 21, klass);
        Student jerry = new Student(1, "Jerry", 8, klass);
        assertThat(tom.introduceWith(jerry)).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry.");
    }

    @Test
    public void should_teacher_introduce_a_student_it_does_not_teach() throws Exception {
        Teacher tom = new Teacher(1, "Tom", 21, new Klass(1));
        Student jerry = new Student(1, "Jerry", 8, new Klass(2));
        assertThat(tom.introduceWith(jerry)).isEqualTo("My name is Tom. I am 21 years old. I am a Teacher. I don't teach Jerry.");
    }
}
