package cn.xpbootcamp.tdd;

import java.util.Arrays;

public class GameEngine {
    private final static int ROUND = 6;
    private final static String WRONG_MSG = "Wrong Input，Input again";
    private final static String SUCCESS_MSG = "4A0B";
    private int roundCount = 0;
    private int[] randoms;
    private boolean isSuccess = false;

    public GameEngine(RandomGenerator randomGenerator) {
        this.randoms = randomGenerator.generate();
        System.out.println("Random number is" + Arrays.toString(randoms));
    }

    public String play(int[] guessNumber) {
        GuessNumberValidator guessNumberValidator = new GuessNumberValidator();
        String output = WRONG_MSG;

         if (guessNumberValidator.verify(guessNumber)) {
             ComparisonEngine comparisonEngine = new ComparisonEngine();
             output = comparisonEngine.compare(guessNumber,randoms);
         }

         roundCount ++;
         isSuccess = output.equals(SUCCESS_MSG);
         return output;
    }

    public boolean canPlay() {
        return roundCount != ROUND && !isSuccess;
    }
}
