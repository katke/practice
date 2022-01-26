package educative.codinginterviewpatterns.fastslowpointers;

import leetcode.commontypes.ListNode;
import shared.PracticeStatus;

public class FindLinkedListMiddleNode {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3j5GD3EQMGM";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";

  /*
  * Given the head of a Singly LinkedList, write a method to return the
  *  middle node of the LinkedList. If the total number of nodes in the
  * LinkedList is even, return the second middle node.
  * */

  ListNode findMiddle(ListNode head) {
    if (head == null) throw new IllegalArgumentException("Cannot find middle of null linked list");
    ListNode slowPointer = head, fastPointer = head;
    int linkedListSize = 1;
    while (fastPointer != null && fastPointer.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
      linkedListSize += 2;
    }
      return slowPointer;
  }
}
