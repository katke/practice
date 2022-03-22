package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestPalindromicSubstringTest {
    LongestPalindromicSubstring clazz = new LongestPalindromicSubstring();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(String input, List<String> expected) {
      String actual = clazz.solution(input);
      System.out.println(actual);
      assertTrue(expected.contains(actual));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments("babad", List.of("bab", "aba")),
          arguments("cbbd", List.of("bb")),
          arguments("cdbabdc", List.of("cdbabdc")),
          arguments("abcdaadc", List.of("cdaadc"))
      );
    }

  }
