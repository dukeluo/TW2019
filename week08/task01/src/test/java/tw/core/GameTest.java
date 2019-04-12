package tw.core;

import tw.core.Answer;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private AnswerGenerator mockedAnswerGenerator;
    private Game game;

    @Before
    public void setUp() throws Exception {
        mockedAnswerGenerator = mock(AnswerGenerator.class);

        when(mockedAnswerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));

        game = new Game(mockedAnswerGenerator);
    }

    @Test
    public void should_return_a_GuessResult_object() throws Exception {
        Answer inputAnswer = Answer.createAnswer("1 9 7 8");
        GuessResult guessResult = game.guess(inputAnswer);

        assertEquals("1A0B", guessResult.getResult());
        assertEquals("1 9 7 8", guessResult.getInputAnswer().toString());
    }

    @Test
    public void should_return_a_list_of_GuessResult_object() throws Exception {
        Answer inputAnswer1 = Answer.createAnswer("1 9 7 8");
        Answer inputAnswer2 = Answer.createAnswer("1 9 8 4");
        List<GuessResult> guessResultList;

        game.guess(inputAnswer1);
        game.guess(inputAnswer2);
        guessResultList = game.guessHistory();


        assertEquals("1A0B", guessResultList.get(0).getResult());
        assertEquals("1 9 7 8", guessResultList.get(0).getInputAnswer().toString());
        assertEquals("2A0B", guessResultList.get(1).getResult());
        assertEquals("1 9 8 4", guessResultList.get(1).getInputAnswer().toString());
    }

    @Test
    public void should_return_status_fail_when_execute_6_incorrect_guesses() throws Exception {
        executeSixIncorrectGuesses();
        assertEquals("fail", game.checkStatus());
    }

    @Test
    public void should_return_status_success_when_execute_guesses_contain_actual_answer() throws Exception {
        executeGuessesContainActualAnswer();
        assertEquals("success", game.checkStatus());
    }

    @Test
    public void should_return_status_continue_when_execute_guesses_incorrect_guesses_less_than_6() throws Exception {
        executeIncorrectGuessesLessThan6();
        assertEquals("continue", game.checkStatus());
    }

    @Test
    public void should_return_false_when_guess_greater_or_equal_to_6() throws Exception {
        executeSixIncorrectGuesses();
        assertEquals(false, game.checkCoutinue());
    }

    @Test
    public void should_return_true_when_guess_less_than_6() throws Exception {
        executeIncorrectGuessesLessThan6();
        assertEquals(true, game.checkCoutinue());
    }

    private void executeSixIncorrectGuesses() {
        Answer inputAnswer1 = Answer.createAnswer("1 9 7 8");
        Answer inputAnswer2 = Answer.createAnswer("1 9 8 4");
        Answer inputAnswer3 = Answer.createAnswer("4 3 9 6");
        Answer inputAnswer4 = Answer.createAnswer("5 2 6 8");
        Answer inputAnswer5 = Answer.createAnswer("1 3 2 4");
        Answer inputAnswer6 = Answer.createAnswer("8 3 2 7");

        game.guess(inputAnswer1);
        game.guess(inputAnswer2);
        game.guess(inputAnswer3);
        game.guess(inputAnswer4);
        game.guess(inputAnswer5);
        game.guess(inputAnswer6);
    }

    private void executeGuessesContainActualAnswer() {
        Answer inputAnswer1 = Answer.createAnswer("1 9 7 8");
        Answer inputAnswer2 = Answer.createAnswer("1 9 8 4");
        Answer inputAnswer3 = Answer.createAnswer("4 3 9 6");
        Answer inputAnswer4 = Answer.createAnswer("5 2 6 8");
        Answer inputAnswer5 = Answer.createAnswer("1 2 3 4");

        game.guess(inputAnswer1);
        game.guess(inputAnswer2);
        game.guess(inputAnswer3);
        game.guess(inputAnswer4);
        game.guess(inputAnswer5);
    }

    private void executeIncorrectGuessesLessThan6() {
        Answer inputAnswer1 = Answer.createAnswer("1 9 7 8");
        Answer inputAnswer2 = Answer.createAnswer("1 9 8 4");
        Answer inputAnswer3 = Answer.createAnswer("4 3 9 6");
        Answer inputAnswer4 = Answer.createAnswer("5 2 6 8");

        game.guess(inputAnswer1);
        game.guess(inputAnswer2);
        game.guess(inputAnswer3);
        game.guess(inputAnswer4);
    }
}
