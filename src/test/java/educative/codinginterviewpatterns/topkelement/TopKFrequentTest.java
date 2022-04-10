package educative.codinginterviewpatterns.topkelement;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TopKFrequentTest {
    TopKFrequent clazz = new TopKFrequent();
    CustomAsserts customAsserts = new CustomAsserts();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] nums, int k, List<Integer> expected) {
      customAsserts.assertListEquals(expected, clazz.solution(nums, k));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{1, 3, 5, 12, 11, 12, 11}, 2, List.of(12,11)),
          arguments(new int[]{5, 12, 11, 3, 11, 3}, 2, List.of(3,11)),
          arguments(new int[]{-5, 11, 12, 11, 13, 3, -5, 13, -5}, 3, List.of(-5,13, 11))
      );
    }

  }
