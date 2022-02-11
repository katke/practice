package educative.codinginterviewpatterns.twoheaps;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SubarrayMediansTest {
  SubarrayMedians subarrayMedians = new SubarrayMedians();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] nums, int k, double[] expected) {
    var actual = subarrayMedians.solution(nums, k);
    System.out.println("expected: " + Arrays.toString(expected));
    System.out.println("actual: " + Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{1, 2, -1, 3, 5}, 2, new double[]{1.5, 0.5, 1.0, 4.0}),
        arguments(new int[]{1, 2, -1, 3, 5}, 3, new double[]{1.0, 2.0, 3.0})
    );
  }

}
