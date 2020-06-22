package cn.xpbootcamp.tdd;

import java.security.SecureRandom;

public class RandomGenerator {
    private final int size = 4;
    int[] randomList = new int[size];
    private SecureRandom secureRandom = new SecureRandom();

    public int[] generate() {
        for (int randomIndex = 0; randomIndex < size; randomIndex++) {
            this.randomList[randomIndex] = generateAndValidate(randomIndex);
        }

        return this.randomList;
    }

    private int generateAndValidate(int size) {
        boolean isRepeat = false;
        int randomNumber = secureRandom.nextInt(10);
        for (int randomIndex = 0; randomIndex < size; randomIndex++) {
            if (randomNumber == this.randomList[randomIndex]) {
                isRepeat = true;
                break;
            }
        }

        if (isRepeat) {
            randomNumber = this.generateAndValidate(size);
        }
        return randomNumber;
    }
}