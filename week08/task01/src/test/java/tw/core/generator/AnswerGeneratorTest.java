package tw.core.generator;

import tw.core.RandomIntGeneratorTest;
import tw.core.generator.RandomIntGenerator;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.Answer;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

public class AnswerGeneratorTest {
    private RandomIntGenerator mockedRandomIntGenerator;
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception {
        mockedRandomIntGenerator = mock(RandomIntGenerator.class);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_a_OutOfRangeAnswerException() throws Exception {
        when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 10");

        answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
        thrown.expect(OutOfRangeAnswerException.class);
        answerGenerator.generate();
    }

    @Test
    public void should_return_an_answer_object() throws Exception {
        when(mockedRandomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 4");

        answerGenerator = new AnswerGenerator(mockedRandomIntGenerator);
        Answer answer = answerGenerator.generate();
        assertEquals("1 2 3 4", answer.toString());
    }
}

