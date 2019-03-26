package practice07;

public class Klass {
    private final int klass;

    public Klass(int klass) {
        this.klass = klass;
    }

    public int getNumber() {
        return klass;
    }

    public String getDisplayName() {
        return String.format("Class %d", klass);
    }
}
