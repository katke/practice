package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindDuplicateNumberTest {

  FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();

  @ParameterizedTest
  @MethodSource("generateTestCases")
  void runTestCases(int[] input, int expected) {
    var actual = findDuplicateNumber.solution(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> generateTestCases() {
    return Stream.of(
        arguments(new int[] {1,3,4,2,2}, 2),
        arguments(new int[] {3,1,3,4,2}, 3),
        arguments(new int[] {1,1}, 1),
        arguments(new int[] {1,1,2}, 1),
        arguments(new int[] {}, 0),
        arguments(new int[] {1,3,10,2,5,3,4,8,6,9,7}, 3),
        arguments(new int[] {1,3,10,2,5,10,4,8,6,9,7}, 10)
    );
  }
}
