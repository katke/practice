package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class ThreeSum {
  String source = "https://leetcode.com/problems/3sum/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n^2)";
  String spaceComplexity = "O(n)";
  /*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

*/
// sort the array so we can prevent duplicates
  // populate hashmap frequencies so we can avoid reusing the same value as the complement
  // set up left/right pointers, we will use the values they point to to determine what we need from the 3rd
  // number in order to reach 0
  // loop through input with two pointers [-2,-1,-1,0,2]
  //                                        L  R  => need 3 in this case
  // 0 - L - R == val we need to make a triple that = 0
  // if next val for L or R is == to prev L or prev R, skip in order to avoid duplicates

  List<List<Integer>> solution(int[] nums) {
    if (nums == null || nums.length < 3) return List.of();
    Arrays.sort(nums);
    var counts = initializeCountMap(nums);
    var triplets = new ArrayList<List<Integer>>();
    int prevLeft = nums[0], prevRight = nums[1];
    for (int left = 0; left < nums.length - 2; left++) {
      if (left > 0 && prevLeft == nums[left]) continue;
      for (int right = left + 1; right < nums.length - 1; right++) {
        if (right > 1 && nums[right] == prevRight) continue;
        int valNeeded = 0 - nums[left] - nums[right];
        if (checkForTriplet(valNeeded, right, left, nums, counts)) {
          triplets.add(List.of(nums[left], nums[right], valNeeded));
        }
        prevRight = nums[right];
      }
      prevLeft = nums[left];
    }
    return triplets;
  }

  boolean checkForTriplet(int valNeeded, int rightIndex, int leftIndex, int[] input, Map<Integer, Integer> count) {
    if (input[rightIndex] > valNeeded) return false;
    else if (!count.containsKey(valNeeded)) return false;
    if (valNeeded == input[leftIndex] || valNeeded == input[rightIndex]) {

      return valNeeded == 0 ? count.get(valNeeded) > 2 : count.get(valNeeded) > 1;
    }
    return true;
  }

  Map<Integer, Integer> initializeCountMap(int[] input) {
    Map<Integer, Integer> intCount = new HashMap<>();
    for (int val : input) {
      intCount.compute(val, (key, currentVal) -> currentVal == null ? 1 : currentVal + 1);
    }
    return intCount;
  }

}
