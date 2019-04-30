package practice08;

public class Person {
    private String name;
    private int age;
    private int id;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int id, String name, int age) {
        this(name, age);
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
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
