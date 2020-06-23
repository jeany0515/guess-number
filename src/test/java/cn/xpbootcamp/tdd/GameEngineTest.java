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
    void should_return_wrong_input_when_play_game_given_guess_number_12() {
        int[] guessNumber = {1, 2};

        String result = gameEngine.play(guessNumber);

        assertThat(result).isEqualTo("Wrong Input，Input again");
    }

    @Test
    void should_return_1A2B_and_can_play_when_play_game_given_guess_number_1425_and_random_1234() {
        int[] guessNumber = {1, 4, 2, 5};

        String result = gameEngine.play(guessNumber);

        assertThat(result).isEqualTo("1A2B");
        assertThat(gameEngine.canPlay()).isEqualTo(true);
    }

    @Test
    void should_return_4A0B_and_can_not_play_when_play_game_given_guess_number_1234_and_random_1234() {
        int[] guessNumber = {1, 2, 3, 4};

        String result = gameEngine.play(guessNumber);

        assertThat(result).isEqualTo("4A0B");
        assertThat(gameEngine.canPlay()).isEqualTo(false);
    }

    @Test
    void should_return_can_not_play_after_6_round_when_play_game_given_no_round_success() {
        int[] guessNumber = {1, 2, 4, 5};

        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);
        gameEngine.play(guessNumber);

        assertThat(gameEngine.canPlay()).isEqualTo(false);
    }

}
