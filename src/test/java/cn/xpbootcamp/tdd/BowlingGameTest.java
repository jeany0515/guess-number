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
        rolls(0, 20);
        assertThat(bowlingGame.scoring()).isEqualTo(0);
    }

    @Test
    void should_sum_all_rolls_when_scoring_given_every_roll_is_common_as_3() {
        rolls(3, 20);
        assertThat(bowlingGame.scoring()).isEqualTo(60);
    }

    @Test
    void should_involve_SPARE_bonus_when_scoring_given_one_SPARE_occurs() {
        bowlingGame.roll(6);
        bowlingGame.roll(4);

        rolls(3, 18);
        assertThat(bowlingGame.scoring()).isEqualTo(67);
    }

    @Test
    void should_involve_STRIKE_bonus_when_scoring_given_one_STRIKE_occurs() {
        bowlingGame.roll(10);

        rolls(3, 18);
        assertThat(bowlingGame.scoring()).isEqualTo(70);
    }


    private void rolls(int score,int times) {
        for (int rollIndex = 0; rollIndex < times; rollIndex++) {
            bowlingGame.roll(score);
        }
    }
}
