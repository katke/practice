package educative.codinginterviewpatterns.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DutchNationalFlagTest {
  DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] input, int[] expected) {
    dutchNationalFlag.solution(input);
    System.out.println("expected: " + Arrays.toString(expected));
    System.out.println("actual: " + Arrays.toString(input));
    assertArrayEquals(expected, input);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{1, 0, 2, 1, 0}, new int[]{0, 0, 1, 1, 2}),
        arguments(new int[]{2, 2, 0, 1, 2, 0}, new int[]{0, 0, 1, 2, 2, 2})
    );
  }
}
