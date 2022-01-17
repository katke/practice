package educative.codinginterviewpatterns.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArrayPairSumEqualsTargetTest {
  ArrayPairSumEqualsTarget arrayPairSumEqualsTarget = new ArrayPairSumEqualsTarget();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] arr, int targetSum, int[] expected) {
    var actual = arrayPairSumEqualsTarget.search(arr, targetSum);
    assertArrayEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[] {1, 2, 3, 4, 6}, 6, new int[]{1, 3}),
        arguments(new int[]{2, 5, 9, 11}, 11, new int[]{0, 2}),
        arguments(new int[] {1, 3, 10, 12, 13}, 12, new int[] {-1, -1}),
        arguments(new int[] {1, 3, 10, 14, 16}, 13, new int[] {1, 2}),
        arguments(new int[] {1, 3, 10, 14, 16}, 24, new int[] {2, 3}),
        arguments(new int[] {1, 3, 10, 14, 16}, 4, new int[] {0, 1}),
        arguments(new int[] {1, 3, 10, 14, 16}, 30, new int[] {3, 4})
    );
  }
}
