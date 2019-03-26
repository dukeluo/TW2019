package practice08;

public class Person extends practice05.Person {
    private final int id;

    public Person(int id, String name, int age) {
        super(name, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return id == person.id;
    }
}
