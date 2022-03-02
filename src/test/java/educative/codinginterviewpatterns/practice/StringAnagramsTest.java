package educative.codinginterviewpatterns.practice;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringAnagramsTest {
  StringAnagrams stringAnagrams = new StringAnagrams();
  CustomAsserts customAsserts = new CustomAsserts();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(String str, String pattern, List<Integer> expected) {
    var actual = stringAnagrams.solution(str, pattern);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    customAsserts.assertListEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("ppqp", "pq", List.of(1, 2)),
        arguments("abbcabc", "abc", List.of(2, 3, 4))
    );
  }
}
