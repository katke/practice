package leetcode.practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BinaryTreeLevelOrderTraversalTest {
    BinaryTreeLevelOrderTraversal clazz = new BinaryTreeLevelOrderTraversal();

    @ParameterizedTest
    @MethodSource("testcases")
    void testSolution(TreeNode root, List<List<Integer>> expected) {
      assertEquals(expected, clazz.solution(root));
    }

    static Stream<Arguments> testcases() {
      return Stream.of(
          arguments(testCase1Tree(), List.of(List.of(3),List.of(9,20),List.of(15,7))),
          arguments(new TreeNode(1), List.of(List.of(1)))
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

  }
