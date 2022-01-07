package educative.javadatastructures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeTwoSortedArraysTest {

  MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();

  @ParameterizedTest
  @MethodSource("generateTestCases")
  void testSolution(int[] arr1, int[] arr2, int[] expected) {
    var actual = mergeTwoSortedArrays.mergeArrays(arr1, arr2);
    assertArrayEquals(expected, actual);
  }

  private static Stream<Arguments> generateTestCases() {
    return Stream.of(
        diffLengthArrs(),
        sameLengthArrs(),
        shortArrs(),
        emptyArrs(),
        oneEmptyArr(),
        oneNullArr(),
        otherNullArr(),
        bothNull()
    );
  }

  private static Arguments diffLengthArrs() {
    int[] arr1 = new int[]{1,5,10,11};
    int[] arr2 = new int[]{2,3,12};
    var expected = new int[]{1,2,3,5,10,11,12};
    return Arguments.of(arr1, arr2, expected);
  }

  private static Arguments sameLengthArrs() {
    int[] arr1 = new int[]{1,5,10};
    int[] arr2 = new int[]{2,3,12};
    var expected = new int[]{1,2,3,5,10,12};
    return Arguments.of(arr1, arr2, expected);
  }

  private static Arguments shortArrs() {
    int[] arr1 = new int[]{3};
    int[] arr2 = new int[]{1};
    var expected = new int[]{1,3};
    return Arguments.of(arr1, arr2, expected);
  }

  private static Arguments emptyArrs() {
    int[] arr1 = new int[]{};
    int[] arr2 = new int[]{};
    var expected = new int[]{};
    return Arguments.of(arr1, arr2, expected);
  }

  private static Arguments oneEmptyArr() {
    int[] arr1 = new int[]{};
    int[] arr2 = new int[]{10};
    var expected = new int[]{10};
    return Arguments.of(arr1, arr2, expected);
  }

  private static Arguments oneNullArr() {
    int[] arr2 = new int[]{10};
    var expected = new int[]{10};
    return Arguments.of(null, arr2, expected);
  }

  private static Arguments otherNullArr() {
    int[] arr1 = new int[]{10};
    var expected = new int[]{10};
    return Arguments.of(arr1, null, expected);
  }

  private static Arguments bothNull() {
    var expected = new int[]{};
    return Arguments.of(null, null, expected);
  }
}
