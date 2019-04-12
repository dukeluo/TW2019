package tw.core;

import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnswerTest {
    private Answer answer;

    @Before
    public void setUp() throws Exception {
        answer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_return_an_answer_object() throws Exception {
        String input = "1 2 3 4";
        Answer result = Answer.createAnswer(input);

        assertEquals("1 2 3 4", result.toString());
    }

    @Test
    public void should_return_1A0B_when_1_position_correct_and_other_0_number_include() throws Exception {
        Answer inputAnswer = Answer.createAnswer("1 5 6 7");

        assertEquals("1A0B", answer.check(inputAnswer).getValue());
    }

    @Test
    public void should_return_0A2B_when_0_position_correct_and_other_2_number_include() throws Exception {
        Answer inputAnswer = Answer.createAnswer("2 4 7 8");

        assertEquals("0A2B", answer.check(inputAnswer).getValue());
    }

    @Test
    public void should_return_1A2B_when_1_position_correct_and_other_2_number_include() throws Exception {
        Answer inputAnswer = Answer.createAnswer("0 3 2 4");

        assertEquals("1A2B", answer.check(inputAnswer).getValue());
    }

    @Test
    public void should_return_0A0B_when_0_position_correct_and_other_0_number_include() throws Exception {
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        assertEquals("0A0B", answer.check(inputAnswer).getValue());
    }

    @Test
    public void should_return_0A4B_when_0_position_correct_and_other_4_number_include() throws Exception {
        Answer inputAnswer = Answer.createAnswer("4 3 2 1");

        assertEquals("0A4B", answer.check(inputAnswer).getValue());
    }

    @Test
    public void should_return_4A0B_when_both_4_position_correct() throws Exception {
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");

        assertEquals("4A0B", answer.check(inputAnswer).getValue());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_a_OutOfRangeAnswerException_when_inputAnswer_has_duplicate_digit() throws Exception {
        Answer answer = Answer.createAnswer("1 1 2 3");

        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage("Answer format is incorrect");
        answer.validate();
    }

    @Test
    public void should_throw_a_OutOfRangeAnswerException_when_inputAnswer_count_less_than_4() throws Exception {
        Answer answer = Answer.createAnswer("1 2");

        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage("Answer format is incorrect");
        answer.validate();
    }

    @Test
    public void should_throw_a_OutOfRangeAnswerException_when_inputAnswer_has_digit_greater_than_9() throws Exception {
        Answer answer = Answer.createAnswer("10 1 2 3");

        thrown.expect(OutOfRangeAnswerException.class);
        thrown.expectMessage("Answer format is incorrect");
        answer.validate();
    }
}