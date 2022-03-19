package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortArrayTest {
    SortArray clazz = new SortArray();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] input, int[] expected) {
      assertArrayEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{5,2,3,1}, new int[]{1,2,3,5}),
          arguments(new int[]{5,2,3,1,4}, new int[]{1,2,3,4,5}),
          arguments(new int[]{5,-1,2,3,1,6,4,10,2,-10}, new int[]{-10,-1,1,2,2,3,4,5,6,10})
      );
    }

  }
