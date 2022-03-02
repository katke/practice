package educative.codinginterviewpatterns.practice;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ProductLessThanTargetTest {
  ProductLessThanTarget productLessThanTarget = new ProductLessThanTarget();
  CustomAsserts customAsserts = new CustomAsserts();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] arr, int target, List<List<Integer>> expected) {
    var actual = productLessThanTarget.solution(arr, target);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    customAsserts.assertListEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{2, 5, 3, 10}, 30, List.of(List.of(2), List.of(5), List.of(2, 5), List.of(3), List.of(5, 3), List.of(10))),
        arguments(new int[]{8, 2, 6, 5}, 50, List.of(List.of(8), List.of(2), List.of(8, 2), List.of(6), List.of(2, 6), List.of(5), List.of(6, 5)))
    );
  }

}
