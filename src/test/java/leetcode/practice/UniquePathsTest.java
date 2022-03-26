package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UniquePathsTest {
    UniquePaths clazz = new UniquePaths();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int m, int n, int expected) {
      assertEquals(expected, clazz.solution(m,n));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(3,7,28),
          arguments(3,2,3),
          arguments(0,2,0),
          arguments(1,1,1)
      );
    }

  }
