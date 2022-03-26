package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WordSearchTest {
    WordSearch clazz = new WordSearch();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(char[][] board, String word, boolean expected) {
      assertEquals(expected, clazz.solution(board, word));
    }

  @ParameterizedTest
  @MethodSource("testcases")
  void testLCSolution(char[][] board, String word, boolean expected) {
    assertEquals(expected, clazz.exist(board, word));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new char[][]{new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}}, "ABCCED", true),
          arguments(new char[][]{new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}}, "SEE", true),
          arguments(new char[][]{new char[]{'A','B','C','E'},new char[]{'S','F','C','S'},new char[]{'A','D','E','E'}}, "ABCB", false)
      );
    }

  }
