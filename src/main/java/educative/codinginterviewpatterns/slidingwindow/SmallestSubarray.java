package educative.codinginterviewpatterns.slidingwindow;

import shared.PracticeStatus;

public class SmallestSubarray {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ";
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";

  /*
  Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest
  contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
  */
  int findMinSubArray(int s, int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    else if (arr.length == 1) {
      return arr[0] >= s ? 1 : 0;
    }
    var smallestWindow = Integer.MAX_VALUE;
    var left = 0;
    var right = 1;
    var currentWindowSum = arr[left] + arr[right];
    while (left < arr.length) {
        if (currentWindowSum >= s) {
          smallestWindow = Math.min(smallestWindow, right - left + 1);
          currentWindowSum -= arr[left];
          left++;
        } else {
          if (right == arr.length - 1) {
            currentWindowSum -= arr[left];
            left++;
          } else {
            right++;
            currentWindowSum += arr[right];
          }
        }
    }
   return smallestWindow == Integer.MAX_VALUE ? 0 : smallestWindow;
  }

}
