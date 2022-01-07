package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AllPathsSourceToTargetTest {

  AllPathsSourceToTarget allPathsSourceToTarget = new AllPathsSourceToTarget();

  @ParameterizedTest
  @MethodSource("generateTestInput")
  void testSolution(String description, int[][] input, List<List<Integer>> expected) {
    System.out.println(description);
    var actual = allPathsSourceToTarget.solution(input);
    assertEquals(expected.size(), actual.size());
    for (var i = 0; i < expected.size(); i++) {
      var expectedPath = expected.get(i);
      var actualPath = actual.get(i);
      assertEquals(expectedPath, actualPath);
    }
  }

  private static Stream<Arguments> generateTestInput() {
    return Stream.of(
        arguments("Expecting 2 paths, [[0,1,3],[0,2,3]]", lcExample1(), List.of(List.of(0,1,3), List.of(0,2,3))),
        arguments("Expecting 5 paths, [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]", lcExample2(),
            List.of(List.of(0,4), List.of(0,3,4), List.of(0,1,3,4), List.of(0,1,2,3,4), List.of(0,1,4))),
        arguments("Expecting 1 path, [[0,1]]", lcExample3(), List.of(List.of(0,1))),
        arguments("Expecting 3 paths, [[0,1,2,3],[0,2,3],[0,3]]", lcExample4(),
            List.of(List.of(0,1,2,3), List.of(0,2,3), List.of(0,3))),
        arguments("Expecting 2 paths, [[0,1,2,3],[0,3]]", lcExample5(), List.of(List.of(0,1,2,3), List.of(0,3))),
        arguments("Graph With Non-Target Deadend, expecting 1 path, [[0,1,3,5,6]]", graphWithNonTargetDeadend(),
            List.of(List.of(0,1,3,5,6)))
    );
  }

  private static int[][] graphWithNonTargetDeadend() {
    return new int[][] {
        {1, 2},
        {3},
        {4},
        {5},
        {},
        {6},
        {}
    };
  }

  private static int[][] lcExample5() {
    return new int[][] {
        {1, 3},
        {2},
        {3},
        {}
    };
  }

  private static int[][] lcExample4() {
    return new int[][] {
        {1, 2, 3},
        {2},
        {3},
        {}
    };
  }

  private static int[][] lcExample3() {
    return new int[][] {
        {1},
        {}
    };
  }

  private static int[][] lcExample2() {
    return new int[][] {
        {4, 3, 1},
        {3, 2, 4},
        {3},
        {4},
        {}
    };
  }

  private static int[][] lcExample1() {
    return new int[][] {
        {1, 2},
        {3},
        {3},
        {}
    };
  }

}
