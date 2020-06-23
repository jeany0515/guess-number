package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GuessNumberValidatorTest {
    private GuessNumberValidator guessNumberValidator;

    @BeforeEach
    void setUp() {
        guessNumberValidator = new GuessNumberValidator();
    }

    @Test
    void should_return_false_when_verify_guess_number_given_12() {
        int[] guessNumber = {1, 2};

        boolean result = guessNumberValidator.verify(guessNumber);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void should_return_false_when_verify_input_given_12345() {
        int[] guessNumber = {1, 2, 3, 4, 5};

        boolean result = guessNumberValidator.verify(guessNumber);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void should_return_wrong_input_when_verify_guess_number_given_1223() {
        int[] guessNumber = {1, 2, 2, 4};

        boolean result = guessNumberValidator.verify(guessNumber);

        assertThat(result).isEqualTo(false);
    }

    @Test
    void should_return_true_when_verify_guess_number_given_1234() {
        int[] guessNumber = {1, 2, 3, 4};

        boolean result = guessNumberValidator.verify(guessNumber);

        assertThat(result).isEqualTo(true);
    }

}
