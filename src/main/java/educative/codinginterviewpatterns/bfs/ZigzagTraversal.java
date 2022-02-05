package educative.codinginterviewpatterns.bfs;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigzagTraversal {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/qVA27MMYYn0";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(w), w = max width of any rows";
  /*
  * Given a binary tree, populate an array to represent its zigzag level order traversal.
  * You should populate the values of all nodes of the first level from left to right, then
  * right to left for the next level and keep alternating in the same manner for the following levels.
  * */
  List<List<Integer>> solution(TreeNode root) {
    if (root == null) throw new IllegalArgumentException("Tree root cannot be null");
    Deque<TreeNode> nodes = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    nodes.addLast(root);
    int row = 0;
    TreeNode current;
    while (!nodes.isEmpty()) {
      row++;
      int rowSize = nodes.size();
      List<Integer> rowNodeValues = new ArrayList<>();
      for (int i = 0; i < rowSize; i++) {
        current = nodes.removeFirst();
        if (row % 2 == 0) {
          rowNodeValues.add(0, current.val);
        } else {
          rowNodeValues.add(current.val);
        }
        if (current.left != null) nodes.addLast(current.left);
        if (current.right != null) nodes.addLast(current.right);
      }
      result.add(rowNodeValues);
    }
    return result;
  }

}
