package cn.xpbootcamp.tdd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @Test
    void should_return_no_item_repeat_random_list_when_generate_random_list_given_list_size_is_4() {
        RandomGenerator randoms = new RandomGenerator();
        int[] result = randoms.generate();

        List<Integer> resultList = Arrays.stream(result).boxed().collect(Collectors.toList());
        List<Integer> expected = Arrays.stream(result).boxed().distinct().collect(Collectors.toList());

        assertThat(resultList).isEqualTo(expected);
    }

    @Test
    void should_return_no_item_repeat_random_list_when_generate_random_list() {
        RandomGenerator randoms = new RandomGenerator();
        int[] result = randoms.generate();

        List<Integer> resultList = Arrays.stream(result).boxed().collect(Collectors.toList());
        List<Integer> expected = Arrays.stream(result).boxed().distinct().collect(Collectors.toList());

        assertThat(resultList).isEqualTo(expected);
    }

    @Test
    void should_return_different_random_list_when_generate_two_random_list_given_each_list_size_is_4() {
        RandomGenerator randomNumber_1 = new RandomGenerator();
        int[] result_1 = randomNumber_1.generate();

        RandomGenerator randomNumber_2 = new RandomGenerator();
        int[] result_2 = randomNumber_2.generate();

        assertThat(result_1).isNotEqualTo(result_2);
    }

}