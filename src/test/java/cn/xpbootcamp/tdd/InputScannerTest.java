package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class InputScannerTest {

    @Test
    void should_call_generate_randoms_and_scan_input_and_verify_input_in_order() {

        int[] randoms = {1, 2, 3, 4};
        RandomNumber randomNumber = mock(RandomNumber.class);
        when(randomNumber.generate()).thenReturn(randoms);

        String input = "4567";
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn(input);

        int[] inputNumbers = {4, 5, 6,7};
        NumberGuess numberGuess = mock(NumberGuess.class);
        Mockito.doNothing().when(numberGuess).verify(inputNumbers);

        String[] inputList = {"4567"};
        InputScanner.main(inputList);


        InOrder inOrder = inOrder(randomNumber, mockScanner, numberGuess);

        inOrder.verify(randomNumber).generate();
        inOrder.verify(mockScanner).nextLine();
        inOrder.verify(numberGuess).verify(inputNumbers);

    }

}