package leetcode.commontypes;

import java.util.ArrayList;

// LeetCode given type definition for singly-linked list
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public String toStringRepresentation() {
          String template = "Node with value %d --> %s";
          return String.format(template,
              this.val,
              this.next == null ? "null" : this.next.val);
     }

     public String toStringAllFollowingNodes() {
          var strBuilder = new StringBuilder();
          var currentNode = this;
          while (currentNode != null) {
               strBuilder.append("Node: ")
                   .append(currentNode.val);
               if (currentNode.next == null) {
                    strBuilder.append("--> null");
               } else {
                    strBuilder.append("--> ");
               }
               currentNode = currentNode.next;
          }
          return strBuilder.toString();
     }

     public String toStringAllFollowingNodes(boolean hasCycle) {
          var strBuilder = new StringBuilder();
          var currentNode = this;
          var visitedNodes = new ArrayList<ListNode>();
          while (currentNode != null) {
               if (visitedNodes.contains(currentNode)) {
                    strBuilder.append("Node: ")
                        .append(currentNode.val)
                        .append(", cycle starts over");
                    break;
               }
               visitedNodes.add(currentNode);
               strBuilder.append("Node: ")
                   .append(currentNode.val)
                   .append("--> ");
               currentNode = currentNode.next;
          }
          return strBuilder.toString();
     }
}
