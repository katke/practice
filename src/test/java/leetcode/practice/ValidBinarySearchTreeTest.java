package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ValidBinarySearchTreeTest {
    ValidBinarySearchTree clazz = new ValidBinarySearchTree();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(TreeNode input, boolean expected) {
      assertEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          testCase1(),
          testCase2(),
          testCase3(),
          testCase4(),
          testCase5()
      );
    }

    static Arguments testCase1() {
      // root = [2,1,3]
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(3);
      return arguments(root, true);
    }

  static Arguments testCase2() {
    // root = [5,1,4,null,null,3,6]
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);
    return arguments(root, false);
  }

  static Arguments testCase3() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(7);
    root.right.right.left = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    return arguments(root, false);
  }

  static Arguments testCase4() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(7);
    root.right.right.left = new TreeNode(7);
    root.right.right.left = new TreeNode(3);
    return arguments(root, false);
  }

  static Arguments testCase5() {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    return arguments(root, false);
  }

  }
