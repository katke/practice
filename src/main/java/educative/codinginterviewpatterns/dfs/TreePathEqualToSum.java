package educative.codinginterviewpatterns.dfs;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreePathEqualToSum {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/RMlGwgpoKKY";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n)";
  /*
  * Given a binary tree and a number ‘S’, find if the tree has a path from
  * root-to-leaf such that the sum of all the node values of that path equals ‘S’.
  * */
  boolean solution(TreeNode root, int sum) {
    if (root == null) return false;
    return getSum(root, 0, sum);
  }

  boolean getSum(TreeNode currentNode, int currentSum, int targetSum) {
    if (currentNode == null) {
      return currentSum == targetSum;
    }
    return getSum(currentNode.right, currentSum + currentNode.val, targetSum) ||
        getSum(currentNode.left, currentSum + currentNode.val, targetSum);
  }

}
