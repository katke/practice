package educative.interviewrecursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class IsPrimeNumberTest {
    IsPrimeNumber isPrimeNumber = new IsPrimeNumber();

    @ParameterizedTest
    @MethodSource("getTestCases")
    void testSolution(int input, boolean expected) {
      var actualGcd = isPrimeNumber.solution(input);
      assertEquals(expected, actualGcd);
    }

    static Stream<Arguments> getTestCases() {
      return Stream.of(
          arguments(36, false),
          arguments(199, true),
          arguments(9, false),
          arguments(2, true),
          arguments(3, true),
          arguments(27, false),
          arguments(23, true),
          arguments(127, true)
      );
    }

  }

