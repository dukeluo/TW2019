package practice11;

import java.util.Collection;
import java.util.LinkedList;

public class Klass extends practice10.Klass {
    private Collection<Teacher> teachers = new LinkedList<Teacher>();

    public Klass(int klass) {
        super(klass);
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    public void appendMember(Student s) {
        super.appendMember(s);
        notifyAll(s, 0);    // 0 means someone joins; 1 means someone be the leader
    }

    public void assignLeader(Student s) {
        super.assignLeader(s);
        notifyAll(s, 1);    // 0 means someone joins; 1 means someone be the leader
    }

    public void notifyAll(Student s, int messageType) {
        for (Teacher t : teachers) {
            t.update(s, messageType);
        }
    }
}
