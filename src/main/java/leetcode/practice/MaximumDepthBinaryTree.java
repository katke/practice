package leetcode.practice;

import leetcode.commontypes.NodeIndexTuple;
import leetcode.commontypes.TreeNode;
import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.ArrayDeque;
import java.util.Map;

public class MaximumDepthBinaryTree implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.FAIL_OPTIMIZATION; // recursive accepted, iterative 37 / 39 test cases passing
  String source = "https://leetcode.com/problems/maximum-depth-of-binary-tree/";

  public int solution(TreeNode root) {
//    return iterativeApproach(root);
    return recursiveApproach(root);
  }

  private int iterativeApproach(TreeNode root) {
    if (root == null) {
      return 0;
    }
    var bfsQueue = new ArrayDeque<NodeIndexTuple>();
    bfsQueue.add(new NodeIndexTuple(root, 1));
    var result = 0;
    var newDepthIndex = 0;

    while (!bfsQueue.isEmpty()) {
      var currentNode = bfsQueue.remove();
      if (currentNode.index > newDepthIndex) {
        result++;
        newDepthIndex = newDepthIndex * 2 + 1;
      }
      var leftNode = currentNode.node.left;
      var rightNode = currentNode.node.right;
      if (leftNode != null) {
        bfsQueue.add(new NodeIndexTuple(leftNode, currentNode.index * 2));
      }
      if (rightNode != null) {
        bfsQueue.add(new NodeIndexTuple(rightNode, currentNode.index * 2 + 1));
      }

    }
    return result;
  }

  private int recursiveApproach(TreeNode currentRoot) {
    if (currentRoot == null) {
      return 0;
    }
    var leftRecursive = recursiveApproach(currentRoot.left);
    var rightRecursive = recursiveApproach(currentRoot.right);
    return Math.max(leftRecursive, rightRecursive) + 1;
  }

  @Override
  public Map<String, TreeNode> getTestCases() {
    return Map.of(
        "1. Expected 3", lcTestCase1(),
        "2. Expected 1", singleNode(),
        "3. Expected 4", outerNodesOnly(),
        "4. Expected 6", oneSidedTree(),
        "5. Expected 5", unbalancedBinaryTree(),
        "6. Expected 3", balancedBinaryTree()
    );
  }

  private TreeNode lcTestCase1() {
    var root = new TreeNode(3);

    root.right = new TreeNode(20);
    root.left = new TreeNode(9);

    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(15);
    return root;
  }

  private TreeNode singleNode() {
    return new TreeNode(1);
  }

  private TreeNode outerNodesOnly() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);

    root.left.left = new TreeNode(5);
    root.right.right = new TreeNode(9);

    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return root;
  }

  private TreeNode oneSidedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.left.left.left.left = new TreeNode(7);
    root.left.left.left.left.left = new TreeNode(8);
    return root;
  }

  private TreeNode unbalancedBinaryTree() {
    TreeNode root = new TreeNode(3);

    root.left = new TreeNode(5);
    root.left.left = new TreeNode(7);
    root.left.left.left = new TreeNode(9);

    root.right = new TreeNode(6);
    root.right.right = new TreeNode(8);
    root.right.left = new TreeNode(10);
    root.right.left.left = new TreeNode(12);
    root.right.left.left.right = new TreeNode(14);
    return root;
  }

  private TreeNode balancedBinaryTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
      return root;
  }

}
