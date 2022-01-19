package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Search2DMatrixTest {
  Search2DMatrix search2DMatrix = new Search2DMatrix();

  @ParameterizedTest(name = "{index} Brute force, input {0}, target {1}")
  @MethodSource("testCases")
  void testBruteForceSolution(int[][] matrix, int target, boolean expected) {
    var actual = search2DMatrix.bruteForceSolution(matrix, target);
    assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "{index} Medium solution, input {0}, target {1}")
  @MethodSource("testCases")
  void testMedianSolution(int[][] matrix, int target, boolean expected) {
    var actual = search2DMatrix.medianSolution(matrix, target);
    assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "{index} Optimized, input {0}, target {1}")
  @MethodSource("testCases")
  void testOptimizedSolution(int[][] matrix, int target, boolean expected) {
    var actual = search2DMatrix.optimizedSolution(matrix, target);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(lcTestCase1(), 3, true),
        arguments(onlyOneRow(), 31, true),
        arguments(targetExceedsAllRows(), 71, false),
        arguments(targetIsLastInt(), 150, true),
        arguments(targetIsLFirstInt(), 21, true),
        arguments(noMatch(), 66, false),
        arguments(targetLessThanAllRows(), 9, false)
    );
  }

  private static int[][] lcTestCase1() {
    int[] row1 = new int[]{1, 3, 5, 7};
    int[] row2 = new int[]{10, 11, 16, 20};
    int[] row3 = new int[]{23, 30, 34, 60};
    return new int[][]{
        row1,
        row2,
        row3
    };
  }

  private static int[][] onlyOneRow() {
    int[] row1 = new int[]{1, 30, 31, 37};
    return new int[][]{
        row1
    };
  }

  private static int[][] targetExceedsAllRows() {
    int[] row1 = new int[]{1, 2, 3, 4};
    int[] row2 = new int[]{19, 20, 30, 60};
    int[] row3 = new int[]{61, 62, 64, 70};
    return new int[][]{
        row1,
        row2,
        row3
    };
  }

  private static int[][] targetLessThanAllRows() {
    int[] row1 = new int[]{10, 12, 13, 14};
    int[] row2 = new int[]{19, 20, 30, 60};
    int[] row3 = new int[]{61, 62, 64, 70};
    return new int[][]{
        row1,
        row2,
        row3
    };
  }

  private static int[][] targetIsLastInt() {
    int[] row1 = new int[]{100};
    int[] row2 = new int[]{101};
    int[] row3 = new int[]{150};
    return new int[][]{
        row1,
        row2,
        row3
    };
  }

  private static int[][] targetIsLFirstInt() {
    int[] row1 = new int[]{21, 25, 31, 33, 37, 40};
    int[] row2 = new int[]{50, 51, 55, 60, 61, 65};
    int[] row3 = new int[]{78, 79, 80, 90, 100, 102};
    return new int[][]{
        row1,
        row2,
        row3
    };
  }

  private static int[][] noMatch() {
    int[] row1 = new int[]{1, 2, 3, 4, 5, 6};
    int[] row2 = new int[]{15, 17, 20, 60, 61, 65};
    int[] row3 = new int[]{78, 79, 90, 97, 100, 102};
    return new int[][]{
        row1,
        row2,
        row3
    };
  }
}
