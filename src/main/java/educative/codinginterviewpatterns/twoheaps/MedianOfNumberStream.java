package educative.codinginterviewpatterns.twoheaps;

import shared.PracticeStatus;

import java.util.PriorityQueue;

public class MedianOfNumberStream {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(logn) for insertion, O(1) for findMedian()";
  String spaceComplexity = "O(n)";

  private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
  private final PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

  void insertNum(int num) {
    if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }

    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  double findMedian() {
    if (minHeap.isEmpty() && maxHeap.isEmpty()) {
      throw new IllegalStateException("Cannot find median from empty number stream");
    }
    if (minHeap.size() == maxHeap.size()) {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    } else {
      return maxHeap.isEmpty() ? minHeap.peek() : maxHeap.peek();
    }
  }
}
