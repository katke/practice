package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CandyTest {
  Candy clazz = new Candy();

  @ParameterizedTest
  @MethodSource("testcases")
  void testSolution(int[] input, int expected) {
    assertEquals(expected, clazz.solution(input));
  }

  static Stream<Arguments> testcases() {
    return Stream.of(
        arguments(new int[]{1,0,2}, 5), // [2,1,2]
        arguments(new int[]{1,2,1}, 4), // [1,2,1],
        arguments(new int[]{1,2}, 3) // [1,2]
    );
  }

}
