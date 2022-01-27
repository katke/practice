package educative.codinginterviewpatterns.mergeintervals;

import leetcode.commontypes.Interval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class InsertIntervalTest {
  InsertInterval insertInterval = new InsertInterval();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(List<Interval> intervals, Interval newInterval, List<Interval> expected) {
    var actual = insertInterval.insert(intervals, newInterval);
    assertItemsMatch(expected, actual);
  }

  // TODO extract as shared assertion
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
        newIntervalCompletelyConsumesIntervals(),
        newIntervalNoOverlapAtBeginning(),
        newIntervalNoOverlapAtEnd()
    );
  }

  private static Arguments testCase1() {
    var interval1 = new Interval(1, 3);
    var interval2 = new Interval(5, 7);
    var interval3 = new Interval(8, 12);

    var newInterval = new Interval(4, 6);

    var expectedInterval1 = new Interval(1, 3);
    var expectedInterval2 = new Interval(4, 7);
    var expectedInterval3 = new Interval(8, 12);
    return arguments(
        List.of(interval1, interval2, interval3),
        newInterval,
        List.of(expectedInterval1, expectedInterval2, expectedInterval3)
    );
  }

  private static Arguments testCase2() {
    var interval1 = new Interval(1, 3);
    var interval2 = new Interval(5, 7);
    var interval3 = new Interval(8, 12);

    var newInterval = new Interval(4, 10);

    var expectedInterval1 = new Interval(1,3);
    var expectedInterval2 = new Interval(4, 12);
    return arguments(
        List.of(interval1, interval2, interval3),
        newInterval,
        List.of(expectedInterval1, expectedInterval2)
    );
  }

  private static Arguments testCase3() {
    var interval1 = new Interval(2, 3);
    var interval2 = new Interval(5, 7);

    var newInterval = new Interval(1, 4);

    var expectedInterval1 = new Interval(1, 4);
    var expectedInterval2 = new Interval(5, 7);
    return arguments(
        List.of(interval1, interval2),
        newInterval,
        List.of(expectedInterval1, expectedInterval2)
    );
  }

  private static Arguments newIntervalCompletelyConsumesIntervals() {
    var interval1 = new Interval(2, 3);
    var interval2 = new Interval(5, 7);
    var interval3 = new Interval(9, 10);

    var newInterval = new Interval(1, 14);

    var expectedInterval1 = new Interval(1, 14);
    return arguments(
        List.of(interval1, interval2, interval3),
        newInterval,
        List.of(expectedInterval1)
    );
  }

  private static Arguments newIntervalNoOverlapAtBeginning() {
    var interval1 = new Interval(4, 5);
    var interval2 = new Interval(7, 8);

    var newInterval = new Interval(1, 2);

    var expectedInterval1 = new Interval(1, 2);
    var expectedInterval2 = new Interval(4, 5);
    var expectedInterval3 = new Interval(7, 8);
    return arguments(
        List.of(interval1, interval2),
        newInterval,
        List.of(expectedInterval1, expectedInterval2, expectedInterval3)
    );
  }

  private static Arguments newIntervalNoOverlapAtEnd() {
    var interval1 = new Interval(4, 5);
    var interval2 = new Interval(7, 8);

    var newInterval = new Interval(10, 11);

    var expectedInterval1 = new Interval(4, 5);
    var expectedInterval2 = new Interval(7, 8);
    var expectedInterval3 = new Interval(10, 11);
    return arguments(
        List.of(interval1, interval2),
        newInterval,
        List.of(expectedInterval1, expectedInterval2, expectedInterval3)
    );
  }
}
