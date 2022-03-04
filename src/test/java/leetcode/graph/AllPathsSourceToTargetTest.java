package leetcode.graph;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AllPathsSourceToTargetTest {
  AllPathsSourceToTarget allPathsSourceToTarget = new AllPathsSourceToTarget();
  CustomAsserts customAsserts = new CustomAsserts();

  @ParameterizedTest(name = "BFS {index}")
  @MethodSource("testCases")
  void testBFSSolution(int[][] graph, List<List<Integer>> expected) {
    customAsserts.assertListEquals(expected, allPathsSourceToTarget.allPathsSourceTargetBfs(graph));
  }

  @ParameterizedTest(name = "DFS {index}")
  @MethodSource("testCases")
  void testDFSSolution(int[][] graph, List<List<Integer>> expected) {
    customAsserts.assertListEquals(expected, allPathsSourceToTarget.allPathsSourceTargetDFS(graph));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[][]{new int[]{1, 2}, new int[]{3}, new int[]{3}, new int[]{}},
            List.of(List.of(0, 1, 3), List.of(0, 2, 3))),
        arguments(new int[][]{new int[]{4, 3, 1}, new int[]{3, 2, 4}, new int[]{3}, new int[]{4}, new int[]{}},
            List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4), List.of(0, 1, 4)))
    );
  }
}
