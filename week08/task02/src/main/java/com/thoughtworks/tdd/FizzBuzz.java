package com.thoughtworks.tdd;

public class FizzBuzz {
    public String fizzBuzz(int num) {
        String result = "";

        if (num % 3 == 0) {
            result += "Fizz";
        } else if (num % 5 == 0) {
            result += "Buzz";
        } else {
            result += num;
        }
        return result;
    }
}
