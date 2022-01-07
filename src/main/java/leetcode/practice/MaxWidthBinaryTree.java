package leetcode.practice;

import leetcode.commontypes.NodeIndexTuple;
import leetcode.commontypes.TreeNode;
import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxWidthBinaryTree implements PracticeProblem {
  String source = "https://leetcode.com/problems/maximum-width-of-binary-tree/";
  PracticeStatus practiceStatus = PracticeStatus.FAIL_IMPLEMENTATION; // Passes 109/111 test cases, SO CLOSE

  public int solution(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int result = 1;
    Deque<NodeIndexTuple> queue = new ArrayDeque<>();
    queue.add(new NodeIndexTuple(root, 1));
    int rowEndIndex = 1;
    while (!queue.isEmpty()) {
      NodeIndexTuple currentNode = queue.remove();
      if (currentNode.node.left != null) {
        queue.add(new NodeIndexTuple(currentNode.node.left, leftNodeIndex(currentNode.index)));
      }
      if (currentNode.node.right != null) {
        queue.add(new NodeIndexTuple(currentNode.node.right, rightNodeIndex(currentNode.index)));
      }

      NodeIndexTuple firstItem = queue.peekFirst();
      if (firstItem == null) {
        break;
      } else if (firstItem.index > rowEndIndex) { // Indicates we've started a new row
        rowEndIndex = rightNodeIndex(rowEndIndex);
        NodeIndexTuple lastItem = queue.getLast();
        result = Math.max(result, lastItem.index - firstItem.index + 1);
      }
    }
    return result;
  }

  private int leftNodeIndex(int parentIndex) {
    return parentIndex * 2;
  }

  private int rightNodeIndex(int parentIndex) {
    return leftNodeIndex(parentIndex) + 1;
  }
}
