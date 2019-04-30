package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduce() {
        String str = (klass == null)
                ? "I am a Teacher. I teach No Class."
                : String.format("I am a Teacher. I teach %s.", klass.getDisplayName());

        return super.introduce()
                + " "
                + str;
    }

    public String introduceWith(Student s) {
        String str = (klass == s.getKlass())
                ? String.format("I teach %s.", s.getName())
                : String.format("I don't teach %s.", s.getName());

        return super.introduce()
                + " "
                + "I am a Teacher."
                + " "
                + str;
    }
}
