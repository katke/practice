package leetcode.practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UniqueIntsToZeroTest {
  UniqueIntsToZero clazz = new UniqueIntsToZero();

  @ParameterizedTest
  @ValueSource(ints = {2, 5, 10})
  void testSolution(int input) {
    var actual = clazz.solution(input);
    System.out.println(Arrays.toString(actual));
    assertEquals(input, actual.length);
    assertTrue(validateResult(actual));
  }

  boolean validateResult(int[] input) {
    Map<Integer, Integer> resultMap = new HashMap<>();
    for (int val : input) {
      resultMap.put(val, resultMap.getOrDefault(val, 0) + 1);
    }
    var hasNoDups = resultMap.entrySet().stream().allMatch(entry -> entry.getValue() == 1);
    var sumIsZero = Arrays.stream(input).sum() == 0;
    return hasNoDups && sumIsZero;
  }

  @ParameterizedTest
  @MethodSource("validationTestCases")
  void validateTheValidation(int[] input, boolean expected) {
    assertEquals(expected, validateResult(input));
  }

  static Stream<Arguments> validationTestCases() {
    return Stream.of(
        arguments(new int[]{1, 2, -1, -2, 0}, true),
        arguments(new int[]{1, 1, -2, 3, -3}, false),
        arguments(new int[]{4, 1, -2, 3, -3}, false)
    );
  }

}
