package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class NumberGuessTest {
    @InjectMocks
    private NumberGuess numberGuess;

    @Mock
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
//        randomNumber = mock(RandomNumber.class);
        numberGuess = new NumberGuess(4);
    }

    @Test
    void should_return_wrong_input_when_verify_input_given_2_number() {
        int[] input = {1, 2};

        String result = numberGuess.verify(input);

        assertThat(result).isEqualTo("Wrong Input，Input again");
    }

    @Test
    void should_return_wrong_input_when_verify_input_given_5_number() {
        int[] input = {1, 2, 3, 4, 5};

        String result = numberGuess.verify(input);

        assertThat(result).isEqualTo("Wrong Input，Input again");
    }

    @Test
    void should_return_wrong_input_when_verify_input_given_4_numbers_with_number_repeat() {
        int[] input = {1, 2, 2, 4};

        String result = numberGuess.verify(input);

        assertThat(result).isEqualTo("Wrong Input，Input again");
    }

    @Test
    void should_return_0A0B_when_verify_input_given_4_numbers_with_no_number_match_randoms() {
        int[] input = {5, 6, 7, 9};
        int[] randoms = {1, 2, 3, 4};
        when(randomNumber.generate()).thenReturn(randoms);

        String result = numberGuess.verify(input);

        assertThat(result).isEqualTo("0A0B");
    }

    @Test
    void should_return_0A4B_when_verify_input_given_4_numbers_with_all_number_and_0_position_match() {
        int[] input = {4, 3, 2, 1};
        int[] randoms = {1, 2, 3, 4};
        when(randomNumber.generate()).thenReturn(randoms);

        String result = numberGuess.verify(input);

        assertThat(result).isEqualTo("0A4B");
    }

    @Test
    void should_return_4A0B_when_verify_input_given_4_numbers_with_all_number_and_all_position_match() {
        int[] input = {1, 2, 3, 4};
        int[] randoms = {1, 2, 3, 4};
        when(randomNumber.generate()).thenReturn(randoms);

        String result = numberGuess.verify(input);

        assertThat(result).isEqualTo("4A0B");
    }

    @Test
    void should_return_1A2B_when_verify_input_given_4_numbers_with_2_number_and_1_position_match() {
        int[] input = {1, 5, 2, 3};
        int[] randoms = {1, 2, 3, 4};
        when(randomNumber.generate()).thenReturn(randoms);

        String result = numberGuess.verify(input);

        assertThat(result).isEqualTo("1A2B");
    }
}