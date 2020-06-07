package cn.xpbootcamp.tdd;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> pouredNumbers = new ArrayList<>();

    public void roll(int pouredNumber) {
        pouredNumbers.add(pouredNumber);
    }

    public int scoring() {
        int totalScore = 0;
        int rollIndex = 0;
        for (int round = 0; round < 10; round++) {
            if (isSpare(rollIndex)) {
                totalScore += 10;
                totalScore += pouredNumbers.get(rollIndex + 2);
            } else {
                totalScore += pouredNumbers.get(rollIndex);
                totalScore += pouredNumbers.get(rollIndex + 1);
            }
            rollIndex += 2;
        }
        return totalScore;
    }

    private boolean isSpare(int rollIndex) {
        return pouredNumbers.get(rollIndex) + pouredNumbers.get(rollIndex + 1) == 10;
    }
}
