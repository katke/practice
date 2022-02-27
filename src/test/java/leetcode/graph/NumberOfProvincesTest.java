package leetcode.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NumberOfProvincesTest {
  NumberOfProvinces numberOfProvinces = new NumberOfProvinces();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[][] input, int expected) {
    assertEquals(expected, numberOfProvinces.findNumProvincesBFS(input));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 1}}, 2),
        arguments(new int[][]{new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{0, 0, 1}}, 3),
        arguments(new int[][]{
            new int[]{1, 1, 0, 0, 0, 0},
            new int[]{1, 1, 0, 0, 0, 0},
            new int[]{0, 0, 1, 1, 1, 0},
            new int[]{0, 0, 1, 1, 0, 0},
            new int[]{0, 0, 1, 0, 1, 0},
            new int[]{0, 0, 0, 0, 0, 1}}, 3)
    );
  }
}
