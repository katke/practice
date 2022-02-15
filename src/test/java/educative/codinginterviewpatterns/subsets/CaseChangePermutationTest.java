package educative.codinginterviewpatterns.subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CaseChangePermutationTest {
  CaseChangePermutation caseChangePermutation = new CaseChangePermutation();

  @ParameterizedTest(name = "Iterative solution {index}")
  @MethodSource("testCases")
  void testSolution(String input, List<String> expected) {
    var actual = caseChangePermutation.solution(input);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertListEquals(expected, actual);
  }

  @ParameterizedTest(name = "Recursive solution {index}")
  @MethodSource("testCases")
  void testEducativeSolution(String input, List<String> expected) {
    var actual = caseChangePermutation.recursiveSolution(input);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertListEquals(expected, actual);
  }

  void assertListEquals(List<String> expected, List<String> actual) {
    assertEquals(expected.size(), actual.size());
    for (String expectedPermutation : expected) {
      System.out.println("expectedPermutation: " + expectedPermutation);
      assertTrue(actual.contains(expectedPermutation));
    }
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("ad52", List.of("ad52", "Ad52", "aD52", "AD52")),
        arguments("ab7c", List.of("ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C")),
        arguments("a5a", List.of("a5a", "A5a", "a5A", "A5A"))
            );
  }
}
