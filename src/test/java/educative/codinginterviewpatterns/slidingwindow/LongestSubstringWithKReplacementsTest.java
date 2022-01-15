package educative.codinginterviewpatterns.slidingwindow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestSubstringWithKReplacementsTest {
  LongestSubstringWithKReplacements longestSubstringWithKReplacements = new LongestSubstringWithKReplacements();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(String input, int k, int expected) {
    var actual = longestSubstringWithKReplacements.findLength(input, k);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("aabccbb", 2, 5),
        arguments("abbcb", 1, 4),
        arguments("abccde", 1, 3),
        arguments("abcd", 1, 2),
        arguments("abcdeffh", 2, 4)
    );
  }
}
