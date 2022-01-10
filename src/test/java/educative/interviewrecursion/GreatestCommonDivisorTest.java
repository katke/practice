package educative.interviewrecursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GreatestCommonDivisorTest {
  GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();

  @ParameterizedTest
  @MethodSource("getTestCases")
  void testSolution(int input1, int input2, int expected) {
    var actualGcd = greatestCommonDivisor.gcd(input1, input2);
    assertEquals(expected, actualGcd);
  }

  static Stream<Arguments> getTestCases() {
    return Stream.of(
        arguments(36, 54, 18),
        arguments(0, 12, -1)
    );
  }

}
