package educative.codinginterviewpatterns.kwaymerge;

import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
  String source = "";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*

*/

  List<Integer> solution(int[][] input) {
    if (input == null || input.length == 0) return List.of();
    var minHeap = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.val));
    var result = new ArrayList<Integer>();
    for (int i = 0; i < input.length; i++) {
      minHeap.add(new Node(i,0, input[i][0]));
    }
    while (!minHeap.isEmpty()) {
      var next = minHeap.remove();
      result.add(next.val);
      if (next.col + 1 < input[next.row].length) {
        minHeap.add(new Node(next.row, next.col + 1, input[next.row][next.col + 1]));
      }
    }
    return result;
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
