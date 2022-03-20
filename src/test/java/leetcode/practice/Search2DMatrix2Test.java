package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Search2DMatrix2Test {
  Search2DMatrix2 clazz = new Search2DMatrix2();

  @ParameterizedTest
  @MethodSource("testcases")
  void testSolution(int[][] input, int target, boolean expected) {
    assertEquals(expected, clazz.binarySearchSolution(input, target));
  }

  @ParameterizedTest
  @MethodSource("testcases")
  void testOptimizedSolution(int[][] input, int target, boolean expected) {
    assertEquals(expected, clazz.solution(input, target));
  }

  static Stream<Arguments> testcases() {
    return Stream.of(
        testCase1(),
        testCase2(),
        testCase3()
    );
  }

  static Arguments testCase1() {
    int[][] matrix = new int[][]{
        new int[]{1, 4, 7, 11, 15},
        new int[]{2, 5, 8, 12, 19},
        new int[]{3, 6, 9, 16, 22},
        new int[]{10, 13, 14, 17, 24},
        new int[]{18, 21, 23, 26, 30}
    };
    return arguments(matrix, 5, true);
  }

  static Arguments testCase2() {
    int[][] matrix = new int[][]{
        new int[]{1, 4, 7, 11, 15},
        new int[]{2, 5, 8, 12, 19},
        new int[]{3, 6, 9, 16, 22},
        new int[]{10, 13, 14, 17, 24},
        new int[]{18, 21, 23, 26, 30}
    };
    return arguments(matrix, 20, false);
  }

  static Arguments testCase3() {
    int[][] matrix = new int[][]{
        new int[]{-1,3}
    };
    return arguments(matrix, 3, true);
  }

}
