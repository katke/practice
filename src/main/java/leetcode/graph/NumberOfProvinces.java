package leetcode.graph;

import javax.sound.midi.SysexMessage;
import java.util.*;

public class NumberOfProvinces {
  String source = "https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/ (union-find) or https://leetcode.com/problems/number-of-provinces/solution/";

  public int findCircleNumBFS(int[][] isConnected) {
    if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
    Set<Integer> visited = new HashSet<>();
    int count = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < isConnected.length; i++) { // i = one node's adj matrix
      System.out.println("Visited: " + visited);
      System.out.println("i: " + i);
      if (!visited.contains(i)) {
        queue.addLast(i);
        while (!queue.isEmpty()) {
          System.out.println("  Queue: " + queue);
          int node = queue.removeFirst();
          visited.add(node);
          for (int j = 0; j < isConnected[i].length; j++) { // j = other nodes in relation to i, [i][j] 0/1 depending on if there's an edge present
            System.out.println("    node: " + node + ", j: " + j);
            System.out.println("    isConnected[node][j] " + isConnected[node][j]);
            System.out.println("    visited: " + visited);
            if (isConnected[node][j] == 1 && !visited.contains(j)) {
              System.out.println("    adding j (" + j + ") to queue ");
              queue.add(j);
            } else {
              System.out.println("    did not add j (" + j + ") to queue ");
            }
            System.out.println("    Updated queue: " + queue);
          }
          System.out.println("  End queue iteration---------");
        }
        count++;
        System.out.println("count: " + count);
      }
      System.out.println("---------End outer loop iteration---------");
    }
    return count;
  }


  public int findCircleNumUnionFind(int[][] isConnected) {
    if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
    // build union-find set up
    // initialize arr[i] = i
    int[] rootArray = new int[isConnected[0].length - 1];
    int[] rank = new int[isConnected[0].length - 1];
    for (int i : rootArray) {
      rootArray[i] = i;
      rank[i] = 1;
    }
    // traverse isConnected to generate union() calls
    // run union(x,y) to get arr[index = node id] = val = root node
    union(0, 1, rootArray, rank);
    System.out.println(Arrays.toString(rootArray));
    System.out.println(Arrays.toString(rank));
    // get count of unique root nodes to determine how many provinces
    return 0;

  }

  int find(int inputNode, int[] arr) {
    int parent = arr[inputNode];
    if (parent == inputNode) {
      return inputNode;
    } else {
      arr[inputNode] = find(inputNode, arr);
      ;
      return arr[inputNode];
    }
  }

  void union(int xNode, int yNode, int[] arr, int[] rank) {
    int xRoot = find(xNode, arr);
    int yRoot = find(yNode, arr);
    if (rank[xRoot] > rank[yRoot]) {
      arr[yRoot] = xRoot;
    } else if (rank[yRoot] > rank[xRoot]) {
      arr[xRoot] = yRoot;
    } else {
      rank[xNode] += 1;
      arr[yNode] = xNode;
    }
  }
}

