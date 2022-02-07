package educative.codinginterviewpatterns.bfs;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDepth {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3jwVx84OMkO";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n)";

  /*
  * Find the minimum depth of a binary tree. The minimum depth is the number of nodes along
  * the shortest path from the root node to the nearest leaf node.
  * */

  int solution(TreeNode root) {
    if (root == null) throw new IllegalArgumentException("root cannot be null");
    Deque<TreeNode> nodes = new ArrayDeque<>();
    nodes.addLast(root);
    int level = 0;
    while (!nodes.isEmpty()) {
      level++;
      int rowSize = nodes.size();
      for (int i = 0; i < rowSize; i++) {
        var currentNode = nodes.removeFirst();
        if (currentNode.right == null && currentNode.left == null) {
          return level;
        }
        if (currentNode.left != null) {
          nodes.addLast(currentNode.left);
        }
        if (currentNode.right != null) {
          nodes.addLast(currentNode.right);
        }
      }
    }
    return level;
  }
}
