package cn.xpbootcamp.tdd;

import java.util.Arrays;

public class GuessNumberValidator {
    public boolean verify(int[] guessNumber) {
        boolean isLengthValidate = guessNumber.length == 4;

        if (isLengthValidate) {
            boolean hasRepeat = Arrays.stream(guessNumber).boxed().distinct().count() < 4;
            return !hasRepeat;
        }
       return false;
    }
}
