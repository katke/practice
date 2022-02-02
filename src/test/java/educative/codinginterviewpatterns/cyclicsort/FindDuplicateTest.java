package educative.codinginterviewpatterns.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindDuplicateTest {
  FindDuplicate findDuplicate = new FindDuplicate();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] inputNums, int expected) {
    var actual = findDuplicate.solution(inputNums);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{1, 4, 4, 3, 2}, 4),
        arguments(new int[]{2, 1, 3, 3, 5, 4}, 3),
        arguments(new int[]{2, 4, 1, 4, 4}, 4),
        arguments(new int[]{1, 1}, 1),
        arguments(new int[]{2, 5, 1, 4, 5, 5}, 5)
    );
  }
}
