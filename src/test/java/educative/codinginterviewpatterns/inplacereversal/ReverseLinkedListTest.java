package educative.codinginterviewpatterns.inplacereversal;

import leetcode.commontypes.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ReverseLinkedListTest {
  ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

  @ParameterizedTest
  @MethodSource("testCases")
  void testSolution(ListNode head, ListNode expected) {
    var actual = reverseLinkedList.solution(head);
//    System.out.println(head.toStringAllFollowingNodes());
    assertLinkedListMatches(expected, actual);
  }

  private void assertLinkedListMatches(ListNode expected, ListNode actual) {
    ListNode expectedNode = expected, actualNode = actual;
    while (expectedNode != null) {
      System.out.println("expectedNode: " + expectedNode.val + ", actualNode: " + actualNode.val);
      assertEquals(expectedNode.val, actualNode.val);
      expectedNode = expectedNode.next;
      actualNode = actualNode.next;
    }
    assertNull(actualNode);
  }

  static Stream<Arguments> testCases() {
    return Stream.of(
        testCase1(),
        testCase2()
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

    var expNode1 = new ListNode(1);
    var expNode2 = new ListNode(2);
    var expNode3 = new ListNode(3);
    var expNode4 = new ListNode(4);
    var expNode5 = new ListNode(5);

    expNode5.next = expNode4;
    expNode4.next = expNode3;
    expNode3.next = expNode2;
    expNode2.next = expNode1;
    return arguments(node1, expNode5);
  }

  private static Arguments testCase2() {
//    1 -> null
    var node1 = new ListNode(1);
    return arguments(node1, node1);
  }

}
