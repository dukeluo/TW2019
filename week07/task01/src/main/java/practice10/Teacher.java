package practice10;

import java.util.Collection;
import java.util.LinkedList;

public class Teacher extends Person {
    private LinkedList<Klass> classes = new LinkedList<Klass>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Collection<Klass> getClasses() {
        return classes;
    }

    public boolean isTeaching(Student s) {
        for (Klass k : classes) {
            if (k.isIn(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String introduce() {
        int size = classes.size();
        String str = "";

        for (int i = 0; i < size; i++) {
            str += (i < size - 1)
                    ? classes.get(i).getNumber() + ", "
                    : classes.get(i).getNumber();
        }
        str = (size == 0)
                ? "No Class"
                : "Class " + str;
        return super.introduce()
                + " "
                + "I am a Teacher."
                + " "
                + String.format("I teach %s.", str);
    }

    public String introduceWith(Student s) {
        String str = isTeaching(s)
                ? String.format("I teach %s.", s.getName())
                : String.format("I don't teach %s.", s.getName());

        return super.introduce()
                + " "
                + "I am a Teacher."
                + " "
                + str;
    }
}
