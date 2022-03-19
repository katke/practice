package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class JumpGame2Test {
    JumpGame2 clazz = new JumpGame2();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] input, int expected) {
      assertEquals(expected, clazz.solution(input));
    }

  @ParameterizedTest
  @MethodSource("testcases")
  void testBFSIterativeSolution(int[] input, int expected) {
    assertEquals(expected, clazz.bfsIterativeSolution(input));
  }

  @ParameterizedTest
  @MethodSource("testcases")
  void testIterativeSolution(int[] input, int expected) {
    assertEquals(expected, clazz.iterativeSolution(input));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{2,3,1,1,4}, 2),
          arguments(new int[]{2,3,0,1,4}, 2),
          arguments(new int[]{1,2,1,1,1}, 3)
      );
    }

  }
