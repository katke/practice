package leetcode.practice;

// 1235


import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.List;
import java.util.Map;

public class MaxProfit implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String source = "https://leetcode.com/problems/maximum-profit-in-job-scheduling/";

  public int solution(int[] startTime, int[] endTime, int[] profit) {
    return 0;
  }

  public Map<String, List<int[]>> getTestCases() {
    return Map.of(
        "1. Expected: 0", List.of(new int[]{}, new int[]{}, new int[]{})
    );
  }

}
