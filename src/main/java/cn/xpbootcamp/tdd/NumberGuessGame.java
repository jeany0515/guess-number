package cn.xpbootcamp.tdd;

import java.util.Scanner;

public class NumberGuessGame {

    public static void main(String[] args) {
        RandomGenerator randomGenerator = new RandomGenerator();
        GameEngine gameEngine = new GameEngine(randomGenerator);
        Scanner scanner = new Scanner(System.in);

        System.out.println( "Please enter numbers : " );


        while (gameEngine.canPlay()) {
            int[] guessNumber = readUserInput(scanner);

            String output = gameEngine.play(guessNumber);

            System.out.println( "The output is :" + output);
        }
    }

    public static int[] readUserInput(Scanner scanner) {
        String scannerString = scanner.nextLine();

        System.out.println( "Your input is :" + scannerString);

        char[] scannerInputs  = scannerString.toCharArray();
        int[] guessNumber = new int[scannerInputs.length];

        for(int i=0; i<scannerInputs.length; i++){
            guessNumber[i]=Integer.parseInt(String.valueOf(scannerInputs[i]));
        }
        return guessNumber;
    }
}
