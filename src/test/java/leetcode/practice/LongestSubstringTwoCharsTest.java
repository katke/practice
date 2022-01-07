package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestSubstringTwoCharsTest {

  LongestSubstringTwoChars longestSubstringTwoChars = new LongestSubstringTwoChars();

  @ParameterizedTest(name = "{index}: Input {0}")
  @MethodSource("generateTestCases")
  void testSolution(String input, int expected) {
    var actual = longestSubstringTwoChars.solution(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> generateTestCases() {
    return Stream.of(
        arguments("eceba", 3),
        arguments("ccaabbb", 5),
        arguments("", 0),
        arguments("bbbbbbbbbbbbb", 13),
        arguments("cccccccCcabbbbbbBbb", 9),
        arguments("yyyyyyyyywyyyyyyyyalksdjfaaaaaaaa", 18),
        arguments("y", 1),
        arguments("yyyyaaab", 7)
    );
  }
}
