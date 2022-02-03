package leetcode.practice;

import shared.commontypes.NodeIndexTuple;
import shared.commontypes.TreeNode;
import shared.PracticeProblem;
import shared.PracticeStatus;
import java.util.ArrayDeque;

public class MaximumDepthBinaryTree implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.FAIL_OPTIMIZATION; // recursive accepted, iterative 37 / 39 test cases passing
  String source = "https://leetcode.com/problems/maximum-depth-of-binary-tree/";

  int iterativeApproach(TreeNode root) {
    if (root == null) {
      return 0;
    }
    var bfsQueue = new ArrayDeque<NodeIndexTuple>();
    bfsQueue.add(new NodeIndexTuple(root, 1));
    var result = 0;
    var newDepthIndex = 0;

    while (!bfsQueue.isEmpty()) {
      var currentNode = bfsQueue.remove();
      if (currentNode.index > newDepthIndex) {
        result++;
        newDepthIndex = newDepthIndex * 2 + 1;
      }
      var leftNode = currentNode.node.left;
      var rightNode = currentNode.node.right;
      if (leftNode != null) {
        bfsQueue.add(new NodeIndexTuple(leftNode, currentNode.index * 2));
      }
      if (rightNode != null) {
        bfsQueue.add(new NodeIndexTuple(rightNode, currentNode.index * 2 + 1));
      }

    }
    return result;
  }

  int recursiveApproach(TreeNode currentRoot) {
    if (currentRoot == null) {
      return 0;
    }
    var leftRecursive = recursiveApproach(currentRoot.left);
    var rightRecursive = recursiveApproach(currentRoot.right);
    return Math.max(leftRecursive, rightRecursive) + 1;
  }

}
