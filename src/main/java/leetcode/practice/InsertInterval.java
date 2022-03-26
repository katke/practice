package leetcode.practice;

import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
  String source = "https://leetcode.com/problems/insert-interval/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the
start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given
an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
*/

  int[][] solution(int[][] intervals, int[] newInterval) {
    if (intervals == null) return new int[0][0];
    else if (intervals.length < 1) return new int[][]{newInterval};
    int newIntervalStart = newInterval[0];
    int newIntervalEnd = newInterval[1];
    boolean newIntervalIncorporated = false;
    int[][] allIntervals = new int[intervals.length + 1][2];
    int inputIndex = 0;
    for (int i = 0; i < allIntervals.length; i++) {
      if (i == 0 && newIntervalEnd < intervals[inputIndex][0] && !newIntervalIncorporated) {
        allIntervals[0] = newInterval;
        newIntervalIncorporated = true;
      } else if (i == allIntervals.length - 1 && !newIntervalIncorporated) {
        allIntervals[i] = newInterval;
      } else {
        if (!newIntervalIncorporated && newIntervalStart <= intervals[inputIndex][0]) {
          newIntervalIncorporated = true;
          allIntervals[i] = newInterval;
          i++;
        }
        allIntervals[i] = intervals[inputIndex];
        inputIndex++;
      }
    }

    List<int[]> result = new ArrayList<>();
    int[] currentInterval = allIntervals[0];
    for (int i = 1; i < allIntervals.length; i++) {
      if (allIntervals[i][0] <= currentInterval[1]) {
        currentInterval[1] = Math.max(currentInterval[1], allIntervals[i][1]);
      } else {
        result.add(currentInterval);
        currentInterval = allIntervals[i];
      }
    }
    result.add(currentInterval);
    int[][] finalResult = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      finalResult[i] = result.get(i);
    }
    return finalResult;
  }
}
