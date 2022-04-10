package educative.codinginterviewpatterns.topkelement;

import shared.PracticeStatus;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/B89rvR6XZ3J";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n + (n * log(k)))";
  String spaceComplexity = "O(n + k)";
  /*

*/

  List<Integer> solution(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 1) return List.of();
    var freq = new HashMap<Integer, Integer>();
    var minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(Comparator.comparingInt(Map.Entry::getValue));
    for (var num : nums) {
      freq.compute(num, (key, currVal) -> currVal == null ? 1 : currVal + 1);
    }
    for (var entry : freq.entrySet()) {
      var frequency = entry.getValue();
      if (minHeap.size() < k) {
        minHeap.add(entry);
      } else if (minHeap.peek().getValue() < frequency) {
        minHeap.remove();
        minHeap.add(entry);
      }
    }
    return minHeap.stream().map(Map.Entry::getKey).collect(Collectors.toList());
  }
}
