package leetcode.graph;

import shared.PracticeStatus;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextRightNode {
  String source = "https://leetcode.com/explore/learn/card/graph/620/breadth-first-search-in-graph/3895/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "Iterative BFS: O(n), recursive DFS: O(n)";
  String spaceComplexity = "Iterative BFS: O(n) for queue, recursive DFS: O(n) for call stack";

  /*
  * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
  * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
  * should be set to NULL.
  *
  * Initially, all next pointers will be set to NULL.
  * The number of nodes in the tree is in the range [0, 212 - 1].
  * -1000 <= Node.val <= 1000
  *
  * Follow-up:
  * You may only use constant extra space.
  * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
  * */

  public Node connectIterativeBfs(Node root) {
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

  public Node connectDfs(Node root) {
    if (root == null ) return root;
    setNext(root, null);
    return root;
  }

  void setNext(Node node, Node pointTo) {
    if (node == null) return;
    node.next = pointTo;
    Node rightChildNext = pointTo;
    if (pointTo != null) {
      rightChildNext = pointTo.left;
    }
    setNext(node.left, node.right);
    setNext(node.right, rightChildNext);
  }

  static class Node {
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

    boolean equals(Node otherNode) {
      boolean nextNodeMatches = false;
      boolean rightNodeMatches = false;
      boolean leftNodeMatches = false;
      boolean valMatches = false;
      if (this.next == null) {
        nextNodeMatches = otherNode.next == null;
      } else {
        if (otherNode.next != null) {
          nextNodeMatches = otherNode.next.val == this.next.val;
        }
      }
      if (this.val == otherNode.val) {
        valMatches = true;
      }
      if (this.right == null) {
        rightNodeMatches = otherNode.right == null;
      } else {
        if (otherNode.right != null) {
          rightNodeMatches = otherNode.right.val == this.right.val;
        }
      }
      if (this.left == null) {
        leftNodeMatches = otherNode.left == null;
      } else {
        if (otherNode.left != null) {
          leftNodeMatches = otherNode.left.val == this.left.val;
        }
      }
      return leftNodeMatches && rightNodeMatches && nextNodeMatches && valMatches;
    }
  }
}
