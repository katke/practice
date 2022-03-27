package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NumOfIslandsTest {
  NumOfIslands clazz = new NumOfIslands();

  @ParameterizedTest
  @MethodSource("testcases")
  void testSolution(char[][] grid, int expected) {
    assertEquals(expected, clazz.solution(grid));
  }

  static Stream<Arguments> testcases() {
    return Stream.of(
        testCase1(),
        testCase2()
    );
  }

  static Arguments testCase1() {
    var grid = new char[][]{
        new char[]{'1', '1', '1', '1', '0'},
        new char[]{'1', '1', '0', '1', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '0', '0', '0'}
    };
    return arguments(grid, 1);
  }

  static Arguments testCase2() {
    var grid = new char[][]{
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '1', '0', '0'},
        new char[]{'0', '0', '0', '1', '1'}
    };
    return arguments(grid, 3);
  }

}
