package com.stack.bowling;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class KataBowlingTest {

    KataBowlingImpl kataBowling = new KataBowlingImpl();

    @Test
    public void rollLoserGame(){
        rollMany(19, 0);
        assertScore(0);
    }

    private void assertScore(int expectedScore) {
        assertEquals(kataBowling.score(), expectedScore);
    }

    private void rollMany(int rolls, int pins){
         IntStream.rangeClosed(0, rolls).boxed().forEach(p -> kataBowling.roll(pins));
     }

    @Test
    public void rollWinnerGame(){
        rollMany(12, 10);
        assertScore(300);
    }

    @Test
    public void rollAllSpareGame(){
        rollMany(20, 5);
        assertScore(150);
    }

    @Test
    public void rollAllOnesGame(){
        rollMany(19, 1);
        assertScore(20);
    }

    @Test
    public void rollOneStrikeGame() {
        singleRoll(10);
        singleRoll(1);
        singleRoll(8);
        rollMany(16, 0);
        assertScore(28);
    }

    private void singleRoll(int pins) {
        kataBowling.roll(pins);
    }


}
