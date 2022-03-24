package leetcode.practice;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ThreeSumTest {
    ThreeSum clazz = new ThreeSum();
    CustomAsserts customAsserts = new CustomAsserts();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] input, List<Integer> expected) {
      System.out.println("Expected: " + expected);
      var result = clazz.solution(input);
      System.out.println("Actual: " + result);
      customAsserts.assertListEquals(expected, result);
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{-1,0,1,2,-1,-4}, List.of(List.of(-1,-1,2), List.of(-1,0,1))),
          arguments(new int[]{0}, List.of()),
          arguments(new int[]{-1,-1,2,2}, List.of(List.of(-1,-1,2))),
          arguments(new int[]{-1,1,-1,-1,-2,2,2,0}, List.of(List.of(-1,-1,2),List.of(-1,0,1),List.of(-2,0,2))),
          arguments(new int[]{-2,0,0,2,2}, List.of(List.of(-2,0,2)))
      );
    }

  }
