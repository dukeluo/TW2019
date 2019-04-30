package practice08;

public class Klass {
    private int klass;
    private Student leader;

    public Klass(int klass) {
        this.klass = klass;
    }

    public int getNumber() {
        return klass;
    }

    public String getDisplayName() {
        return String.format("Class %d", klass);
    }

    public void assignLeader(Student s) {
        leader = s;
    }

    public Student getLeader() {
        return leader;
    }
}
