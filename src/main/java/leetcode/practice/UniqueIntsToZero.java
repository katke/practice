package leetcode.practice;

import shared.PracticeStatus;

public class UniqueIntsToZero {
  String source = "https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n / 2)";
  String spaceComplexity = "O(n)";
  /*
   * Given an integer n, return any array containing n unique integers such that they add up to 0.
   * */

  int[] solution(int n) {
    if (n == 0) return new int[]{};
    else if (n == 1) return new int[]{0};
    int[] result = new int[n];
    int midpoint = n / 2;
    int left = midpoint - 1;
    int right = n % 2 != 0 ? midpoint + 1 : midpoint;
    int val = 1;
    while (right < n) {
      result[right] = val;
      result[left] = val * -1;
      right++;
      left--;
      val++;
    }
    return result;
  }
}
