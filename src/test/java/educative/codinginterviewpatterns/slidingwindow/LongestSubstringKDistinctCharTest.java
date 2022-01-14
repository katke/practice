package educative.codinginterviewpatterns.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestSubstringKDistinctCharTest {
  LongestSubstringKDistinctChar longestSubstringKDistinctChar = new LongestSubstringKDistinctChar();

  @ParameterizedTest(name = "{index}: Input: {0}, k: {1}")
  @MethodSource("testCases")
  void testSolution(String input, int k, int expected) {
    var actual = longestSubstringKDistinctChar.solution(input, k);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("araaci", 2, 4),
        arguments("araaci", 1, 2),
        arguments("cbbebi", 3, 5),
        arguments("cbbebi", 10, 6),
        arguments("", 1, 0)
    );
  }

}
