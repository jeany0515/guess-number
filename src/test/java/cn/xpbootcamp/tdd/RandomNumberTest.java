package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    void should_return_no_item_repeat_random_list_when_generate_random_list_given_list_size_is_4() {
        RandomNumber randomNumber = new RandomNumber();
        int[] result = randomNumber.generate();

        for (int randomIndex = 0; randomIndex < 4; randomIndex++) {
            for (int compareIndex = randomIndex+1; compareIndex < 4; compareIndex++) {
                assertThat(result[randomIndex]).isNotEqualTo(result[compareIndex]);
            }
        }
    }

    @Test
    void should_return_different_random_list_when_generate_two_random_list_given_each_list_size_is_4() {
        RandomNumber randomNumber_1 = new RandomNumber();
        int[] result_1 = randomNumber_1.generate();

        RandomNumber randomNumber_2 = new RandomNumber();
        int[] result_2 = randomNumber_2.generate();

        assertThat(result_1).isNotEqualTo(result_2);
    }
}