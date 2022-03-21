package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestSubstringWithNoRepeatingCharsTest {
    LongestSubstringWithNoRepeatingChars clazz = new LongestSubstringWithNoRepeatingChars();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(String input, int expected) {
      assertEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments("abcabcbb", 3),
          arguments("bbbbb", 1),
          arguments("pwwkew", 3),
          arguments("abcdefgh", 8),
          arguments("aAbBcCdDeEfFgGhG", 15),
          arguments("aab", 2)
      );
    }

  }
