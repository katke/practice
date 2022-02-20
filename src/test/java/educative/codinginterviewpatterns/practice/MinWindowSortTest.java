package educative.codinginterviewpatterns.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MinWindowSortTest {
  MinWindowSort minWindowSort = new MinWindowSort();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] arr, int expected) {
    var actual = minWindowSort.solution(arr);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{1, 2, 5, 3, 7, 10, 9, 12}, 5),
        arguments(new int[]{1, 3, 2, 0, -1, 7, 10}, 5),
        arguments(new int[]{1, 2, 3}, 0),
        arguments(new int[]{3, 2, 1}, 3)
    );
  }
}
