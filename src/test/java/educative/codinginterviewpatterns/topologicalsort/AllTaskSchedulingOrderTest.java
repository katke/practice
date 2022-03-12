package educative.codinginterviewpatterns.topologicalsort;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AllTaskSchedulingOrderTest {
  AllTaskSchedulingOrder allTaskSchedulingOrder = new AllTaskSchedulingOrder();
  CustomAsserts customAsserts = new CustomAsserts();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int tasks, int[][] prereqs, List<List<Integer>> expected) {
    var actual = allTaskSchedulingOrder.solution(tasks, prereqs);
    customAsserts.assertListEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
//        arguments(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}}, List.of(List.of(0, 1, 2))),
        arguments(4, new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}},
            List.of(List.of(3, 2, 0, 1), List.of(3, 2, 1, 0)))
//        arguments(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4}, new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}},
//            List.of(
//                List.of(0, 1, 4, 3, 2, 5),
//                List.of(0, 1, 3, 4, 2, 5),
//                List.of(0, 1, 3, 2, 4, 5),
//                List.of(0, 1, 3, 2, 5, 4),
//                List.of(1, 0, 3, 4, 2, 5),
//                List.of(1, 0, 3, 2, 4, 5),
//                List.of(1, 0, 3, 2, 5, 4),
//                List.of(1, 0, 4, 3, 2, 5),
//                List.of(1, 3, 0, 2, 4, 5),
//                List.of(1, 3, 0, 2, 5, 4),
//                List.of(1, 3, 0, 4, 2, 5),
//                List.of(1, 3, 2, 0, 5, 4),
//                List.of(1, 3, 2, 0, 4, 5)))
    );
  }
}
