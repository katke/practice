package educative.codinginterviewpatterns.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PermutationInAStringTest {
  PermutationInAString permutationInAString = new PermutationInAString();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(String str, String pattern, boolean expected) {
    var actual = permutationInAString.solution(str, pattern);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("oidbcaf", "abc", true),
        arguments("odicf", "dc", false),
        arguments("bcdxabcdy", "bcdyabcdx", true),
        arguments("aaacb", "abc", true)
    );
  }
}
