package educative.codinginterviewpatterns.modifiedbinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OrderAgnosticFindKeyTest {
  OrderAgnosticFindKey orderAgnosticFindKey = new OrderAgnosticFindKey();

  @ParameterizedTest(name = "Recursive test case {index}")
  @MethodSource("testCases")
  void testSolution(int[] inputArr, int key, int expected) {
    var actual = orderAgnosticFindKey.solution(inputArr, key);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "Iterative test case {index}")
  @MethodSource("testCases")
  void testIterativeSolution(int[] inputArr, int key, int expected) {
    var actual = orderAgnosticFindKey.iterativeSolution(inputArr, key);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{4, 6, 10}, 10, 2),
        arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 5, 4),
        arguments(new int[]{1, 2, 3, 4, 6, 9, 15}, 5, -1),
        arguments(new int[]{10, 6, 4}, 10, 0),
        arguments(new int[]{10, 6, 6, 4}, 10, 0),
        arguments(new int[]{10, 6, 4}, 4, 2),
        arguments(new int[]{}, 5, -1),
        arguments(null, 1, -1),
        arguments(new int[]{4, 4, 4, 4, 4, 2}, 2, 5)
    );
  }
}
