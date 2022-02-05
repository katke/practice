package educative.codinginterviewpatterns.bfs;

import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelAverages {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/YQWkA2l67GW";

  /*
  * Given a binary tree, populate an array to represent the averages of all of its levels.
  * */

  List<Double> solution(TreeNode root) {
    if (root == null) throw new IllegalArgumentException("Root node cannot be null");
    Deque<TreeNode> nodes = new ArrayDeque<>();
    nodes.add(root);
    List<Double> result = new ArrayList<>();
    TreeNode current;
    while (!nodes.isEmpty()) {
      int rowSize = nodes.size();
      double rowSum = 0;
      for (int i = 0; i < rowSize; i++) {
        current = nodes.removeFirst();
        rowSum += current.val;
        if (current.left != null) {
          nodes.addLast(current.left);
        }
        if (current.right != null) {
          nodes.addLast(current.right);
        }
      }
      result.add(rowSum / rowSize);
    }
    return result;
  }
}
