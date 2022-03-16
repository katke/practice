package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MinDeletionsForUniqueCharsTest {
    MinDeletionsForUniqueChars clazz = new MinDeletionsForUniqueChars();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(String input, int expected) {
      assertEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments("aab", 0),
          arguments("aaabbbcc", 2),
          arguments("ceabaacb", 2),
          arguments("abbccccdddd", 1),
          arguments("aabbcc", 3),
          arguments("aabbccdd", 5),
          arguments("addabbececcddebbe", 7)
      );
    }

  }
