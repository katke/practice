package educative.codinginterviewpatterns.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestUniqueCharSubstringTest {
  LongestUniqueCharSubstring longestUniqueCharSubstring = new LongestUniqueCharSubstring();

  @ParameterizedTest(name = "{index}: Input: {0}")
  @MethodSource("testCases")
  void testSolution(String input, int expected) {
    var actual = longestUniqueCharSubstring.findLength(input);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("aabccbb", 3),
        arguments("abbbb", 2),
        arguments("abccde", 3),
        arguments("abcdefgh", 8),
        arguments("", 0),
        arguments("aabcdefgh", 8),
        arguments("abcdefghh", 8)
    );
  }
}
