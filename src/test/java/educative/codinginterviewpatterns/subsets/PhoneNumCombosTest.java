package educative.codinginterviewpatterns.subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PhoneNumCombosTest {
  PhoneNumCombos phoneNumCombos = new PhoneNumCombos();

  @ParameterizedTest(name = "Iterative {index}")
  @MethodSource("getTestCases")
  void testSolution(String input, List<String> expected) {
    var actual = phoneNumCombos.solution(input);
    assertListEquals(expected, actual);
  }

  @ParameterizedTest(name = "Recursive {index}")
  @MethodSource("getTestCases")
  void testRecursiveSolution(String input, List<String> expected) {
    var actual = phoneNumCombos.recursiveSolution(input);
    assertListEquals(expected, actual);
  }

  void assertListEquals(List<String> expected, List<String> actual) {
    assertEquals(expected.size(), actual.size());
    for (String expectedPermutation : expected) {
      System.out.println("expectedPermutation: " + expectedPermutation);
      assertTrue(actual.contains(expectedPermutation));
    }
  }

  static Stream<Arguments> getTestCases() {
    return Stream.of(
        arguments("23", List.of("ad","ae","af","bd","be","bf","cd","ce","cf")),
        arguments("", List.of()),
        arguments("2", List.of("a","b","c")),
        arguments("576", List.of("jpm", "jpn", "jpo", "jqm", "jqn", "jqo", "jrm", "jrn", "jro", "jsm", "jsn",
            "jso", "kpm", "kpn", "kpo", "kqm", "kqn", "kqo", "krm", "krn", "kro", "ksm", "ksn", "kso", "lpm", "lpn",
            "lpo", "lqm", "lqn", "lqo", "lrm", "lrn", "lro", "lsm", "lsn", "lso"))
    );
  }
}
