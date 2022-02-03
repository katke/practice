package leetcode.practice;

import shared.commontypes.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MaxWidthBinaryTreeTest {

  MaxWidthBinaryTree maxWidthBinaryTree = new MaxWidthBinaryTree();

  @ParameterizedTest
  @MethodSource("generateTestCases")
  void testSolution(TreeNode rootNode, int expectedWidth) {
    var actual = maxWidthBinaryTree.solution(rootNode);
    assertEquals(expectedWidth, actual);
  }

  private static Stream<Arguments> generateTestCases() {
    return Stream.of(
        arguments(outerNodesOnly(), 8),
        arguments(mixOfInnerOuterNodes(), 4),
        arguments(moreInnerNodes(), 4),
        arguments(oneSidedTree(), 1),
        arguments(singleNode(), 1));
  }

  private static TreeNode outerNodesOnly() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);

    root.left.left = new TreeNode(5);
    root.right.right = new TreeNode(9);

    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return root;
  }

  private static TreeNode mixOfInnerOuterNodes() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);

    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(4);

    root.right.right = new TreeNode(9);

    return root;
  }

  private static TreeNode moreInnerNodes() {
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

  private static TreeNode oneSidedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.left.left.left.left = new TreeNode(5);
    return root;
  }

  private static TreeNode singleNode() {
    return new TreeNode(1);
  }

}
