package educative.codinginterviewpatterns.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringWithBackspacesTest {
  StringWithBackspaces stringWithBackspaces = new StringWithBackspaces();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(String str1, String str2, boolean expected) {
    var actual = stringWithBackspaces.solution(str1, str2);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("xy#z", "xzz#", true),
        arguments("xy#z", "xyz#", false),
        arguments("xp#", "xyz##", true),
        arguments("xywrrmp", "xywrrmu#p", true)
    );
  }
}
