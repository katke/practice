package educative.codinginterviewpatterns.topkelement;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class KthSmallestNumTest {
    KthSmallestNum clazz = new KthSmallestNum();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] nums, int k, int expected) {
      assertEquals(expected, clazz.solution(nums, k));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{1, 5, 12, 2, 11, 5}, 3, 5),
          arguments(new int[]{1, 5, 12, 2, 11, 5}, 4, 5),
          arguments(new int[]{5, 12, 11, -1, 12},3,11)
      );
    }

  }
