package practice07;

public class Klass {
    private int klass;

    public Klass(int klass) {
        this.klass = klass;
    }

    public int getNumber() {
        return klass;
    }

    public String getDisplayName() {
        return String.format("Class %d", klass);
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
