package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {

    @Test
    void should_return_0_when_scoring_given_every_roll_is_0() {
        BowlingGame bowlingGame = new BowlingGame();

        for (int rollIndex = 0; rollIndex < 20; rollIndex++) {
            bowlingGame.roll(0);
        }

        int score = bowlingGame.scoring();

        assertThat(score).isEqualTo(0);
    }
}
