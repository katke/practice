package educative.codinginterviewpatterns.kwaymerge;

import shared.PracticeStatus;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKthSmallestElement {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/myAqDMyRXn3";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
*/

  // still under construction
  int solution(List<Integer[]> lists, int k) {
    if (lists == null || lists.isEmpty() || k < 1) throw new RuntimeException();
    var maxHeap = new PriorityQueue<Node>(Comparator.comparingInt(node -> node.val));
    for (int i = 0; i < lists.size(); i++) { // need to make sure heap contains k elements from get go or this won't work
      if (maxHeap.size() < k) {
        maxHeap.add(new Node(i, 0, lists.get(i)[0]));
      }
    }
    int startingRow = lists.size() / k;
    int startingCol = lists.size() % k;
    for (int i = 0; i < lists.size(); i++) {
      for (int j = 0; j < lists.get(i).length; j++) {
        if (i > startingRow && j > startingCol) {
          if (maxHeap.peek().val > lists.get(i)[j]) {
            maxHeap.remove();
            maxHeap.add(new Node(i, j, lists.get(i)[j]));
          }
        }
      }
    }
    return maxHeap.peek().val;
  }
  static class Node {
    int col;
    int row;
    int val;

    Node(int row, int col, int val) {
      this.val = val;
      this.row = row;
      this.col = col;
    }
  }
}
