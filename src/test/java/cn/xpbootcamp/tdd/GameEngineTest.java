package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameEngineTest {
    private GameEngine gameEngine;
    private int[] randoms = {1, 2, 3, 4};

    @BeforeEach
    void setUp() {
        RandomGenerator randomGenerator = mock(RandomGenerator.class);
        when(randomGenerator.generate()).thenReturn(randoms);
        gameEngine = new GameEngine(randomGenerator);
    }

    @Test
    void should_return_guess_result_with_game_not_status_and_wrong_message_when_play_game_given_guess_number_12() {
        int[] guessNumber = {1, 2};

        GameResult gameResult = gameEngine.play(guessNumber);

        assertThat(gameResult.getOutput()).isEqualTo("Wrong Input，Input again");
        assertThat(gameResult.isGameOver()).isEqualTo(false);
    }

    @Test
    void should_return_guess_result_with_game__over_and_output_when_play_game_given_guess_number_1234_and_random_1234() {
        int[] guessNumber = {1, 2, 3, 4};

        GameResult gameResult = gameEngine.play(guessNumber);

        assertThat(gameResult.getOutput()).isEqualTo("4A0B");
        assertThat(gameResult.isGameOver()).isEqualTo(true);
    }

    @Test
    void should_return_round_1_and_2_guess_fail_and_round_3_success_when_play_game_given_random_1234_and_guess_number_12_1245_1234() {
        int[] guessNumberRound_1 = {1, 2};
        int[] guessNumberRound_2 = {1, 2, 4, 5};
        int[] guessNumberRound_3 = {1, 2, 3, 4};

        GameResult gameResultRound_1 = gameEngine.play(guessNumberRound_1);
        GameResult gameResultRound_2 = gameEngine.play(guessNumberRound_2);
        GameResult gameResultRound_3 = gameEngine.play(guessNumberRound_3);

        assertThat(gameResultRound_1.getOutput()).isEqualTo("Wrong Input，Input again");
        assertThat(gameResultRound_1.isGameOver()).isEqualTo(false);

        assertThat(gameResultRound_2.getOutput()).isEqualTo("2A1B");
        assertThat(gameResultRound_2.isGameOver()).isEqualTo(false);

        assertThat(gameResultRound_3.getOutput()).isEqualTo("4A0B");
        assertThat(gameResultRound_3.isGameOver()).isEqualTo(true);
    }

    @Test
    void should_return_game_over_after_6_round_when_play_game_given_random_1234_and_guess_number_1245_with_6_times() {
        int[] guessNumber = {1, 2, 4, 5};

        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        GameResult gameResultRound_6 = gameEngine.play(guessNumber);


        assertThat(gameResultRound_6.getOutput()).isEqualTo("2A1B");
        assertThat(gameResultRound_6.isGameOver()).isEqualTo(true);
    }

}
