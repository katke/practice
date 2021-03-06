package educative.codinginterviewpatterns.subsets;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BalancedParensTest {
  BalancedParens balancedParens = new BalancedParens();
  CustomAsserts customAsserts = new CustomAsserts();

  @ParameterizedTest(name = "Iterative solution {index}")
  @MethodSource("testCases")
  void testSolution(int input, List<String> expected) {
    var actual = balancedParens.solution(input);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    customAsserts.assertListEquals(expected, actual);
  }

  @ParameterizedTest(name = "Recursive solution {index}")
  @MethodSource("testCases")
  void testEducativeSolution(int input, List<String> expected) {
    var actual = balancedParens.recursiveSolution(input);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    customAsserts.assertListEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(2, List.of("(())", "()()")),
        arguments(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()"))
    );
  }
}
