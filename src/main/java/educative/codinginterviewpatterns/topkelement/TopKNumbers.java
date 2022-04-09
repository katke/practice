package educative.codinginterviewpatterns.topkelement;

import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TopKNumbers {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/RM535yM9DW0";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O((log(k)) * n) + (n - k)";
  String spaceComplexity = "O(k)";
  /*
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
   */

  List<Integer> minHeapSolution(int[] nums, int k) {
    if (nums == null || k == 0 || nums.length < k) return List.of();
    var result = new ArrayList<Integer>();
    var minHeap = new PriorityQueue<Integer>();
    for (int i = 0; i < k; i++) {
      minHeap.add(nums[i]);
    }
    for (int i = k; i < nums.length; i++) {
      var minHeapVal = minHeap.peek();
      if (minHeapVal < nums[i]) {
        minHeap.remove();
        minHeap.add(nums[i]);
      }
    }
    return new ArrayList<>(minHeap);
  }

  List<Integer> maxHeapSolution(int[] nums, int k) {
    if (nums == null || k == 0 || nums.length < k) return List.of();
    var result = new ArrayList<Integer>();
    var maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
    for (var num : nums) {
      maxHeap.add(num);
    }
    for (int i = 0; i < k; i++) {
      result.add(maxHeap.remove());
    }
    return result;
  }

  List<Integer> bruteForceSolution(int[] nums, int k) {
    if (nums == null || k == 0) return List.of();
    var result = new ArrayList<Integer>();
    if (nums.length < k) {
      for (int num : nums) {
        result.add(num);
      }
      return result;
    }
    Arrays.sort(nums);
    for (var i = nums.length - 1; i > (nums.length - k - 1); i--) {
      result.add(nums[i]);
    }
    return result;
  }
}
