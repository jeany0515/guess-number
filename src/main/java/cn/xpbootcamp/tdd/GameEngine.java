package cn.xpbootcamp.tdd;

public class GameEngine {
    private final static int ROUND = 6;
    private final static String WRONG_MSG = "Wrong Input，Input again";
    private int roundCount = 0;
    private int[] randoms;

    public GameEngine(RandomGenerator randomGenerator) {
        this.randoms = randomGenerator.generate();
    }

    public GameResult play(int[] guessNumber) {
        GuessNumberValidator guessNumberValidator = new GuessNumberValidator();
        String output = WRONG_MSG;

         if (guessNumberValidator.verify(guessNumber)) {
             ComparisonEngine comparisonEngine = new ComparisonEngine();
             output = comparisonEngine.compare(guessNumber,randoms);
         }
         roundCount ++;

        boolean isGameOver = output.equals("4A0B") || roundCount == ROUND;
        GameResult gameResult = new GameResult();
        gameResult.setOutput(output);
        gameResult.setGameOver(isGameOver);

        return  gameResult;
    }
}
