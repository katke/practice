package educative.codinginterviewpatterns.fastslowpointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HappyNumberTest {
  HappyNumber happyNumber = new HappyNumber();

  @ParameterizedTest(name = "Fast/Slow Pointer Solution {index}, input {0}")
  @MethodSource("testCases")
  void testSolution(int input, boolean expected) {
    var actual = happyNumber.find(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "Alternative Solution {index}, input {0}")
  @MethodSource("testCases")
  void testAlternativeSolution(int input, boolean expected) {
    var actual = happyNumber.alternativeSolution(input);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(23, true),
        arguments(12, false),
        arguments(0, true),
        arguments(2, false),
        arguments(178, false)
    );
  }

}
