package educative.codinginterviewpatterns.practice;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class QuadSumToTargetTest {
  QuadSumToTarget quadSumToTarget = new QuadSumToTarget();
  CustomAsserts customAsserts = new CustomAsserts();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] arr, int target, List<List<Integer>> expected) {
    var actual = quadSumToTarget.solution(arr, target);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    customAsserts.assertListEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{4, 1, 2, -1, 1, -3}, 1, List.of(List.of(-3, -1, 1, 4), List.of(-3, 1, 1, 2))),
        arguments(new int[]{2, 0, -1, 1, -2, 2}, 2, List.of(List.of(-2, 0, 2, 2), List.of(-1, 0, 1, 2)))
    );
  }
}
