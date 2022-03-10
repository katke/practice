package educative.codinginterviewpatterns.topologicalsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TaskSchedulingOrderTest {
  TaskSchedulingOrder taskSchedulingOrder = new TaskSchedulingOrder();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int tasks, int[][] edgeList, List<Integer> expected) {
    assertEquals(expected, taskSchedulingOrder.solution(tasks, edgeList));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}}, List.of(0, 1, 2)),
        arguments(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}}, List.of()),
    arguments(6, new int[][]{
        new int[] {2, 5}, new int[] {0, 5}, new int[] {0, 4}, new int[] {1, 4}, new int[] {3, 2}, new int[] {1, 3}},
        List.of(0, 1, 3, 4, 2, 5))
    );
  }
}
