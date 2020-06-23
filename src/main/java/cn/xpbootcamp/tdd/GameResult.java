package cn.xpbootcamp.tdd;

public class GameResult {
    private boolean isGameOver;
    private String output;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return this.output;
    };
}
