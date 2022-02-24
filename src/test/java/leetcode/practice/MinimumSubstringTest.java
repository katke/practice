package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MinimumSubstringTest {
  MinimumSubstring minimumSubstring = new MinimumSubstring();

  @ParameterizedTest(name = "{index}: Input {0}")
  @MethodSource("generateTestCases")
  void testSolution(String s, String t, String expected) {
    var actual = minimumSubstring.solution(s, t);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> generateTestCases() {
    return Stream.of(
        arguments("ADOBECODEBANC", "ABC","BANC"),
        arguments("ABC", "ABCD", ""),
        arguments("a", "b", ""),
        arguments("a", "a", "a"),
        arguments("ABCODEBaNbCBA", "AbC", "bCBA"),
        arguments("talkeHandHErRzJrARRHNDeoRRRRzalkje", "Hr", "HEr"),
        arguments("acbba", "aab", "acbba"),
        arguments("edacb", "abcde", "edacb")
    );
  }
}
