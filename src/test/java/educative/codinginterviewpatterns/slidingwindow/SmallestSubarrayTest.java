package educative.codinginterviewpatterns.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SmallestSubarrayTest {
  SmallestSubarray smallestSubarray = new SmallestSubarray();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int s, int[] arr, int expected) {
    var actual = smallestSubarray.findMinSubArray(s, arr);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(7, new int[]{2, 1, 5, 2, 3, 2}, 2),
        arguments(7, new int[]{2, 1, 5, 2, 8}, 1),
        arguments(8, new int[]{3, 4, 1, 1, 6}, 3),
        arguments(5, null, 0),
        arguments(40, new int[]{1, 2, 3, 20}, 0),
        arguments(2, new int[]{2, 4, 3, 20}, 1),
        arguments(6, new int[]{2, 1, 1, 1, 3, 1}, 4)
    );
  }
}
