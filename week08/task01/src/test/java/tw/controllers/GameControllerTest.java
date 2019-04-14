package tw.controllers;

import tw.core.Answer;
import tw.core.generator.AnswerGenerator;
import tw.commands.GuessInputCommand;
import tw.core.Game;
import tw.views.GameView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class GameControllerTest {
    private Answer correctAnswer;
    private Answer incorrectAnswer;
    private GameView mockedGameView;
    private GameController mockedGameController;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator mockedAnswerGenerator;
        Game mockedGame;

        correctAnswer = Answer.createAnswer("1 2 3 4");
        incorrectAnswer = Answer.createAnswer("1 9 7 8");
        mockedAnswerGenerator = mock(AnswerGenerator.class);

        when(mockedAnswerGenerator.generate()).thenReturn(correctAnswer);

        mockedGame = new Game(mockedAnswerGenerator);
        mockedGameView = mock(GameView.class);
        mockedGameController = new GameController(mockedGame, mockedGameView);
    }

    @Test
    public void should_show_the_prompt_game_has_started() throws Exception {
        mockedGameController.beginGame();
        verify(mockedGameView).showBegin();
    }

    @Test
    public void should_show_the_prompt_game_is_continuing() throws Exception {
        GuessInputCommand mockedCommand = mock(GuessInputCommand.class);

        when(mockedCommand.input()).thenReturn(incorrectAnswer);

        mockedGameController.play(mockedCommand);
        verify(mockedCommand, times(6)).input();
    }

    @Test
    public void should_show_the_prompt_game_failed() throws Exception {
        GuessInputCommand mockedCommand = mock(GuessInputCommand.class);

        when(mockedCommand.input()).thenReturn(incorrectAnswer);

        mockedGameController.play(mockedCommand);
        verify(mockedCommand, times(6)).input();
        verify(mockedGameView).showGameStatus("fail");
    }

    @Test
    public void should_show_the_prompt_game_is_successful() throws Exception {
        GuessInputCommand mockedCommand = mock(GuessInputCommand.class);

        when(mockedCommand.input()).thenReturn(correctAnswer);

        mockedGameController.play(mockedCommand);
        verify(mockedCommand, times(1)).input();
        verify(mockedGameView).showGameStatus("success");
    }
}