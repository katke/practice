package educative.codinginterviewpatterns.dfs;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

public class SumOfPathNums {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/YQ5o5vEXP69";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n)";
  /*
  * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will
  * represent a number. Find the total sum of all the numbers represented by all paths.
  * */
  int solution(TreeNode root) {
    if (root == null) return 0;
    return traverseToLeaf(root, 0);
  }

  int traverseToLeaf(TreeNode currentNode, int currentNum) {
    if (currentNode == null) {
      return 0;
    }
    if (currentNode.left == null && currentNode.right == null) {
      return (currentNum * 10) + currentNode.val;
    }
    return traverseToLeaf(currentNode.left, (currentNum * 10) + currentNode.val) +
        traverseToLeaf(currentNode.right, (currentNum * 10) + currentNode.val);
  }
}
