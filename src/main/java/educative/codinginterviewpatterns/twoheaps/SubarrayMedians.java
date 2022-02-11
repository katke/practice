package educative.codinginterviewpatterns.twoheaps;

import shared.PracticeStatus;

import java.util.PriorityQueue;

public class SubarrayMedians {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3Y9jm7XRrXO";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n * k)";
  String spaceComplexity = "O(k)";
  /*
  * Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array
  * */

  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

  double[] solution(int[] nums, int k) {
    if (nums == null || nums.length < k || k < 1) throw new IllegalArgumentException();
    double[] medians = new double[(nums.length / k) + 2];
    int left = 0, right = 0, medianIndex = 0;
    while (left < nums.length - k + 1) {
      addToHeap(nums[right]);
      right++;
      if (right - left == k) {
        medians[medianIndex] = getMedian();
        medianIndex++;
        removeFromHeaps(nums[left]);
        left++;
      }
    }
    return medians;
  }

  double getMedian() {
    if (maxHeap.isEmpty() && minHeap.isEmpty()) {
      throw new IllegalStateException("Cannot get median from empty min and max heaps");
    }
    System.out.println("getMedian()");
    if (maxHeap.size() == minHeap.size()) {
      System.out.println("maxHeap.peek(): " + maxHeap.peek());
      System.out.println("minHeap.peek(): " + minHeap.peek());
      System.out.println("---------");
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    } else {
      System.out.println("maxHeap.peek(): " + maxHeap.peek());
      System.out.println("minHeap.peek(): " + minHeap.peek());
      System.out.println("---------");
      return maxHeap.peek();
    }
  }

  void addToHeap(int num) {
    System.out.println("addToHeap: " + num);
    if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }
    System.out.println("maxHeap: " + maxHeap);
    System.out.println("minHeap: " + minHeap);
    System.out.println("--------------------");
    rebalanceHeaps();
  }

  void removeFromHeaps(int num) {
    System.out.println("removeFromHeaps: " + num);
    if (num <= maxHeap.peek()) {
      maxHeap.remove(num);
    } else {
      minHeap.remove(num);
    }
    System.out.println("maxHeap: " + maxHeap);
    System.out.println("minHeap: " + minHeap);
    System.out.println("--------------------");
    rebalanceHeaps();
  }

  void rebalanceHeaps() {
    System.out.println("rebalanceHeaps()");
    // rebalance heaps if needed
    // if odd number of total items, max heap gets extra
    // else the two should be evenly split
   if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    } else if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    }
    System.out.println("maxHeap: " + maxHeap);
    System.out.println("minHeap: " + minHeap);
    System.out.println("--------------------");
  }

}
