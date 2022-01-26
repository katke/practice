package educative.codinginterviewpatterns.fastslowpointers;

import leetcode.commontypes.ListNode;
import shared.PracticeStatus;

public class FindLinkedListMiddleNode {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3j5GD3EQMGM";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";

  /*
  * Given the head of a Singly LinkedList, write a method to return the
  *  middle node of the LinkedList. If the total number of nodes in the
  * LinkedList is even, return the second middle node.
  * */

  ListNode findMiddle(ListNode head) {
    if (head == null) throw new IllegalArgumentException("Cannot find middle of null linked list");
    ListNode slowPointer = head, fastPointer = head;
    while (fastPointer != null && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
    }
      return slowPointer;
  }
}
