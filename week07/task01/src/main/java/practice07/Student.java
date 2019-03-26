package practice07;

public class Student extends Person {
    private Klass klass;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, Klass klass) {
        this(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        return super.introduce()
                + " "
                + String.format("I am a Student. I am at %s.",klass.getDisplayName());
    }
}
