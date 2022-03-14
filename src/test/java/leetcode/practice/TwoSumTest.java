package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TwoSumTest {
    TwoSum clazz = new TwoSum();

    @ParameterizedTest(name = "Optimized {index}")
    @MethodSource("testcases")
    void testSolution(int[] input, int target, int[] expected) {
      assertArrayEquals(expected, clazz.solution(input, target));
    }

  @ParameterizedTest(name = "Brute force {index}")
  @MethodSource("testcases")
  void testBruteForceSolution(int[] input, int target, int[] expected) {
    assertArrayEquals(expected, clazz.bruteForceSolution(input, target));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{2,7,11,15}, 9, new int[]{0,1}),
          arguments(new int[]{3,2,4}, 6, new int[]{1,2}),
          arguments(new int[]{3,3}, 6, new int[]{0,1})
      );
    }

  }
