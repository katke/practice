package educative.codinginterviewpatterns.fastslowpointers;

import leetcode.commontypes.ListNode;
import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.List;

public class FindStartOfCycle {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/N7pvEn86YrN";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n) (O(1) if I don't use recursion to find my cycle length)";
  /*
  * Given the head of a Singly LinkedList that contains a cycle,
  * write a function to find the starting node of the cycle.
  * */
  ListNode findCycleStart(ListNode head) {
    if (head == null) throw new IllegalArgumentException("List head can't be null");
    int cycleLength = findCycleLength(head);
    ListNode slowPointer = head, fastPointer = advanceFastPointerKNodes(head, cycleLength);
    while (fastPointer != null && fastPointer.next != null) {
      if (slowPointer.equals(fastPointer)) {
        break;
      }
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next;
    }
    return slowPointer;
  }

  ListNode advanceFastPointerKNodes(ListNode fastPointer, int cycleLength) {
    for (int i = 0; i < cycleLength; i++) {
      fastPointer = fastPointer.next;
    }
    return fastPointer;
  }

  int findCycleLength(ListNode head) {
    ListNode pointer1 = head, pointer2 = head;
    int cycleLength = 0;
    while (pointer1 != null && pointer1.next != null) {
      pointer2 = pointer2.next;
      pointer1 = pointer1.next.next;
      if (pointer2.equals(pointer1)) {
        // starting point for finding length of cycle
        cycleLength = countNode(pointer2, pointer2.next, 1);
        break;
      }
    }
    return cycleLength;
  }

  int countNode(ListNode startNode, ListNode currentNode, int currentCount) {
    if (currentNode.next.equals(startNode)) {
      return currentCount + 1;
    } else {
      return countNode(startNode, currentNode.next, currentCount + 1);
    }
  }

  ListNode alternateSolution(ListNode head) {
    if (head == null) throw new IllegalArgumentException("List head can't be null");
    ListNode currentPointer = head;
    List<ListNode> visitedNodes = new ArrayList<>();
    while (currentPointer != null) {
      if (visitedNodes.contains(currentPointer)) {
        break;
      } else {
        visitedNodes.add(currentPointer);
      }
      currentPointer = currentPointer.next;
    }
    return currentPointer;
  }
}
