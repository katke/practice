package educative.codinginterviewpatterns.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TripletWithSumNearTargetTest {
  TripletWithSumNearTarget tripletWithSumNearTarget = new TripletWithSumNearTarget();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] inputArr, int inputTarget, int expected) {
    var actual = tripletWithSumNearTarget.searchTriplet(inputArr, inputTarget);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[] {-2, 0, 1, 2}, 2, 1),
        arguments(new int[] {-3, -1, 1, 2}, 1, 0),
        arguments(new int[]  {1, 0, 1, 1}, 100, 3),
        arguments(new int[]  {-2, 10, 4, 6, -1}, 12, 12),
        arguments(new int[]  {-2, 20, -10, 4, -1, 60}, 100, 84),
        arguments(new int[]  {-2, 20, -10, 4, -1, 60}, -5, -7)
    );
  }
}
