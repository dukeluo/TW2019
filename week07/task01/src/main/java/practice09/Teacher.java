package practice09;

public class Teacher extends practice08.Teacher {
    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age, klass);
    }
}
