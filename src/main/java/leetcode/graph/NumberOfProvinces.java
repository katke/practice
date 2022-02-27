package leetcode.graph;

import java.util.*;

public class NumberOfProvinces {
  String source = "https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/ (union-find) or https://leetcode.com/problems/number-of-provinces/solution/";

  int findNumProvincesBFS(int[][] isConnected) {
    if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
    int count = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < isConnected.length; i++) {
      // Outer loop will not necessarily do anything with each i val, since we may check some of those
      // future i vals in the inner loops and added them to visited
      if (!visited.contains(i)) {
        queue.addLast(i);
        while (!queue.isEmpty()) {
          int currentNode = queue.removeFirst();
          visited.add(currentNode);
          // checks each edge value for all other nodes, including self
          // each 1 reps a connection between currentNode & that index's node, so we add that
          // child node to our queue to look at its connections later
          // 0 means there's no connection so we skip. We'll also skip if we've already looked
          // at this connection (i.e.checking [0][1] is same as checking [1][0], no need to look twice
          for (int j = 0; j < isConnected[i].length; j++) {
            if (!visited.contains(j) && isConnected[currentNode][j] == 1) {
              queue.addLast(j);
            }
          }
        }
        // increment count because at this point we've looked at all the connected nodes associated with whatever node
        // we started with, which is why the queue is now empty, so the next node we look at will be the start of a
        // new subgraph
        count++;
      }
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

