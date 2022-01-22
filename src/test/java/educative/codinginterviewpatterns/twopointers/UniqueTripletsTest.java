package educative.codinginterviewpatterns.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UniqueTripletsTest {
  UniqueTriplets uniqueTriplets = new UniqueTriplets();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] arr, List<List<Integer>> expected) {
    System.out.println("Input: " + Arrays.toString(arr));
    var actual = uniqueTriplets.searchTriplets(arr);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[] {-3, 0, 1, 2, -1, 1, -2}, List.of(List.of(-3, 1, 2), List.of(-2, 0, 2), List.of(-2, 1, 1), List.of(-1, 0, 1))),
        arguments(new int[] {-5, 2, -1, -2, 3}, List.of(List.of(-5, 2, 3), List.of(-2, -1, 3))),
        arguments(new int[] {-4, 2, 0, 2, 0, -1, 0}, List.of(List.of(-4, 2, 2), List.of(0, 0, 0)))
    );
  }

}
