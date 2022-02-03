package educative.codinginterviewpatterns.inplacereversal;

import shared.commontypes.ListNode;
import shared.PracticeStatus;

public class ReverseLinkedList {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/3wENz1N4WW9";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";
  /*
  * Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return
  * the new head of the reversed LinkedList.
  * */
  ListNode solution(ListNode head) {
    if (head == null) throw new IllegalArgumentException("LinkedList head cannot be null");
    var currentNode = head;
    ListNode prevNode = null;
    var tempNextNode = currentNode.next;
    while (currentNode != null) {
      tempNextNode = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = tempNextNode;
    }
    return prevNode;
  }
}
