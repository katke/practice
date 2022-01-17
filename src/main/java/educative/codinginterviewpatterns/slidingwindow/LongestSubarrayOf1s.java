package educative.codinginterviewpatterns.slidingwindow;

import shared.PracticeStatus;

import java.util.Arrays;

public class LongestSubarrayOf1s {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/B6VypRxPolJ";
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";

  /*
  * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
  * find the length of the longest contiguous subarray having all 1s.
  * */

  // left/right pointers = 0
  // keep track of current sum of items as pointers move
  // the diff of the sum and the current length tells us how many 0's are in the window
  // and therefore whether we've exceeded k replacements
  // typical sliding window: move right pointer while condition is not yet met
  // once condition is exceeded, start contracting window with left pointer
  int findLength(int[] arr, int k) {
    if (arr == null || arr.length == 0) return 0;
    int maxLength = -1, currentSum = 0, left = 0, right = 0, kUsed = 0;
    while (left < arr.length) {
      var currentWindowSize = right - left + 1;
      kUsed = currentWindowSize - currentSum;
      if (kUsed <= k) {
        maxLength = Math.max(maxLength, currentWindowSize);
        if (right < arr.length - 1) {
          right++;
          currentSum += arr[right];
        } else {
          currentSum -= arr[left];
          left++;
        }
      } else {
        currentSum -= arr[left];
        left++;
      }
    }
    return maxLength;
  }

//  void debugLogs(int currentSum, int[] arr, int k, int kUsed, int maxLength, int right, int left) {
//    try {
//      var window = Arrays.copyOfRange(arr, left, right + 1);
//      System.out.println("CurrentWindow: " + Arrays.toString(window));
//      System.out.println("currentSum: " + currentSum);
//      System.out.println("kUsed: " + kUsed);
//      System.out.println(" left: " + left + ", right: " + right);
//      System.out.println("-----------------------");
//    } catch (IndexOutOfBoundsException ex) {
//      System.out.println(ex.toString());
//    }
//  }

}
