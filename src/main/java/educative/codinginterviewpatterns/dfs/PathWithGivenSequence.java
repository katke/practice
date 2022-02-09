package educative.codinginterviewpatterns.dfs;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

public class PathWithGivenSequence {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/m280XNlPOkn";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n)";

  /*
  * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
  * */
  boolean solution(TreeNode root, int[] sequence) {
    if (root == null || sequence == null || sequence.length < 1) return false;
    return traverseTree(root, 0, sequence);
  }

  boolean traverseTree(TreeNode node, int index, int[] sequence) {
    if (node == null) {
      return index == sequence.length;
    }
    if (node.val == sequence[index]) {
      return traverseTree(node.left, index + 1, sequence) ||
          traverseTree(node.right, index + 1, sequence);
    } else {
      return false;
    }

  }
}
