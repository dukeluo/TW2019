package tw.core;

import tw.core.generator.RandomIntGenerator;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setUp() throws Exception {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_an_IllegalArgumentException_when_digitmax_is_less_than_numbersOfNeed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        randomIntGenerator.generateNums(3, 4);
    }

    @Test
    public void should_return_a_string_of_four_digits_less_than_ten() throws Exception {
        String numString = randomIntGenerator.generateNums(9, 4);
        String [] digits = numString.split(" ");
        boolean allLessThanTen = true;

        for (String s : digits) {
            if (Integer.parseInt(s) > 9) {
                allLessThanTen = false;
                break;
            }
        }
        assertEquals(4, digits.length);
        assertEquals(true, allLessThanTen);
    }
}