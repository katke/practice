package educative.codinginterviewpatterns.twopointers;

import shared.PracticeStatus;

import java.util.Arrays;

public class TripletWithSumNearTarget {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "O(n^3)";
  String spaceComplexity = "O(1)";

  /*
  * Given an array of unsorted numbers and a target number, find a triplet
  *  in the array whose sum is as close to the target number as possible,
  * return the sum of the triplet. If there are more than one such triplet,
  * return the sum of the triplet with the smallest sum.
  * */
  int searchTriplet(int[] arr, int targetSum) {
    // use two pointers to check two ints at a time, then
    // progress through the arr for the third num,
    // keeping track of the diff from that sum to the targetSum
    // if the diff is smaller than it was previously, the new
    // result will be the sum of those three current ints
    // if the diff is the same, result will be the smaller sum
    if (arr == null || arr.length < 3) throw new IllegalArgumentException("Array cannot be null or smaller than 3");
    System.out.println("Input arr: " + Arrays.toString(arr) + ", targetSum: " + targetSum);
    int resultSum = 0, left = 0, right = 1, targetDiff = Integer.MAX_VALUE;
    while (left < arr.length - 2) {
      for (int i = right + 1; i < arr.length; i++) {
        System.out.println("current nums: " + arr[left] + ", " + arr[right] + ", " + arr[i]);
        var currentSum = arr[left] + arr[right] + arr[i];
        System.out.println("currentSum: " + currentSum);
        var diffFromTarget = Math.abs(targetSum - currentSum);
        System.out.println("diffFromTarget: " + diffFromTarget);
        System.out.println("targetDiff: " + targetDiff);
        if (diffFromTarget < targetDiff) {
          resultSum = currentSum;
          targetDiff = diffFromTarget;
          System.out.println("newResultSum: " + resultSum);
          System.out.println("newTargetDiff: " + targetDiff);
        } else if (diffFromTarget == targetDiff) {
          resultSum = Math.min(currentSum, resultSum);
        }
        System.out.println("-----------------------------");
      }
      if (right < arr.length - 1) {
        right++;
      } else {
        left++;
        right = left + 1;
      }
    }

    return resultSum;
  }
}
