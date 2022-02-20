package educative.codinginterviewpatterns.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SmallestWindowWithSubstringTest {
  SmallestWindowWithSubstring smallestWindowWithSubstring = new SmallestWindowWithSubstring();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(String str, String pattern, String expected) {
    var actual = smallestWindowWithSubstring.solution(str, pattern);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("aabdec", "abc", "abdec"),
        arguments("abdbca", "abc", "bca"),
        arguments("adcad", "abc", "")
    );
  }
}
