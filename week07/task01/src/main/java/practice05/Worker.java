package practice05;

public class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce() {
        return super.introduce()
                + " "
                + "I am a Worker. I have a job.";
    }
}
