package com.stack.bowling;

public class KataBowlingImpl implements KataBowling {

    Integer[] rolls = new Integer[21];
    int counter = 0;
    int score = 0;
    int frame = 0;


    @Override
    public void roll(int pins) {
        rolls[counter++] = pins;
    }

    @Override
    public int score() {

        int frameIndex = 0;

        for (frame = 0; frame < 10; frame++) {
            if(strike(rolls[frameIndex])){
                scoreStrike(frameIndex);
                frameIndex++;
            } else if(spare(frameIndex)){
                scoreSpare(frameIndex);
                frameIndex +=2;
            } else {
                scoreNormal(frameIndex);
                frameIndex +=2;
            }
        }

        return score;
    }

    private void scoreNormal(int frameIndex) {
        score += rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private void scoreSpare(int frameIndex) {
        score += rolls[frameIndex + 2] + 10;
    }

    private boolean spare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex +1] == 10;
    }

    private void scoreStrike(int frameIndex) {
        score += rolls[frameIndex+1] + rolls[frameIndex + 2] +  10;
    }

    private boolean strike(Integer roll) {
        return roll == 10;
    }
}
