package educative.codinginterviewpatterns.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortInPlaceTest {
  SortInPlace sortInPlace = new SortInPlace();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] input, int[] expected) {
    sortInPlace.solution(input);
    assertArrayEquals(expected, input);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{3, 1, 5, 4, 2}, new int[] {1, 2, 3, 4, 5}),
        arguments(new int[]{2, 6, 4, 3, 1, 5}, new int[]{1, 2, 3, 4, 5, 6}),
        arguments(new int[]{1, 5, 6, 4, 3, 2}, new int[]{1, 2, 3, 4, 5, 6})
    );
  }
}
