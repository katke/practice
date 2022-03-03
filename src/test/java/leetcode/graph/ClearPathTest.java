package leetcode.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ClearPathTest {
  ClearPath clearPath = new ClearPath();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[][] graph, int expected) {
    assertEquals(expected, clearPath.shortestPathBinaryMatrix(graph));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[][]{new int[]{0, 1}, new int[]{1, 0}}, 2),
        arguments(new int[][]{new int[]{0, 0, 0}, new int[]{1, 1, 0}, new int[]{1, 1, 0}}, 4),
        arguments(new int[][]{new int[]{1, 0, 0}, new int[]{1, 1, 0}, new int[]{1, 1, 0}}, -1)
    );
  }
}
