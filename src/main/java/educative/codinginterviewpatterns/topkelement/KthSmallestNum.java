package educative.codinginterviewpatterns.topkelement;

import shared.PracticeStatus;
import java.util.*;

public class KthSmallestNum {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/gxxPGn8vE8G";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(k*log(k) + (n - k) * log(k)) => O(n * log(k))";
  String spaceComplexity = "O(k)";
  /*
Given an unsorted array of numbers, find Kth smallest number in it.

Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
   */

  int solution(int[] nums, int k) {
    if (nums == null || k < 1 || k > nums.length) throw new RuntimeException("");
    var maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
    for (int i = 0; i < k; i++) {
      maxHeap.add(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      if (maxHeap.peek() > nums[i]) {
        maxHeap.remove();
        maxHeap.add(nums[i]);
      }
    }
    return maxHeap.peek();
  }
}
