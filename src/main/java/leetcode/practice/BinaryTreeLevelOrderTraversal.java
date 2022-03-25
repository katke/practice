package leetcode.practice;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
  String source = "https://leetcode.com/problems/binary-tree-level-order-traversal/solution/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*
Given the root of a binary tree, return the level order traversal of its nodes' values.
(i.e., from left to right, level by level).

*/

  List<List<Integer>> solution(TreeNode root) {
    if (root == null) return List.of();
    var result = new ArrayList<List<Integer>>();
    var queue = new ArrayDeque<TreeNode>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      var numNodesAtLevel = queue.size();
      var nodes = new ArrayList<Integer>();
      for (int i = 0; i < numNodesAtLevel; i++) {
        var currentNode = queue.removeFirst();
        nodes.add(currentNode.val);
        if (currentNode.left != null) queue.addLast(currentNode.left);
        if (currentNode.right != null) queue.addLast(currentNode.right);
      }
      result.add(nodes);
    }
    return result;
  }
}
