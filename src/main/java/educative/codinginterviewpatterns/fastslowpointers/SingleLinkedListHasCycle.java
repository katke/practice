package educative.codinginterviewpatterns.fastslowpointers;

import leetcode.commontypes.ListNode;
import shared.PracticeStatus;

public class SingleLinkedListHasCycle {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n) where n = total number of nodes in linked list";
  String spaceComplexity = "O(1)";
  /*
  * Given the head of a Singly LinkedList, write a function to
  * determine if the LinkedList has a cycle in it or not.
  * */
  boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slowNode = head;
    ListNode fastNode = head.next;
    while (fastNode != null && fastNode.next != null) {
//      System.out.println("slowNode: " + slowNode.toStringRepresentation());
//      System.out.println("fastNode: " + fastNode.toStringRepresentation());
      if (slowNode == fastNode) return true;
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }
    return false;
  }

}
