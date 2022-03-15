package leetcode.practice;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

public class NumGoodNodes {
  String source = "https://leetcode.com/problems/count-good-nodes-in-binary-tree/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*
  * Given a binary tree root, a node X in the tree is named good if in the path from root to X
  * there are no nodes with a value greater than X.
  * Return the number of good nodes in the binary tree.
  * */

  int solution(TreeNode root) {
    if (root == null) return 0;
    return checkNextChild(root.val - 1, root);
  }

  int checkNextChild(int currentMax, TreeNode currentNode) {
    if (currentNode == null) {
      return 0;
    }
    int currentNodeCount = currentNode.val < currentMax ? 0 : 1;
    int maxNodeVal = Math.max(currentMax, currentNode.val);
    return currentNodeCount + checkNextChild(maxNodeVal, currentNode.left)
          + checkNextChild(maxNodeVal, currentNode.right);
  }
}
