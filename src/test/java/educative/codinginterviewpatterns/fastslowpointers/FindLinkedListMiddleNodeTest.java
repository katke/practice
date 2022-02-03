package educative.codinginterviewpatterns.fastslowpointers;

import shared.commontypes.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindLinkedListMiddleNodeTest {
  FindLinkedListMiddleNode findLinkedListMiddleNode = new FindLinkedListMiddleNode();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(ListNode head, ListNode expected) {
    var actual = findLinkedListMiddleNode.findMiddle(head);
    System.out.println(head.toStringAllFollowingNodes());
    System.out.println("Expected: " + expected.val + ", actual: " + actual.val);
    assertEquals(expected, actual);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1(),
        testCase2(),
        testCase3(),
        testCase4(),
        testCase5()
    );
  }

  private static Arguments testCase1() {
//    1 -> 2 -> 3 -> 4 -> 5 -> null
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(3);
    var node4 = new ListNode(4);
    var node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    return arguments(node1, node3);
  }

  private static Arguments testCase2() {
//    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(3);
    var node4 = new ListNode(4);
    var node5 = new ListNode(5);
    var node6 = new ListNode(6);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    return arguments(node1, node4);
  }

  private static Arguments testCase3() {
//    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(3);
    var node4 = new ListNode(4);
    var node5 = new ListNode(5);
    var node6 = new ListNode(6);
    var node7 = new ListNode(7);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    return arguments(node1, node4);
  }

  private static Arguments testCase4() {
//    1 -> null
    var node1 = new ListNode(1);

    return arguments(node1, node1);
  }

  private static Arguments testCase5() {
//    1 -> 2 -> null
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);

    node1.next = node2;
    return arguments(node1, node2);
  }

}
