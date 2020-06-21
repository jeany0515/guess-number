package cn.xpbootcamp.tdd;

public class NumberGuess {
    private int size = 4;
    private int[] randomList;

    public NumberGuess(int size) {
        this.size = size;
        RandomNumber randomNumber = new RandomNumber();
        this.randomList = randomNumber.generate();
    }

    public String verify(int[] input) {
        System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwww");
        System.out.println(this.randomList[0]);
        System.out.println(this.randomList[1]);
        System.out.println(this.randomList[2]);
        System.out.println(this.randomList[3]);
        if (isLengthValidate(input) && !hasRepeatNumber(input)) {
            return getMatchResult(input);
        }
        return "Wrong Input，Input again";
    }

    private boolean isLengthValidate(int[] input) {
        return input.length == this.size;
    }

    private boolean hasRepeatNumber(int[] input) {
        boolean hasRepeat = false;
        for (int index = 0; index < this.size; index++) {
            for (int compare = index + 1; compare < this.size; compare++) {
                if(input[index] == input[compare]) hasRepeat= true;
            }
        }
        return hasRepeat;
    }

    private String getMatchResult(int[] input) {
        int numberMatchCount = 0;
        int bothNumberAndPositionMatchCount = 0;

        for (int compare = 0; compare < this.size; compare++) {
            for (int randomIndex = 0; randomIndex < this.size; randomIndex++) {
                boolean isNumberMatch = input[compare] == this.randomList[randomIndex];
                boolean isPositionMatch = compare == randomIndex;
                if(isNumberMatch && !isPositionMatch) numberMatchCount++;
                if(isNumberMatch && isPositionMatch) bothNumberAndPositionMatchCount++;
            }
        }

        return bothNumberAndPositionMatchCount + "A" + numberMatchCount + "B";
    }

}
