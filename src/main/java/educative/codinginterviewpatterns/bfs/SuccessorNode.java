package educative.codinginterviewpatterns.bfs;

import shared.PracticeStatus;
import shared.commontypes.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SuccessorNode {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/7nO4VmA74Lr";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n)";
  /*
  * Given a binary tree and a node, find the level order successor of the given node in the tree. The
  * level order successor is the node that appears right after the given node in the level order traversal.
  * */

  TreeNode solution(TreeNode root, int key) {
    if (root == null) throw new IllegalArgumentException("Root cannot be null");
    Deque<TreeNode> nodes = new ArrayDeque<>();
    nodes.addLast(root);
    boolean targetNextNode = false;
    while (!nodes.isEmpty()) {
      int levelSize = nodes.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = nodes.removeFirst();
        if (targetNextNode) {
          return currentNode;
        }
        if (currentNode.val == key) {
          targetNextNode = true;
        }
        if (currentNode.left != null) {
          nodes.addLast(currentNode.left);
        }
        if (currentNode.right != null) {
          nodes.addLast(currentNode.right);
        }
      }
    }
    throw new IllegalArgumentException("No node with expected key value found");
  }
}
