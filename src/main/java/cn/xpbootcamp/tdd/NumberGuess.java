package cn.xpbootcamp.tdd;

public class NumberGuess {
    private int randomSize;
    private int[] randomList;

    public NumberGuess(int[] randomList) {
        this.randomSize = randomList.length;
        this.randomList = randomList;
    }

    public String verify(int[] input) {
        if (isLengthValidate(input) && !hasRepeatNumber(input)) {
            return getMatchResult(input);
        }
        return "Wrong Input，Input again";
    }

    private boolean isLengthValidate(int[] input) {
        return input.length == this.randomSize;
    }

    private boolean hasRepeatNumber(int[] input) {
        boolean hasRepeat = false;
        for (int index = 0; index < this.randomSize; index++) {
            for (int compare = index + 1; compare < this.randomSize; compare++) {
                if(input[index] == input[compare]) hasRepeat= true;
            }
        }
        return hasRepeat;
    }

    private String getMatchResult(int[] input) {
        int numberMatchCount = 0;
        int bothNumberAndPositionMatchCount = 0;

        for (int compare = 0; compare < this.randomSize; compare++) {
            for (int randomIndex = 0; randomIndex < this.randomSize; randomIndex++) {
                boolean isNumberMatch = input[compare] == this.randomList[randomIndex];
                boolean isPositionMatch = compare == randomIndex;
                if(isNumberMatch && !isPositionMatch) numberMatchCount++;
                if(isNumberMatch && isPositionMatch) bothNumberAndPositionMatchCount++;
            }
        }

        return bothNumberAndPositionMatchCount + "A" + numberMatchCount + "B";
    }

}
