package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JumpGame3Test {
    JumpGame3 clazz = new JumpGame3();

    @ParameterizedTest(name = "Recursive Solution {index}")
    @MethodSource("testcases")
    void testRecursiveSolution(int[] input, int start, boolean expected) {
      assertEquals(expected, clazz.solution(input, start));
    }

  @ParameterizedTest(name = "Iterative Solution {index}")
  @MethodSource("testcases")
  void testIterativeSolution(int[] input, int start, boolean expected) {
    assertEquals(expected, clazz.iterativeSolution(input, start));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{4,2,3,0,3,1,2}, 5, true),
          arguments(new int[]{4,2,3,0,3,1,2}, 0, true),
          arguments(new int[]{3,0,2,1,2}, 2, false)
      );
    }

  }
