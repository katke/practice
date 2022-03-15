package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MeetingRooms2Test {
    MeetingRooms2 clazz = new MeetingRooms2();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(int[][] intervals, int expected) {
      assertEquals(expected, clazz.solution(intervals));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[][]{new int[]{0,30},new int[]{5,10},new int[]{15,20}}, 2),
          arguments(new int[][]{new int[]{7,10},new int[]{2,4}}, 1),
          arguments(new int[][]{
              new int[]{0,10},new int[]{3,5}, new int[]{4,8}, new int[]{15,17}, new int[]{9,12}},
              3),
          arguments(new int[][]{new int[]{1,5},new int[]{8,9},new int[]{8,9}}, 2)
      );
    }

  }
