package cn.xpbootcamp.tdd;

import java.security.SecureRandom;

public class RandomNumber {
    int[] randomList = new int[4];
    private SecureRandom secureRandom = new SecureRandom();

    public int[] generate() {
        for (int randomIndex = 0; randomIndex < 4; randomIndex++) {
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
