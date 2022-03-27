package leetcode.practice;

import common.CustomAsserts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class InvertBinaryTreeTest {
    InvertBinaryTree clazz = new InvertBinaryTree();
    CustomAsserts customAsserts = new CustomAsserts();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(TreeNode input, TreeNode expected) {
      customAsserts.assertBinaryTreeEquals(expected, clazz.solution(input));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          testCase1(),
          testCase2()
      );
    }

    static Arguments testCase1() {
      var root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(9);

      var expected = new TreeNode(4);
      expected.right = new TreeNode(2);
      expected.left = new TreeNode(7);
      expected.left.left = new TreeNode(9);
      expected.left.right = new TreeNode(6);
      expected.right.left = new TreeNode(3);
      expected.right.right = new TreeNode(1);

      return arguments(root, expected);
    }

  static Arguments testCase2() {
    var root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

    var expected = new TreeNode(1);
    expected.right = new TreeNode(2);
    expected.right.right = new TreeNode(3);
    expected.right.left = new TreeNode(4);

    return arguments(root, expected);
  }

  }
