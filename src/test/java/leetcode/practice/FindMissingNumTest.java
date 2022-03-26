package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindMissingNumTest {
    FindMissingNum clazz = new FindMissingNum();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] input, int expected) {
      assertEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{3,0,1}, 2),
          arguments(new int[]{0,1}, 2),
          arguments(new int[]{2,1}, 0),
          arguments(new int[]{9,6,4,2,3,5,7,0,1}, 8),
          arguments(new int[]{1,0,2}, 3)
      );
    }

  }
