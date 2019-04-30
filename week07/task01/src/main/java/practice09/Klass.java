package practice09;

public class Klass {
    private int klass;
    private Student leader;
    private int count = 0;

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

    public void appendMember(Student s) {
        s.setKlass(this);
        count++;
    }

    public void assignLeader(Student s) {
        if (count == 0) {
            System.out.println("It is not one of us.");
            return ;
        }
        leader = s;
    }
}
