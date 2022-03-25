package leetcode.practice;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;

public class MinDepthBinaryTree {
  String source = "https://leetcode.com/problems/minimum-depth-of-binary-tree/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*

*/

  int bfsIterativeSolution(TreeNode root) {
    if (root == null) return 0;
    var queue = new ArrayDeque<TreeNode>();
    queue.addLast(root);
    var minDepth = 0;
    while (!queue.isEmpty()) {
      var levelSize = queue.size();
      minDepth++;
      for (int i = 0; i < levelSize; i++) {
        var currentNode = queue.removeFirst();
        if (currentNode.right == null && currentNode.left == null) {
          return minDepth;
        }
        if (currentNode.left != null) queue.addLast(currentNode.left);
        if (currentNode.right != null) queue.addLast(currentNode.right);
      }
    }
    return minDepth;
  }

  int dfsRecursiveSolution(TreeNode root) {
    if (root == null) return 0;
    return findMinDepth(root, 1);
  }

  int findMinDepth(TreeNode node, int depth) {
    if (node.right == null && node.left == null) return depth;
    if (node.right != null && node.left != null) {
      return Math.min(findMinDepth(node.left, depth + 1), findMinDepth(node.right, depth + 1));
    }
    if (node.right != null) {
      return findMinDepth(node.right, depth + 1);
    }
    return findMinDepth(node.left, depth + 1);
  }
}
