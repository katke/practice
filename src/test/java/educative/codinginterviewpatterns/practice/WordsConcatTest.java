package educative.codinginterviewpatterns.practice;

import educative.codinginterviewpatterns.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WordsConcatTest {
  WordsConcat wordsConcat = new WordsConcat();
  CustomAsserts customAsserts = new CustomAsserts();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(String str, String[] words, List<Integer> expected) {
    var actual = wordsConcat.solution(str, words);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    customAsserts.assertListEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments("catfoxcat", new String[]{"cat", "fox"}, List.of(0, 3)),
        arguments("catcatfoxfox", new String[]{"cat", "fox"}, List.of(3))
    );
  }
}
