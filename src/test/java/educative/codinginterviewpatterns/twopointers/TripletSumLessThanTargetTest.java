package educative.codinginterviewpatterns.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TripletSumLessThanTargetTest {
  TripletSumLessThanTarget tripletSumLessThanTarget = new TripletSumLessThanTarget();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] inputArr, int inputTarget, int expected) {
    var actual = tripletSumLessThanTarget.searchTriplets(inputArr, inputTarget);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{-1, 0, 2, 3}, 3, 2),
        arguments(new int[]{-1, 4, 2, 1, 3}, 5, 4),
        arguments(new int[]{-2, 20, -10, 4, -1, 60}, 100, 20),
        arguments(new int[]{-2, 20, -10, 4, -1, 60}, -1, 3)
    );
  }
}
