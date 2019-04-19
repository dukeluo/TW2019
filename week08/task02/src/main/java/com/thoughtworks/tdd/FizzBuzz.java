package com.thoughtworks.tdd;

public class FizzBuzz {
    public String fizzBuzz(int num) {
        String result = "";

        if (num % 3 == 0) {
            result += "Fizz";
        }
        if (num % 5 == 0) {
            result += "Buzz";
        }
        if (num % 7 == 0) {
            result += "Whizz";
        }
        if (result.length() == 0) {
            result += num;
        }
        return result;
    }
}
