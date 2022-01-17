package educative.codinginterviewpatterns.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RemoveDuplicatesTest {
  RemoveDuplicates removeDuplicates = new RemoveDuplicates();


  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(int[] arr, int expected) {
    var actual = removeDuplicates.remove(arr);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new int[] {1, 2, 3, 4, 6}, 5),
        arguments(new int[]{2, 3, 3, 3, 6, 9, 9}, 4),
        arguments(new int[] {2, 2, 2, 11}, 2),
        arguments(new int[]{1,1,1,1,1,1,1}, 1)
    );
  }
}
