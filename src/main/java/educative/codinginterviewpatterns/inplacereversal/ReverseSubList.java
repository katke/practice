package educative.codinginterviewpatterns.inplacereversal;

import leetcode.commontypes.ListNode;
import shared.PracticeStatus;

public class ReverseSubList {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";
  /*
  * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
  * */

  ListNode solution(ListNode head, int p, int q) {
    if (head == null) throw new IllegalArgumentException("LinkedList head cannot be null");
    ListNode current = head, previous = null, next = head.next, pNode = null, pointsToQ = null;

    boolean inSublist = false;
    while (current.next != null) {
      if (current.val == p) {
        pNode = current;
        pointsToQ = previous;
        inSublist = true;
      } else if (current.val == q) {
        if (pointsToQ != null) pointsToQ.next = current;
        if (pNode != null) pNode.next = current.next;
        inSublist = false;
      }
      if ((inSublist && p != current.val) || current.val == q) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      } else {
        previous = current;
        current = current.next;
      }
    }
    return head;
  }

  ListNode educativeSolution(ListNode head, int p, int q) {
    if (p == q)
      return head;

    // after skipping 'p-1' nodes, current will point to 'p'th node
    ListNode current = head, previous = null;
    for (int i = 0; current != null && i < p - 1; ++i) {
      previous = current;
      current = current.next;
    }

    // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
    // 'q', and the part after index 'q'
    ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
    // after reversing the LinkedList 'current' will become the last node of the sub-list
    ListNode lastNodeOfSubList = current;
    ListNode next = null; // will be used to temporarily store the next node
    // reverse nodes between 'p' and 'q'
    for (int i = 0; current != null && i < q - p + 1; i++) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    // connect with the first part
    if (lastNodeOfFirstPart != null)
      lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
    else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
      head = previous;

    // connect with the last part
    lastNodeOfSubList.next = current;

    return head;
  }

}
