package educative.codinginterviewpatterns.cyclicsort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindAllMissingNumsTest {
  FindAllMissingNums findAllMissingNums = new FindAllMissingNums();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] inputArr, List<Integer> expected) {
    var actual = findAllMissingNums.solution(inputArr);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{2, 3, 1, 8, 2, 3, 5, 1}, List.of(4, 6, 7)),
        arguments(new int[]{2, 4, 1, 2}, List.of(3)),
        arguments(new int[]{2, 3, 2, 1}, List.of(4)),
        arguments(new int[]{2, 3, 1, 8, 3, 3, 5, 1}, List.of(4, 6, 7))
    );
  }
}
