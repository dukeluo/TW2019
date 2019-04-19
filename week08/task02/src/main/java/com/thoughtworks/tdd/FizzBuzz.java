package com.thoughtworks.tdd;

public class FizzBuzz {
    public String fizzBuzz(int num) {
        String result = "";

        if (num % 3 == 0) {
            result += "Fizz";
        } else {
            result += num;
        }
        return result;
    }
}
