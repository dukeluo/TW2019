package tw.core;

import tw.validator.InputValidator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputValidatorTest {
    private InputValidator inputValidator;

    @Before
    public void setUp() throws Exception {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_false_when_input_number_count_is_less_than_four() throws Exception {
        String input = "1 2";
        boolean result = inputValidator.validate(input);

        assertEquals(false, result);
    }

    @Test
    public void should_return_false_when_input_number_have_duplicate_member() throws Exception {
        String input = "1 1 2 3";
        boolean result = inputValidator.validate(input);

        assertEquals(false, result);
    }

    @Test
    public void should_return_false_when_input_number_have_member_greater_than_nine() throws Exception {
        String input = "1 2 3 10";
        boolean result = inputValidator.validate(input);

        assertEquals(false, result);
    }

    @Test
    public void should_return_true_when_input_number_meet_the_input_requirements() throws Exception {
        String input = "1 5 6 7";
        boolean result = inputValidator.validate(input);

        assertEquals(true, result);
    }
}
