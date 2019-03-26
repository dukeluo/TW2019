package practice03;

public class Worker extends practice02.Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    public String introduce() {
        return "I am a Worker. I have a job.";
    }
}
