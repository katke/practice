package educative.codinginterviewpatterns.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestSubarrayOf1sTest {
  LongestSubarrayOf1s longestSubarrayOf1s = new LongestSubarrayOf1s();

  @ParameterizedTest(name = "{index}: Arr = {0}, k = {1}")
  @MethodSource("testCases")
  void testSolution(int[] arr, int k, int expected) {
    var actual = longestSubarrayOf1s.findLength(arr, k);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2, 6),
        arguments(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3, 9),
        arguments(new int[]{0}, 2, 1),
        arguments(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}, 1, 6),
        arguments(new int[]{0, 1, 1, 0, 1, 0, 0}, 4, 7)
    );
  }
}
