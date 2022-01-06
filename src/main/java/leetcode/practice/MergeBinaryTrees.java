package leetcode.practice;

import leetcode.commontypes.TreeNode;
import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.ArrayDeque;
import java.util.Deque;

public class MergeBinaryTrees implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://leetcode.com/problems/merge-two-binary-trees/";

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (null == t1 && null == t2) {
      return null;
    } else if (null == t1) {
      return t2;
    } else if (null == t2) {
      return t1;
    }

    Deque<TreeNode[]> nodeDeque = new ArrayDeque<>();
    nodeDeque.push(new TreeNode[]{t1, t2});

    while (!nodeDeque.isEmpty()) {
      TreeNode[] current = nodeDeque.pop();
      TreeNode t1Node = current[0];
      TreeNode t2Node = current[1];

      if (null == t1Node || null == t2Node) {
        continue;
      }
      t1Node.val += t2Node.val;

      if (null != t1Node.right) {
        nodeDeque.push(new TreeNode[] {t1Node.right, t2Node.right});
      } else {
        t1Node.right = t2Node.right;
      }

      if (null != t1Node.left) {
        nodeDeque.push(new TreeNode[] {t1Node.left, t2Node.left});
      } else {
        t1Node.left = t2Node.left;
      }

    }
    return t1;
  }
}
