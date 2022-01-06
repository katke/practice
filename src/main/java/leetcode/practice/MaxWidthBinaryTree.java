package leetcode.practice;

import leetcode.commontypes.NodeIndexTuple;
import leetcode.commontypes.TreeNode;
import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

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

  @Override
  public Map<String, List<TreeNode>> getTestCases() {
    return Map.of(
        "1. Expect 8", List.of(outerNodesOnly()),
        "2. Expect 4", List.of(mixOfInnerOuterNodes()),
        "3. Expect 4", List.of(moreInnerNodes()),
        "4. Expect 1", List.of(oneSidedTree()),
        "5: Expect 1", List.of(singleNode()));
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

  private TreeNode mixOfInnerOuterNodes() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(4);

    root.right.right = new TreeNode(9);

    return root;
  }

  private TreeNode moreInnerNodes() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(8);

    root.right = new TreeNode(3);
    root.right.right = new TreeNode(6);
//    root.right.right.right = new TreeNode(11);
    root.right.left = new TreeNode(5);
    root.right.left.left = new TreeNode(9);
    root.right.left.right = new TreeNode(10);

    return root;
  }

  private TreeNode oneSidedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.left.left.left.left = new TreeNode(5);
    return root;
  }

  private TreeNode singleNode() {
    return new TreeNode(1);
  }
}
