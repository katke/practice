package educative.codinginterviewpatterns.twopointers;

import shared.PracticeStatus;

import java.util.Arrays;

public class TripletSumLessThanTarget {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/mElknO5OKBO";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n^2)";
  String spaceComplexity = "O(n)";
  /*
  * Given an array arr of unsorted numbers and a target sum, count
  * all triplets in it such that arr[i] + arr[j] + arr[k] < target where
  * i, j, and k are three different indices. Write a function to return the
  * count of such triplets.
  * */

  int searchTriplets(int[] arr, int target) {
    if (arr == null || arr.length < 3)
      throw new IllegalArgumentException("Can't find triplet without at least three items");
    Arrays.sort(arr);
    int tally = 0;
    System.out.println("sorted arr: " + Arrays.toString(arr) + ", target: " + target);
    for (int i = 0; i < arr.length - 2; i++) {
      tally += findTriplets(arr, target - arr[i], i);
    }
    return tally;
  }

  int findTriplets(int[] arr, int targetSum, int startingIndex) {
    // target sum here is diff between starting index item and the original target number, which translates to
    // the maximum sum that the other two items in the triplet can be while still ensuring the full triplet
    // will be below the original target number (maximum exclusive, the other two items summed must be less)
    int left = startingIndex + 1, right = arr.length - 1, matches = 0;
    while (left < right) {
      System.out.println("Current nums: " + arr[startingIndex] + ", " + arr[left] + ", " + arr[right]);
      System.out.println("targetSum: " + targetSum);
      if (arr[left] + arr[right] < targetSum) {
        System.out.println("adding " + (right - left) + ", incrementing left");
        matches += (right - left);
        left++;
      } else {
        System.out.println("sum too large, decrementing right");
        right--;
      }
      System.out.println("--------------------");
    }
    return matches;
  }
}
