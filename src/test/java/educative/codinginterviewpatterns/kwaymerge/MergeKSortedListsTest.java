package educative.codinginterviewpatterns.kwaymerge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MergeKSortedListsTest {
  MergeKSortedLists clazz = new MergeKSortedLists();

  @ParameterizedTest
  @MethodSource("testcases")
  void testSolution(int[][] input, List<Integer> expected) {
    assertEquals(expected, clazz.solution(input));
  }

  static Stream<Arguments> testcases() {
    return Stream.of(
        arguments(new int[][]{new int[]{2, 6, 8}, new int[]{3, 6, 7}, new int[]{1, 3, 4}}, List.of(1, 2, 3, 3, 4, 6, 6, 7, 8)),
        arguments(new int[][]{new int[]{5, 8, 9}, new int[]{1, 7}}, List.of(1, 5, 7, 8, 9)),
        arguments(new int[][]{new int[]{-11, 100, 900}, new int[]{1, 8, 9}, new int[]{9, 9}}, List.of(-11, 1, 8, 9, 9, 9, 100,900)),
        arguments(new int[][]{new int[]{1,2,3}, new int[]{8,9}}, List.of(1,2,3,8,9))
    );
  }

}
