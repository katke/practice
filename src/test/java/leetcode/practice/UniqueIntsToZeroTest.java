package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueIntsToZeroTest {
  UniqueIntsToZero clazz = new UniqueIntsToZero();

  @ParameterizedTest
  @ValueSource(ints = {2, 5, 10})
  void testSolution(int input, int[] expected) {
    assertEquals(input, expected.length);
    assertTrue(validateResult(clazz.solution(input)));
  }

  boolean validateResult(int[] input) {
      Map<Integer, Integer> resultMap = new HashMap<>();
      for (int val : input) {
        resultMap.put(val, resultMap.getOrDefault(val, 0) + 1);
      }
      var hasNoDups = resultMap.entrySet().stream().noneMatch(entry -> entry.getValue() > 1);
      var sumIsZero = Arrays.stream(input).sum() == 0;
      return hasNoDups && sumIsZero;
    }

}
