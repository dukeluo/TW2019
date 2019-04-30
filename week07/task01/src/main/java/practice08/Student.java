package practice08;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        String str = (this.equals(klass.getLeader()))
                ? String.format("I am a Student. I am Leader of %s.", klass.getDisplayName())
                : String.format("I am a Student. I am at %s.",klass.getDisplayName());

        return super.introduce()
                + " "
                + str;
    }
}
