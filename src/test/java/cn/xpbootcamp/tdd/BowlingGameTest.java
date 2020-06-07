package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {
    private BowlingGame bowlingGame;

    @BeforeEach
    void setup() {
        bowlingGame = new BowlingGame();
    }

    @Test
    void should_return_0_when_scoring_given_every_roll_is_0() {
        rolls(0);
        assertThat(bowlingGame.scoring()).isEqualTo(0);
    }

    @Test
    void should_sum_all_rolls_when_scoring_given_every_roll_is_common_as_3() {
        rolls(3);
        assertThat(bowlingGame.scoring()).isEqualTo(60);
    }

    private void rolls(int score) {
        for (int rollIndex = 0; rollIndex < 20; rollIndex++) {
            bowlingGame.roll(score);
        }
    }
}
