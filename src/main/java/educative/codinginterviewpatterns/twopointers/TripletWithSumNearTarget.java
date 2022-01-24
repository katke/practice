package educative.codinginterviewpatterns.twopointers;

import shared.PracticeStatus;

import java.util.Arrays;

public class TripletWithSumNearTarget {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n^2)";
  String spaceComplexity = "O(n)";

  /*
  * Given an array of unsorted numbers and a target number, find a triplet
  *  in the array whose sum is as close to the target number as possible,
  * return the sum of the triplet. If there are more than one such triplet,
  * return the sum of the triplet with the smallest sum.
  * */
  int searchTriplet(int[] arr, int targetSum) {
    if (arr == null || arr.length < 3) throw new IllegalArgumentException("Array cannot be null or smaller than 3");
    Arrays.sort(arr);
    int smallestDiff = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      int left = i + 1, right = arr.length - 1;
      while (left < right) {
        int currentDiff = targetSum - arr[i] - arr[left] - arr[right]; //helps avoid int overflow this way
        if (currentDiff == 0)
          return targetSum;

        if (Math.abs(currentDiff) < Math.abs(smallestDiff)
            || (Math.abs(currentDiff) == Math.abs(smallestDiff) && currentDiff > smallestDiff))
          smallestDiff = currentDiff;

        if (currentDiff > 0) {
          left++;
        } else {
          right--;
        }
      }
    }
      return targetSum - smallestDiff;
    }
}
