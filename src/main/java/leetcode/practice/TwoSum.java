package leetcode.practice;

import shared.PracticeStatus;
import java.util.*;

public class TwoSum {
  String source = "https://leetcode.com/problems/two-sum/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "Optimized: O(n), brute force: O(n^2)";
  String spaceComplexity = "Optimized: O(n), brute force: O(1)";
  /*
   * Given an array of integers nums and an integer target, return indices of the two numbers such that
   * they add up to target.
   * You may assume that each input would have exactly one solution, and you may not use the same element twice.
   * You can return the answer in any order.
   * */

  int[] solution(int[] nums, int target) {
    if (nums == null || nums.length < 2) return new int[]{};
    Map<Integer, Integer> indexMapping = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      indexMapping.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (indexMapping.containsKey(diff) && i != indexMapping.get(diff)) {
        return new int[]{i, indexMapping.get(diff)};
      }
    }
    return new int[]{};
  }

  int[] bruteForceSolution(int[] nums, int target) {
    if (nums == null || nums.length < 2) return new int[]{};
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (target - nums[i] == nums[j]) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{};
  }
}
