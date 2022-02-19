package educative.codinginterviewpatterns.modifiedbinarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NextLetterTest {
  NextLetter nextLetter = new NextLetter();

  @ParameterizedTest(name = "Recursive test case {index}")
  @MethodSource("testCases")
  void testSolution(char[] inputArr, char key, char expected) {
    var actual = nextLetter.recursiveSolution(inputArr, key);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  @ParameterizedTest(name = "Iterative test case {index}")
  @MethodSource("testCases")
  void testIterativeSolution(char[] inputArr, char key, char expected) {
    var actual = nextLetter.iterativeSolution(inputArr, key);
    System.out.println("expected: " + expected);
    System.out.println("actual: " + actual);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(new char[]{'a', 'c', 'f', 'h'}, 'f', 'h'),
        arguments(new char[]{'a', 'c', 'f', 'h'}, 'b', 'c'),
        arguments(new char[]{'a', 'c', 'f', 'h'}, 'm', 'a'),
        arguments(new char[]{'a', 'c', 'f', 'h'}, 'h', 'a')
    );
  }
}
