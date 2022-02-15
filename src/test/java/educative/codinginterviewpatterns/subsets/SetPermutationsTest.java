package educative.codinginterviewpatterns.subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SetPermutationsTest {
  SetPermutations setPermutations = new SetPermutations();

  @ParameterizedTest(name = "Iterative solution")
  @MethodSource("testCases")
  void testSolution(int[] nums, List<List<Integer>> expected) {
    var actual = setPermutations.solution(nums);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertListEquals(expected, actual);
  }

  @ParameterizedTest(name = "Recursive solution")
  @MethodSource("testCases")
  void testEducativeSolution(int[] nums, List<List<Integer>> expected) {
    var actual = setPermutations.recursiveSolution(nums);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertListEquals(expected, actual);
  }

  void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
    assertEquals(expected.size(), actual.size());
    for (List<Integer> expectedPermutation : expected) {
      System.out.println("expectedPermutation: " + expectedPermutation);
      assertTrue(actual.contains(expectedPermutation));
    }
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{1, 3, 5},
            List.of(List.of(1, 3, 5), List.of(1, 5, 3), List.of(3, 1, 5), List.of(3, 5, 1), List.of(5, 1, 3), List.of(5, 3, 1)))
    );
  }
}
