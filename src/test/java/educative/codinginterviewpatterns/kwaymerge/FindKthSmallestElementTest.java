package educative.codinginterviewpatterns.kwaymerge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindKthSmallestElementTest {
    FindKthSmallestElement clazz = new FindKthSmallestElement();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(List<Integer[]> lists, int k, int expected) {
      assertEquals(expected, clazz.solution(lists, k));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[][]{new int[]{2, 6, 8}, new int[]{3, 6, 7}, new int[]{1, 3, 4}}, 5, 4),
          arguments(new int[][]{new int[]{5, 8, 9}, new int[]{1, 7}}, 3, 7)
      );
    }

  }
