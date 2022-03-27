package leetcode.practice;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

public class InvertBinaryTree {
  String source = "https://leetcode.com/problems/invert-binary-tree/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(H)";
  /*
Given the root of a binary tree, invert the tree, and return its root.
*/

  TreeNode solution(TreeNode root) {
    if (root == null || (root.right == null && root.left == null)) return root;
    invert(root);
    return root;
  }

  void invert(TreeNode node) {
    if (node == null) return;
    var currentRight = node.right;
    var currentLeft = node.left;
    node.right = currentLeft;
    node.left = currentRight;
    invert(node.left);
    invert(node.right);
  }
}
