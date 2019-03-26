package practice08;

public class Klass extends practice07.Klass {
    private Student leader;

    public Klass(int klass) {
        super(klass);
    }

    public void assignLeader(Student s) {
        leader = s;
    }

    public Student getLeader() {
        return leader;
    }
}
