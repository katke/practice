package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NumConnectedComponentsTest {
    NumConnectedComponents clazz = new NumConnectedComponents();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int n, int[][] edges, int expected) {

      assertEquals(expected, clazz.solution(n, edges));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(5, new int[][]{new int[]{0,1},new int[]{1,2},new int[]{3,4}}, 2),
          arguments(5, new int[][]{new int[]{0,1},new int[]{1,2},new int[]{2,3},new int[]{3,4}}, 1)
      );
    }

  }
