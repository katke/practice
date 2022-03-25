package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MergeIntervalsTest {
    MergeIntervals clazz = new MergeIntervals();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[][] input, int[][] expected) {
      var result = clazz.solution(input);
      System.out.print("Actual:");
      for (int[] pair : result) System.out.print(Arrays.toString(pair) + ", ");
      System.out.print("Expected:");
      for (int[] pair : expected) System.out.print(Arrays.toString(pair) + ", ");
      assertArrayEquals(expected, result);
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[][]{new int[]{1,3},new int[]{2,6},new int[]{8,10},new int[]{15,18}},
              new int[][]{new int[]{1,6},new int[]{8,10},new int[]{15,18}}),
          arguments(new int[][]{new int[]{1, 4}, new int[]{4, 5}}, new int[][]{new int[]{1,5}}),
          arguments(new int[][]{new int[]{3,4}, new int[]{1,2}, new int[]{6,7}}, new int[][]{new int[]{1,2}, new int[]{3,4}, new int[]{6,7}})
      );
    }

  }
