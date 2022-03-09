package educative.codinginterviewpatterns.topologicalsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindVertexOrderTest {
  FindVertexOrder findVertexOrder = new FindVertexOrder();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int vertices, int[][] edges, List<List<Integer>> expected) {
    var actual = findVertexOrder.solution(vertices, edges);
    System.out.println("actual: " + actual);
    System.out.println("expected: " + expected);
    assertTrue(expected.contains(actual));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(4, new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}},
            List.of(List.of(3, 2, 0, 1),
                List.of(3, 2, 1, 0))),
        arguments(7, new int[][]{
                new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3}, new int[]{5, 4}, new int[]{3, 0},
                new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}},
            List.of(List.of(5, 6, 3, 4, 0, 1, 2),
                List.of(6, 5, 3, 4, 0, 1, 2),
                List.of(5, 6, 4, 3, 0, 2, 1),
                List.of(6, 5, 4, 3, 0, 1, 2),
                List.of(5, 6, 3, 4, 0, 2, 1),
                List.of(5, 6, 3, 4, 1, 2, 0))),
        arguments(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0}, new int[]{2, 1}, new int[]{3, 1}},
            List.of(List.of(4, 2, 3, 0, 1),
                List.of(4, 3, 2, 0, 1),
                List.of(4, 3, 2, 1, 0),
                List.of(4, 2, 3, 1, 0),
                List.of(4, 2, 0, 3, 1)))
    );
  }
}
