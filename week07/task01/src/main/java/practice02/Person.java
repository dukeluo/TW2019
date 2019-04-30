package practice02;

public class Person {
    int age;
    String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", name, age);
    }
}
