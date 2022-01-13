package educative.codinginterviewpatterns.slidingwindow;

import shared.PracticeStatus;

import java.util.Arrays;

public class MaxSumOfSubarraySizeK {
  // non sliding window — sort array, take last K elements and sum

  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP";
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";

  int findMaxSumSubArray(int k, int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    else if (arr.length < k) return Arrays.stream(arr).sum();
    var right = k;
    var windowSum = findFirstKItemSum(Arrays.copyOfRange(arr, 0, k));
    int max = windowSum;
    for (var left = 1; left < arr.length - k + 1; left++) {
      var incomingVal = arr[right];
      var outgoingVal = arr[left - 1];
      windowSum -= outgoingVal;
      windowSum += incomingVal;
      max = Math.max(windowSum, max);
      right++;
    }
    return max;
  }

  private int findFirstKItemSum(int[] subarray) {
    return Arrays.stream(subarray).sum();
  }

}
