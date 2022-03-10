package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CourseSchedule2Test {
  CourseSchedule2 courseSchedule2 = new CourseSchedule2();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int numCourses, int[][] prerequisites, List<List<Integer>> expected) {
    var actual = courseSchedule2.solution(numCourses, prerequisites);
    System.out.print("Expected: " + expected);
    System.out.println("actual: " + Arrays.toString(actual));
    assertActualAppearsInExpected(expected, actual);
  }

  void assertActualAppearsInExpected(List<List<Integer>> expected, int[] actual) {
    List<Integer> convertedActual = new ArrayList<>();
    for (int i : actual) {
      convertedActual.add(i);
    }
   assertTrue(expected.contains(convertedActual));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(2, new int[][]{new int[]{1,0}}, List.of(List.of(0,1))),
        arguments(2, new int[][]{new int[]{1,0}, new int[]{0,1}}, List.of(List.of())),
        arguments(4, new int[][]{new int[]{1,0},new int[]{2,0},new int[]{3,1},new int[]{3,2}},
            List.of(List.of(0,2,1,3), List.of(0,1,2,3))),
        arguments(1, new int[][]{}, List.of(List.of(0))),
        arguments(2, new int[][]{}, List.of(List.of(0, 1), List.of(1,0))),
        arguments(3, new int[][]{new int[]{1,0}, new int[]{1,2}, new int[]{2,1}}, List.of(List.of()))
    );
  }
}
