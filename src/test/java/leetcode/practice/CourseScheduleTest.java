package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CourseScheduleTest {
  CourseSchedule courseSchedule = new CourseSchedule();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int numCourses, int[][] prereqs, boolean expected) {
    assertEquals(expected, courseSchedule.canFinish(numCourses, prereqs));
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(2, new int[][]{new int[]{1, 0}}, true),
        arguments(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}, false),
        arguments(4, new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{2,3}, new int[]{3,0}}, false),
        arguments(3, new int[][]{new int[]{0,1}, new int[]{0,2}, new int[]{2,1}}, true),
        arguments(4, new int[][]{new int[]{0,1}, new int[]{0,2}, new int[]{3,2},new int[]{1,3}}, true),
        arguments(20,
            new int[][]{
                new int[]{0,10},new int[]{3,18},new int[]{5,5},new int[]{6,11},new int[]{11,14},
                new int[]{13,1},new int[]{15,1},new int[]{17,4}}, false),
        arguments(7, new int[][]{
                new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3}, new int[]{5, 4}, new int[]{3, 0},
                new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}}, true),
        arguments(4, new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{2,3}, new int[]{3,2}, new int[]{1,3}}, false)
        );
  }
}
