package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DistanceFromCharacterTest {
  DistanceFromCharacter distanceFromCharacter = new DistanceFromCharacter();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(String s, char c, int[] expected) {
    var actual = distanceFromCharacter.shortestToChar(s, c);
    assertArrayEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("loveleetcode", "e", new int[] {3,2,1,0,1,0,0,1,2,2,1,0})
    );
  }
}
