package com.thoughtworks.tdd;

/**
 * Created by twer on 3/28/14.
 */
public class HelloWorld {
    private Dependency dependency;

    public HelloWorld(Dependency dependency) {

        this.dependency = dependency;
    }
    public String beenCalled() {
        return dependency.say();
    }
}
