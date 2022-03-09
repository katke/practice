package educative.codinginterviewpatterns.topologicalsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TaskSchedulingTest {
  TaskScheduling taskScheduling = new TaskScheduling();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int numTasks, int[][] taskPrereqs, boolean expected) {
    assertEquals(expected, taskScheduling.solution(numTasks, taskPrereqs));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}}, true),
        arguments(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}}, false),
        arguments(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4}, new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}}, true)
    );
  }
}
