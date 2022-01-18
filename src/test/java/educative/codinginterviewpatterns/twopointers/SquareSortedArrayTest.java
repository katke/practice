package educative.codinginterviewpatterns.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SquareSortedArrayTest {
  SquareSortedArray squareSortedArray = new SquareSortedArray();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] arr, int[] expected) {
    var actual = squareSortedArray.makeSquares(arr);
    assertArrayEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[] {-2, -1, 0, 2, 3}, new int[]{0, 1, 4, 4, 9}),
        arguments(new int[] {-3, -1, 0, 1, 2}, new int[]{0, 1, 1, 4, 9})
    );
  }
}
