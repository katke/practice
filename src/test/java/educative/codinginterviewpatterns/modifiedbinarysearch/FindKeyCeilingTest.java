package educative.codinginterviewpatterns.modifiedbinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindKeyCeilingTest {
  FindKeyCeiling findKeyCeiling = new FindKeyCeiling();

  @ParameterizedTest(name = "Recursive test case {index}")
  @MethodSource("testCases")
  void testSolution(int[] inputArr, int key, int expected) {
    var actual = findKeyCeiling.solution(inputArr, key);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "Iterative test case {index}")
  @MethodSource("testCases")
  void testIterativeSolution(int[] inputArr, int key, int expected) {
    var actual = findKeyCeiling.iterativeSolution(inputArr, key);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{4, 6, 10}, 6, 1),
        arguments(new int[]{1, 3, 8, 10, 15}, 12, 4),
        arguments(new int[]{4, 6, 10}, 17, -1),
        arguments(new int[]{4, 6, 10}, -1, 0),
        arguments(new int[]{}, 5, -1),
        arguments(null, 1, -1),
        arguments(new int[]{1, 3, 8, 10, 15, 28, 35}, 36, -1),
        arguments(new int[]{1, 3, 8, 10, 15, 28, 35}, 27, 5)
    );
  }
}
