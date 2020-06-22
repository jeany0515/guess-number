package cn.xpbootcamp.tdd;

import java.util.Arrays;
import java.util.Scanner;

public class InputScanner {
    private static final int ROUND = 6;

    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        int[] randomList = randomNumber.generate();
        System.out.println("Random number is" + Arrays.toString(randomList));
        NumberGuess numberGuess = new NumberGuess(randomList);
        System.out.println( "Please enter numbers : " );

        for (int round = 0; round < ROUND; round ++ ) {
            Scanner scanner = new Scanner(System.in);
            String scannerString = scanner.nextLine();

            System.out.println( "Your input is :" + scannerString);

            char[] scannerInputs  = scannerString.toCharArray();
            int[] inputNumbers = new int[scannerInputs.length];

            for(int i=0;i<scannerInputs.length;i++){
                inputNumbers[i]=Integer.parseInt(String.valueOf(scannerInputs[i]));
            }

            String result = numberGuess.verify(inputNumbers);
            System.out.println( "The output is :" + result);
        }
    }
}
