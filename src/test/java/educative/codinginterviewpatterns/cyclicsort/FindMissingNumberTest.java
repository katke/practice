package educative.codinginterviewpatterns.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindMissingNumberTest {
  FindMissingNumber findMissingNumber = new FindMissingNumber();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] inputNums, int expected) {
    var actual = findMissingNumber.solution(inputNums);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{4, 0, 3, 1}, 2),
        arguments(new int[]{8, 3, 5, 2, 4, 6, 0, 1}, 7),
        arguments(new int[]{1}, 0)
    );
  }
}
