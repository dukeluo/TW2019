package practice11;

import java.util.Collection;
import java.util.LinkedList;

public class Klass {
    private int klass;
    private Student leader;
    private int count = 0;
    private Collection<Teacher> teachers = new LinkedList<Teacher>();

    public Klass(int klass) {
        this.klass = klass;
    }

    public int getNumber() {
        return klass;
    }

    public String getDisplayName() {
        return String.format("Class %d", klass);
    }

    public Student getLeader() {
        return leader;
    }

    public boolean contains(Student s) {
        return s.getKlass().equals(this);
    }

    public void appendMember(Student s) {
        s.setKlass(this);
        count++;
        notifyAll(s, 0);    // 0 means someone joins; 1 means someone be the leader
    }

    public void assignLeader(Student s) {
        if (count == 0) {
            System.out.println("It is not one of us.");
            return ;
        }
        leader = s;
        notifyAll(s, 1);    // 0 means someone joins; 1 means someone be the leader
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    private void notifyAll(Student s, int messageType) {
        for (Teacher t : teachers) {
            t.update(s, messageType);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Klass k = (Klass) o;

        return k.getNumber() == this.getNumber();
    }
}
