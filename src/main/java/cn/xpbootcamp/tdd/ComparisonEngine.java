package cn.xpbootcamp.tdd;

public class ComparisonEngine {
    public String compare(int[] guessNumber, int[] randoms) {
        int numberMatchCount = 0;
        int bothNumberAndPositionMatchCount = 0;

        for (int compare = 0; compare < guessNumber.length; compare++) {
            for (int randomIndex = 0; randomIndex < randoms.length; randomIndex++) {
                boolean isNumberMatch = guessNumber[compare] == randoms[randomIndex];
                boolean isPositionMatch = compare == randomIndex;
                if(isNumberMatch && !isPositionMatch) numberMatchCount++;
                if(isNumberMatch && isPositionMatch) bothNumberAndPositionMatchCount++;
            }
        }

        return bothNumberAndPositionMatchCount + "A" + numberMatchCount + "B";
    }
}
