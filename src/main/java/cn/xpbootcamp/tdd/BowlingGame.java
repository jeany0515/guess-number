package cn.xpbootcamp.tdd;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> pouredNumbers = new ArrayList<>();

    public void roll(int pouredNumber) {
        pouredNumbers.add(pouredNumber);
    }

    public int scoring() {
        return pouredNumbers.stream().mapToInt(number -> number).sum();
    }
}
