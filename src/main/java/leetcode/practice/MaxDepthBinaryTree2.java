package leetcode.practice;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;

public class MaxDepthBinaryTree2 { // 2022 review
  String source = "https://leetcode.com/problems/maximum-depth-of-binary-tree/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*

*/

  int dfsRecursiveSolution(TreeNode root) {
    if (root == null) return 0;
    return Math.max(checkDepth(root.left, 1), checkDepth(root.right, 1));
  }

  int checkDepth(TreeNode node, int depth) {
    if (node == null) return depth;
    return Math.max(checkDepth(node.left, depth + 1), checkDepth(node.right, depth + 1));
  }

  int bfsIterativeSolution(TreeNode root) {
    if (root == null) return 0;
    int maxDepth = 0;
    var queue = new ArrayDeque<TreeNode>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      var levelSize = queue.size();
      maxDepth++;
      for (int i = 0; i < levelSize; i++) {
        var current = queue.removeFirst();
        if (current.left != null) queue.addLast(current.left);
        if (current.right != null) queue.addLast(current.right);
      }
    }
    return maxDepth;
  }
}
