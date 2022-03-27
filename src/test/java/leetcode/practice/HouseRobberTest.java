package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HouseRobberTest {
    HouseRobber clazz = new HouseRobber();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[] input, int expected) {
      assertEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{1,2,3,1}, 4),
          arguments(new int[]{2,7,9,3,1}, 12),
          arguments(new int[]{2,7,1,3,10}, 17),
          arguments(new int[]{7,7,1,5,10}, 18)
      );
    }

  }
