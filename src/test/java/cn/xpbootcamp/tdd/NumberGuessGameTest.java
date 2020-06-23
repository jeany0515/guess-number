package cn.xpbootcamp.tdd;

import org.junit.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberGuessGameTest {

    @Test
    public void should_return_number_list_when_read_input_given_string_line() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("1234");

        int[] result = NumberGuessGame.readUserInput(scanner);
        int[] expected = {1, 2, 3, 4};

        assertThat(result).isEqualTo(expected);
    }
}
