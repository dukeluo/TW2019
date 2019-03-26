package practice09;

public class Klass extends practice08.Klass {
    private int count = 0;

    public Klass(int klass) {
        super(klass);
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
        super.assignLeader(s);
    }
}
