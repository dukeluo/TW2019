//package practice03;
//
//import org.junit.Test;
//
//import static org.fest.assertions.api.Assertions.assertThat;
//
//public class Practice03Test {
//    @Test
//    public void should_person_have_name_and_age() throws Exception {
//        Person person = new Person("Tom", 21);
//        assertThat(person.getName()).isEqualTo("Tom");
//        assertThat(person.getAge()).isEqualTo(21);
//    }
//
//    @Test
//    public void should_person_have_an_introduce_method_which_introduce_person_with_name_and_age() throws Exception {
//        Person tom = new Person("Tom", 21);
//        String introduce = tom.introduce();
//        assertThat(introduce).isEqualTo("My name is Tom. I am 21 years old.");
//    }
//
//    @Test
//    public void should_student_have_name_age_and_class_number() throws Exception {
//        Student tom = new Student("Tom", 21, 2);
//        assertThat(tom.getName()).isEqualTo("Tom");
//        assertThat(tom.getAge()).isEqualTo(21);
//        assertThat(tom.getKlass()).isEqualTo(2);
//    }
//
//    @Test
//    public void should_student_introduce_with_class() throws Exception {
//        Student tom = new Student("Tom", 21, 2);
//        assertThat(tom.introduce()).isEqualTo("I am a Student. I am at Class 2.");
//    }
//
//    @Test
//    public void should_worker_have_name_and_age() throws Exception {
//        Worker tom = new Worker("Tom", 21);
//        assertThat(tom.getName()).isEqualTo("Tom");
//        assertThat(tom.getAge()).isEqualTo(21);
//    }
//
//    @Test
//    public void should_worker_introduce_itself_with_no_field() throws Exception {
//        Worker tom = new Worker("Tom", 21);
//        assertThat(tom.introduce()).isEqualTo("I am a Worker. I have a job.");
//    }
//}
