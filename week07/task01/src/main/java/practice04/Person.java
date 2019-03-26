package practice04;

public class Person extends practice01.Person {
    public Person(String name, int age) {
        super(name, age);
    }

    public String introduce() {
        return basicIntroduce();
    }

    protected String basicIntroduce() {
        return super.introduce();
    }
}
