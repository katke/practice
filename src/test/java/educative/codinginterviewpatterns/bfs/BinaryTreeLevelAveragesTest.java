package educative.codinginterviewpatterns.bfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BinaryTreeLevelAveragesTest {
  BinaryTreeLevelAverages binaryTreeLevelAverages = new BinaryTreeLevelAverages();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(TreeNode root, List<Double> expected) {
    var actual = binaryTreeLevelAverages.solution(root);
    assertArrayEquals(expected.toArray(), actual.toArray());
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        arguments(testCase1Tree(), List.of(12.0, 4.0, 6.5)),
        arguments(testCase2Tree(), List.of(1.0, 2.5, 4.5, 6.5)),
        arguments(testCase3Tree(), List.of(1.0, 2.5, 5.5))
    );
  }

  private static TreeNode testCase1Tree() {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    return root;
  }

  private static TreeNode testCase2Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return root;
  }

  private static TreeNode testCase3Tree() {
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
