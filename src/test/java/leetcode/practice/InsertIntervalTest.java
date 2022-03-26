package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class InsertIntervalTest {
    InsertInterval clazz = new InsertInterval();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[][] intervals, int[] newInterval, int[][] expected) {
      System.out.print("INPUT: ");
      for (int[] pair : intervals) System.out.print(Arrays.toString(pair) + ", ");
      System.out.println(Arrays.toString(newInterval));
      var result = clazz.solution(intervals, newInterval);
      System.out.print("Actual:");
      for (int[] pair : result) System.out.print(Arrays.toString(pair) + ", ");
      System.out.print("Expected:");
      for (int[] pair : expected) System.out.print(Arrays.toString(pair) + ", ");
      assertArrayEquals(expected, result);
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[][]{new int[]{1,3},new int[]{6,9}},
              new int[]{2,5},
              new int[][]{new int[]{1,5},new int[]{6,9}}),
          arguments(new int[][]{new int[]{1,2},new int[]{3,5},new int[]{6,7},new int[]{8,10},new int[]{12,16}},
              new int[]{4,8},
              new int[][]{new int[]{1,2},new int[]{3,10},new int[]{12,16}}),
          arguments(new int[][]{new int[]{2,3},new int[]{6,9}},
              new int[]{0,1},
              new int[][]{new int[]{0,1},new int[]{2,3},new int[]{6,9}}),
          arguments(new int[][]{new int[]{2,3},new int[]{6,9}},
              new int[]{10,14},
              new int[][]{new int[]{2,3},new int[]{6,9},new int[]{10,14}})
      );
    }

  }
