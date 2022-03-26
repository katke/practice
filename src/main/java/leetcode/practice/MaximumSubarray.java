package leetcode.practice;

import shared.PracticeStatus;

import java.util.Arrays;

public class MaximumSubarray {
  String source = "https://leetcode.com/problems/maximum-subarray/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the
largest sum and return its sum.

A subarray is a contiguous part of an array.
*/

  int solution(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    else if (nums.length == 1) return nums[0];
    int maxSum = Integer.MIN_VALUE, currentSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      System.out.println(i + ": " + nums[i]);
      int num = nums[i];
      currentSum = Math.max(num, currentSum + num);
      System.out.println("currentSum: " + currentSum);
      maxSum = Math.max(maxSum, currentSum);
      System.out.println("maxSum: " + maxSum);
      System.out.println("-".repeat(10));
    }
    return maxSum;
  }

  int divideAndConquerSolution(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    else if (nums.length == 1) return nums[0];
    int midpoint = nums.length / 2;
    int bestLeft = bestSum(Arrays.copyOfRange(nums, 0, midpoint), true);
    int bestRight = bestSum(Arrays.copyOfRange(nums, midpoint, nums.length), false);
    if (bestRight < bestLeft) {
      return Math.max(bestRight + bestLeft, bestLeft);
    } else {
      return Math.max(bestRight + bestLeft, bestRight);
    }
  }

  int bestSum(int[] nums, boolean goLeft) {
    int maxSum = nums[0], currSum = 0;
    if (goLeft) {
      for (int i = nums.length - 1; i >= 0; i--) {
        currSum += nums[i];
        maxSum = Math.max(maxSum, currSum);
      }
    } else {
      for (int i = 0; i < nums.length; i++) {
        currSum += nums[i];
        maxSum = Math.max(maxSum, currSum);
      }
    }
    return maxSum;
  }
}
