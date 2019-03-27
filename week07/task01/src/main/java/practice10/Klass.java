package practice10;

public class Klass extends practice09.Klass {
    public Klass(int klass) {
        super(klass);
    }

    public boolean isIn(Student s) {
        return s.getKlass().equals(this);
    }

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
