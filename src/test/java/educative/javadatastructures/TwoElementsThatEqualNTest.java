package educative.javadatastructures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoElementsThatEqualNTest {

  TwoElementsThatEqualN twoElementsThatEqualN = new TwoElementsThatEqualN();

  @ParameterizedTest(name = "{index}: Input {0}, target {1}")
  @MethodSource("generateTestCases")
  void testBruteForceSolution(int[] inputArr, int inputSumTarget, List<String> expectedOptions) {
    var actual = twoElementsThatEqualN.findSumBruteForce(inputArr, inputSumTarget);
    System.out.println("Result: " + Arrays.toString(actual));
    assertTrue(expectedOptions.contains(Arrays.toString(actual)));
  }

  @ParameterizedTest(name = "{index}: Input {0}, target {1}")
  @MethodSource("generateTestCases")
  void testOptimizedSolution(int[] inputArr, int inputSumTarget, List<String> expectedOptions) {
    var actual = twoElementsThatEqualN.findSumOptimized(inputArr, inputSumTarget);
    System.out.println("Result: " + Arrays.toString(actual));
    assertTrue(expectedOptions.contains(Arrays.toString(actual)));
  }

  private static Stream<Arguments> generateTestCases() {
    return Stream.of(
        educativeTestCase(),
        noMatchTestCase(),
        allMatchTestCase(),
        nullArray(),
        negativeIntegers(),
        oneItemArray(),
        allIntsAreSmallerThanTarget()
    );
  }

  private static Arguments educativeTestCase() {
    return Arguments.of(
        new int[]{1, 21, 3, 14, 5, 60, 7, 6},
        27,
        List.of("[6, 21]", "[21, 6]")
    );
  }

  private static Arguments noMatchTestCase() {
    return Arguments.of(
        new int[]{1, 21, 3, 60, 7, 6},
        20,
        List.of("[1, 21, 3, 60, 7, 6]")
    );
  }

  private static Arguments allMatchTestCase() {
    return Arguments.of(
        new int[]{1, 21},
        22,
        List.of("[1, 21]", "[21, 1]")
    );
  }

  private static Arguments oneItemArray() {
    return Arguments.of(
        new int[]{1},
        1,
        List.of("[1]")
    );
  }

  private static Arguments nullArray() {
    return Arguments.of(
        null,
        22,
        List.of("[]")
    );
  }

  private static Arguments negativeIntegers() {
    return Arguments.of(
        new int[]{1, 20, -3, 14, 5, 60, -7, 6},
        17,
        List.of("[20, -3]", "[-3, 20]")
    );
  }

  private static Arguments allIntsAreSmallerThanTarget() {
    return Arguments.of(
        new int[]{1, 3, 12, 10, 8},
        18,
        List.of("[8, 10]", "[10, 8]")
    );
  }

}
