package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CourseSchedule2Test {
  CourseSchedule2 courseSchedule2 = new CourseSchedule2();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int numCourses, int[][] prerequisites, List<int[]> expected) {
    var actual = courseSchedule2.solution(numCourses, prerequisites);
    System.out.print("Expected: ");
    expected.forEach(arr -> System.out.println(Arrays.toString(arr)));
    System.out.println("actual: " + Arrays.toString(actual));
    assertActualAppearsInExpected(expected, actual);
  }

  void assertActualAppearsInExpected(List<int[]> expected, int[] actual) {
    boolean foundMatch = false;
    for (int[] solution : expected) {
      if (solution.length != actual.length) {
        continue;
      }
      int i = 0;
      while (i < solution.length) {
        if (solution[i] != actual[i]) {
          continue;
        }
        i++;
      }
      foundMatch = true;
    }
    assertTrue(foundMatch);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(2, new int[][]{new int[]{1,0}}, List.of(new int[] {0,1})),
        arguments(2, new int[][]{new int[]{1,0}, new int[]{0,1}}, List.of(new int[] {})),
        arguments(4, new int[][]{new int[]{1,0},new int[]{2,0},new int[]{3,1},new int[]{3,2}},
            List.of(new int[]{0,2,1,3}, new int[]{0,1,2,3}))
//        arguments(1, new int[][]{}, List.of(new int[]{0}))
//        arguments(5, new int[][]{new int[]{1,0},new int[]{2,0},new int[]{3,1},new int[]{3,2}})
    );
  }
}
