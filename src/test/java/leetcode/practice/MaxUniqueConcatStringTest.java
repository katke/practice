package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MaxUniqueConcatStringTest {
  MaxUniqueConcatString clazz = new MaxUniqueConcatString();

  @ParameterizedTest(name = "Iterative {index}")
  @MethodSource("testcases")
  void testSolution(List<String> input, int expected) {
    assertEquals(expected, clazz.solution(input));
  }

//  @ParameterizedTest(name = "Recursive {index}")
//  @MethodSource("testcases")
//  void testRecursiveSolution(List<String> input, int expected) {
//    assertEquals(expected, clazz.recursiveSolution(input));
//  }

  static Stream<Arguments> testcases() {
    return Stream.of(
        arguments(List.of("un", "iq", "ue"), 4),
        arguments(List.of("cha", "r", "act", "ers"), 6),
        arguments(List.of("abcdefghijklmnopqrstuvwxyz"), 26),
        arguments(List.of("su", "shi", "c", "at"), 6),
        arguments(List.of("s", "s", "s", "s"), 1),
        arguments(List.of("aa", "bb"), 0)
    );
  }

}
