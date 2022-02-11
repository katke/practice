package educative.codinginterviewpatterns.subsets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DistinctSubsetsTest {
  DistinctSubsets distinctSubsets = new DistinctSubsets();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] nums, List<List<Integer>> expected) {
    var actual = distinctSubsets.solution(nums);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertListEquals(expected, actual);
  }

  void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
    assertEquals(expected.size(), actual.size());
    for (List<Integer> expectedSubset : expected) {
      assertTrue(actual.contains(expectedSubset));
    }
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{1, 3, 3}, List.of(List.of(), List.of(1), List.of(3), List.of(1,3), List.of(3,3), List.of(1,3,3))),
        arguments(new int[]{1, 5, 3, 3}, List.of(
            List.of(), List.of(1), List.of(5), List.of(3), List.of(1,5), List.of(1,3), List.of(5,3), List.of(1,5,3),
            List.of(3,3), List.of(1,3,3), List.of(5,3,3), List.of(1,5,3,3)))
    );
  }
}
