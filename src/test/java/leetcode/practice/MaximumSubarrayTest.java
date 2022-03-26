package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MaximumSubarrayTest {
    MaximumSubarray clazz = new MaximumSubarray();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] input, int expected) {
      assertEquals(expected, clazz.solution(input));
    }

  @ParameterizedTest
  @MethodSource("testcases")
  void testDAndCSolution(int[] input, int expected) {
    assertEquals(expected, clazz.divideAndConquerSolution(input));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
          arguments(new int[]{1}, 1),
          arguments(new int[]{5,4,-1,7,8}, 23),
          arguments(new int[]{-2,1}, 1),
          arguments(new int[]{-2,-3,-1}, -1)
      );
    }

  }
