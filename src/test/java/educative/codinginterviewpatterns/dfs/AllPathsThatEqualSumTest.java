package educative.codinginterviewpatterns.dfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shared.commontypes.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AllPathsThatEqualSumTest {
  AllPathsThatEqualSum allPathsThatEqualSum = new AllPathsThatEqualSum();

  @ParameterizedTest(name = "Recursive solution {index}")
  @MethodSource("testCases")
  void testRecursiveSolution(TreeNode root, int targetSum, List<List<Integer>> expected) {
    var actual = allPathsThatEqualSum.solution(root, targetSum);
    System.out.println("targetSum: " + targetSum);
    System.out.println("EXPECTED: " + Arrays.toString(expected.toArray()));
    System.out.println("ACTUAL: " + Arrays.toString(actual.toArray()));
    System.out.println("-----------------------");
    assertListEquals(expected, actual);
  }

  @ParameterizedTest(name = "Iterative solution {index}")
  @MethodSource("testCases")
  void testIterativeSolution(TreeNode root, int targetSum, List<List<Integer>> expected) {
    var actual = allPathsThatEqualSum.iterativeSolution(root, targetSum);
    System.out.println("targetSum: " + targetSum);
    System.out.println("EXPECTED: " + Arrays.toString(expected.toArray()));
    System.out.println("ACTUAL: " + Arrays.toString(actual.toArray()));
    System.out.println("-----------------------");
    assertListEquals(expected, actual);
  }

  void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
    assertEquals(expected.size(), actual.size());
    for (List<Integer> expectedPath : expected) {
      assertTrue(actual.contains(expectedPath));
    }
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1Tree(),
        testCase2Tree(),
        testCase3Tree(),
        testCase4Tree()
    );
  }

  private static Arguments testCase1Tree() {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    return arguments(root, 21, List.of(
        List.of(12, 7, 2))
    );
  }

  private static Arguments testCase2Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    root.left.left.right = new TreeNode(9);
    root.left.left.left = new TreeNode(6);
    root.right.right.right = new TreeNode(7);
    return arguments(root, 16, List.of(
        List.of(1,3,5,7),
        List.of(1,2,4,9)
    ));
  }

  private static Arguments testCase3Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(5);
    root.left.left.right = new TreeNode(6);
    root.right.right = new TreeNode(7);
    return arguments(root, 20, List.of());
  }

  private static Arguments testCase4Tree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(7);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    root.right = new TreeNode(9);
    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(2);
    return arguments(root, 12, List.of(
        List.of(1,7,4),
        List.of(1,9,2)
    ));
  }
}
