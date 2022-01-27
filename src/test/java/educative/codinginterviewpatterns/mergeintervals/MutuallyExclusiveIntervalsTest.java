package educative.codinginterviewpatterns.mergeintervals;

import leetcode.commontypes.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MutuallyExclusiveIntervalsTest {
  MutuallyExclusiveIntervals mutuallyExclusiveIntervals = new MutuallyExclusiveIntervals();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(List<Interval> intervals, List<Interval> expected) {
    var actual = mutuallyExclusiveIntervals.merge(intervals);
    assertItemsMatch(expected, actual);
  }

  private void assertItemsMatch(List<Interval> expected, List<Interval> actual) {
    assertEquals(expected.size(), actual.size());
    for (int i = 0; i < expected.size(); i++) {
        assertEquals(expected.get(i).start, actual.get(i).start);
        assertEquals(expected.get(i).end, actual.get(i).end);
    }
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1(),
        testCase2(),
        testCase3(),
        testCase4()
    );
  }

  private static Arguments testCase1() {
    var interval1 = new Interval(1, 4);
    var interval2 = new Interval(2,5);
    var interval3 = new Interval(7,9);

    var expectedInterval1 = new Interval(1,5);
    var expectedInterval2 = new Interval(7,9);
    return arguments(List.of(
        interval1,
        interval2,
        interval3
    ), List.of (
        expectedInterval1,
        expectedInterval2
    ));
  }

  private static Arguments testCase2() {
    var interval1 = new Interval(6, 7);
    var interval2 = new Interval(2,4);
    var interval3 = new Interval(5,9);

    var expectedInterval1 = new Interval(2,4);
    var expectedInterval2 = new Interval(5,9);
    return arguments(List.of(
        interval1,
        interval2,
        interval3
    ), List.of (
        expectedInterval1,
        expectedInterval2
    ));
  }

  private static Arguments testCase3() {
    var interval1 = new Interval(1, 4);
    var interval2 = new Interval(2, 6);
    var interval3 = new Interval(3, 5);

    var expectedInterval1 = new Interval(1,6);
    return arguments(List.of(
        interval1,
        interval2,
        interval3
    ), List.of (
        expectedInterval1
    ));
  }

  private static Arguments testCase4() {
    var interval1 = new Interval(1, 2);
    var interval2 = new Interval(2, 7);
    var interval3 = new Interval(7, 11);

    var expectedInterval1 = new Interval(1,11);
    return arguments(List.of(
        interval1,
        interval2,
        interval3
    ), List.of (
        expectedInterval1
    ));
  }

}
