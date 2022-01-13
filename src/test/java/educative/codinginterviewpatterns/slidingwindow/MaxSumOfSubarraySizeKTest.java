package educative.codinginterviewpatterns.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MaxSumOfSubarraySizeKTest {
  MaxSumOfSubarraySizeK maxSumOfSubarraySizeK = new MaxSumOfSubarraySizeK();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int k, int[] arr, int expected) {
    var actual = maxSumOfSubarraySizeK.findMaxSumSubArray(k, arr);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(3, new int[]{2, 1, 5, 1, 3, 2}, 9),
        arguments(2, new int[]{2, 3, 4, 1, 5}, 7),
        arguments(1, new int[]{2, 3, 4, 1, 5}, 5),
        arguments(5, null, 0), // arr is null
        arguments(7, new int[]{1, 2, 3, 4, 5}, 15), // # of arr items is < k
        arguments(2, new int[]{2, 3, 4, 9, 5}, 14), // max sum at end
        arguments(2, new int[]{9, 5, 2, 3, 4}, 14) // max sum at beginning
    );
  }

}
