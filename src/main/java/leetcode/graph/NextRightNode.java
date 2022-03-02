package leetcode.graph;

import shared.PracticeStatus;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextRightNode {
  String source = "https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3895/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;

  /*
  * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
  * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
  * should be set to NULL.
  *
  * Initially, all next pointers will be set to NULL.
  * The number of nodes in the tree is in the range [0, 212 - 1].
  * -1000 <= Node.val <= 1000
  * */

  public Node connect(Node root) {
    if (root == null) return root;
    Deque<Node> queue = new ArrayDeque<>();
    queue.addLast(root);
    while (!queue.isEmpty()){
      int rowSize = queue.size();
      Node prev = null;
      for (int i = 0; i < rowSize; i++) {
        var currentNode = queue.removeFirst();
        if (rowSize > 1 && i > 0) {
          currentNode.next = prev;
        }
        if (currentNode.right != null) {
          queue.addLast(currentNode.right);
        }
        if (currentNode.left != null) {
          queue.addLast(currentNode.left);
        }
        prev = currentNode;
      }
    }
    return root;
  }

  class Node {
    Node next;
    Node right;
    Node left;
    int val;

    Node(Node next, int val, Node right, Node left) {
      this.next = next;
      this.val = val;
      this.right = right;
      this.left = left;
    }

    Node(int val) {
      this.val = val;
    }
  }
}
