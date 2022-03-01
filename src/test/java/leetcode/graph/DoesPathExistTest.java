package leetcode.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DoesPathExistTest {
  DoesPathExist doesPathExist = new DoesPathExist();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int n, int[][] edges, int source, int destination, boolean expected) {
    assertEquals(expected, doesPathExist.validPath(n, edges, source, destination));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}}, 0, 2, true),
        arguments(6, new int[][]{new int[]{0, 1}, new int[]{0, 2}, new int[]{3, 5}, new int[]{5, 4}, new int[]{4, 3}}, 0, 5, false),
        arguments(1, new int[][]{}, 0, 0, true),
        arguments(10, new int[][]{
            new int[]{0,7},new int[]{0,8},new int[]{6,1},new int[]{2,0},new int[]{0,4},
            new int[]{5,8},new int[]{4,7},new int[]{1,3},new int[]{3,5},new int[]{6,5}},
            7, 5, true)
    );
  }

}
