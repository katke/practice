package educative.codinginterviewpatterns.bfs;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.*;

public class TreeLevelSubarrays {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/xV7E64m4lnz";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "O(n), where n = total number of tree nodes";
  String spaceComplexity = "O(w), where w = maximum width of tree";

  /*
   * Given a binary tree, populate an array to represent its level-by-level traversal.
   * You should populate the values of all nodes of each level from left to right in
   * separate sub-arrays.
   * */
  List<List<Integer>> solution(TreeNode root) {
    if (root == null) throw new IllegalArgumentException("Tree root cannot be null");
    Deque<TreeNode> nodes = new ArrayDeque<>();
    nodes.add(root);
    TreeNode current;
    List<List<Integer>> result = new ArrayList<>();
    while (!nodes.isEmpty()) {
      var rowSize = nodes.size();
      var row = new ArrayList<Integer>();
      for (int i = 0; i < rowSize; i++) {
        current = nodes.removeFirst();
        row.add(current.val);
        if (current.left != null) {
          nodes.addLast(current.left);
        }
        if (current.right != null) {
          nodes.addLast(current.right);
        }
      }
      result.add(row);
    }
    return result;
  }

}
