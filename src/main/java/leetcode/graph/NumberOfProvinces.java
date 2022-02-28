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


  public int findProvincesUnionFind(int[][] isConnected) {
    if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
    UnionFind unionFind = new UnionFind(isConnected.length);
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected.length; j++) {
        if (isConnected[i][j] == 1) {
          if (i != j) {
            unionFind.union(i, j);
          }
        }
      }
    }
    return unionFind.size;

  }

  static class UnionFind {
    int[] rootNodeArr;
    int[] rank;
    int size;

    UnionFind(int size) {
      this.rootNodeArr = new int[size];
      this.rank = new int[size];
      this.size = size;
      for (int i = 0; i < size; i++) {
        this.rootNodeArr[i] = i;
        this.rank[i] = 1;
      }
    }

    int find(int inputNode) {
      int parent = rootNodeArr[inputNode];
      if (parent == inputNode) {
        return inputNode;
      } else {
        this.rootNodeArr[inputNode] = find(parent);
        return this.rootNodeArr[inputNode];
      }
    }

    void union(int xNode, int yNode) {
      int xRoot = find(xNode);
      int yRoot = find(yNode);
      if (xRoot != yRoot) {
        if (rank[xRoot] > rank[yRoot]) {
          this.rootNodeArr[yRoot] = xRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
          this.rootNodeArr[xRoot] = yRoot;
        } else {
          this.rootNodeArr[yNode] = xRoot;
          this.rank[xRoot]++;
        }
        this.size--;
      }
    }

  }


}

