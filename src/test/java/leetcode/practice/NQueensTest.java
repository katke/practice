package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NQueensTest {
    NQueens clazz = new NQueens();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int n, int expected) {
      assertEquals(expected, clazz.solution(n));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(4, 2),
          arguments(1, 1)
      );
    }

  }
