package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MaxDepthBinaryTree2Test {
    MaxDepthBinaryTree2 clazz = new MaxDepthBinaryTree2();

    @ParameterizedTest(name = "dfsRecursiveSolution {index}")
    @MethodSource("testcases")
    void testdfsRecursiveSolution(TreeNode input, int expected) {
      assertEquals(expected, clazz.dfsRecursiveSolution(input));
    }

  @ParameterizedTest(name = "bfsIterativeSolution {index}")
  @MethodSource("testcases")
  void testbfsIterativeSolution(TreeNode input, int expected) {
    assertEquals(expected, clazz.bfsIterativeSolution(input));
  }

  public static Stream<Arguments> testcases() {
    return Stream.of(
        arguments(lcTestCase1(), 3),
        arguments(singleNode(), 1),
        arguments(outerNodesOnly(), 4),
        arguments(oneSidedTree(), 6),
        arguments(unbalancedBinaryTree(), 5),
        arguments(balancedBinaryTree(), 3)
    );
  }

  private static TreeNode lcTestCase1() {
    var root = new TreeNode(3);

    root.right = new TreeNode(20);
    root.left = new TreeNode(9);

    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(15);
    return root;
  }

  private static TreeNode singleNode() {
    return new TreeNode(1);
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

  private static TreeNode oneSidedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.left.left.left.left = new TreeNode(7);
    root.left.left.left.left.left = new TreeNode(8);
    return root;
  }

  private static TreeNode unbalancedBinaryTree() {
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

  private static TreeNode balancedBinaryTree() {
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
