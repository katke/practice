package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MinDepthBinaryTreeTest {
    MinDepthBinaryTree clazz = new MinDepthBinaryTree();

    @ParameterizedTest
    @MethodSource("testcases")
    void testBFSSolution(TreeNode input, int expected) {
      assertEquals(expected, clazz.bfsIterativeSolution(input));
    }

  @ParameterizedTest
  @MethodSource("testcases")
  void testDFSSolution(TreeNode input, int expected) {
    assertEquals(expected, clazz.dfsRecursiveSolution(input));
  }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(testCase1Tree(), 2),
          arguments(testCase2Tree(), 2),
          arguments(testCase3Tree(), 5)
      );
    }

  static TreeNode testCase1Tree() {
    var root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    return root;
  }

  static TreeNode testCase2Tree() {
    var root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    return root;
  }

  static TreeNode testCase3Tree() {
    var root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);
    root.right.right.right.right = new TreeNode(5);
    return root;
  }

  }
