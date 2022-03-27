package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BestTimeToBuySellStockTest {
    BestTimeToBuySellStock clazz = new BestTimeToBuySellStock();

    @ParameterizedTest(name = "brute force {index}")
    @MethodSource("testcases")
    void testBruteForceSolution(int[] prices, int expected) {
      assertEquals(expected, clazz.bruteForceSolution(prices));
    }

  @ParameterizedTest(name = "optimized {index}")
  @MethodSource("testcases")
  void testOptimizedSolution(int[] prices, int expected) {
      assertEquals(expected, clazz.solution(prices));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(new int[]{7,1,5,3,6,4}, 5),
          arguments(new int[]{7,6,4,3,1}, 0),
          arguments(new int[]{1,2}, 1),
          arguments(new int[]{7,6,1,3}, 2)
      );
    }

  }
