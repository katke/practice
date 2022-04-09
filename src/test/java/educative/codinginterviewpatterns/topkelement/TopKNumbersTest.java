package educative.codinginterviewpatterns.topkelement;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TopKNumbersTest {
    TopKNumbers clazz = new TopKNumbers();
    CustomAsserts customAsserts = new CustomAsserts();

    @ParameterizedTest(name = "Min Heap {index}")
    @MethodSource("testcases")
    void testMinHeapSolution(int[] nums, int k, List<Integer> expected) {
      customAsserts.assertListEquals(expected, clazz.minHeapSolution(nums, k));
    }

    @ParameterizedTest(name = "Max Heap {index}")
    @MethodSource("testcases")
    void testHeapSolution(int[] nums, int k, List<Integer> expected) {
      customAsserts.assertListEquals(expected, clazz.maxHeapSolution(nums, k));
    }

  @ParameterizedTest(name = "Brute force {index}")
  @MethodSource("testcases")
  void testBruteForceSolution(int[] nums, int k, List<Integer> expected) {
    customAsserts.assertListEquals(expected, clazz.bruteForceSolution(nums, k));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{3, 1, 5, 12, 2, 11}, 3, List.of(5,11,12)),
          arguments(new int[]{5, 12, 11, -1, 12}, 3, List.of(11,12,12)),
          arguments(new int[]{3, 1, 5, 12, 2, 11}, 5, List.of(2,3,5,11,12))
      );
    }

  }
