package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestConsecutiveSequenceTest {
  LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] input, int expected) {
    var actual = longestConsecutiveSequence.longestConsecutive(input);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[]{100,4,200,1,3,2}, 4),
        arguments(new int[]{0,3,7,2,5,8,4,6,0,1}, 9),
        arguments(new int[]{0,3,7,12,15,18,24,46,0,81}, 1),
        arguments(new int[]{-140,4,77,90,-34,-141}, 2),
        arguments(new int[]{-1,0,1,2,3}, 5)
    );
  }
}
