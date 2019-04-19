package com.thoughtworks.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void should_return_itself_when_number_is_not_a_multiple_of_3_or_5_or_7() {
        String result = fizzBuzz.fizzBuzz(2);

        assertEquals("2", result);
    }

    @Test
    void should_return_Fizz_when_number_is_a_multiple_of_3() {
        String result = fizzBuzz.fizzBuzz(6);

        assertEquals("Fizz", result);
    }

    @Test
    void should_return_Buzz_when_number_is_a_multiple_of_5() {
        String result = fizzBuzz.fizzBuzz(10);

        assertEquals("Buzz", result);
    }

    @Test
    void should_return_Whizz_when_number_is_a_multiple_of_7() {
        String result = fizzBuzz.fizzBuzz(14);

        assertEquals("Whizz", result);
    }

    @Test
    void should_return_FizzBuzz_when_number_is_a_multiple_of_3_or_5() {
        String result = fizzBuzz.fizzBuzz(15);

        assertEquals("FizzBuzz", result);
    }

    @Test
    void should_return_FizzWhizz_when_number_is_a_multiple_of_3_or_7() {
        String result = fizzBuzz.fizzBuzz(21);

        assertEquals("FizzWhizz", result);
    }

    @Test
    void should_return_BuzzWhizz_when_number_is_a_multiple_of_5_or_7() {
        String result = fizzBuzz.fizzBuzz(70);

        assertEquals("BuzzWhizz", result);
    }

    @Test
    void should_return_FizzBuzzWhizz_when_number_is_a_multiple_of_3_or_5_or_7() {
        String result = fizzBuzz.fizzBuzz(105);

        assertEquals("FizzBuzzWhizz", result);
    }
}
