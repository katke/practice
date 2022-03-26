package leetcode.practice;

import shared.PracticeStatus;

import java.util.*;

public class WordSearch {
  String source = "https://leetcode.com/problems/word-search/";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
horizontally or vertically neighboring. The same letter cell may not be used more than once.

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/

  boolean solution(char[][] board, String word) {
    System.out.println("looking for word: " + word);
    if (board == null || board.length == 0 || board[0].length == 0) return false;
    if (word.length() == 0) return true;
    var adj = buildAdjList(board.length, board[0].length);
    var result = false;
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        result = checkNextLetter(board, word, 0, List.of(r,c), adj, new HashSet<>());
        if (result) return true;
      }
    }
    return false;
  }

  boolean checkNextLetter(char[][] board, String word, int wordIdx, List<Integer> charPos, Map<List<Integer>, List<List<Integer>>> adj, Set<List<Integer>> visited) {
    System.out.println("-".repeat(10));
    System.out.println("remainingWord: " + word.substring(wordIdx));
    System.out.println("coordinates: " + charPos);
    if (word.length() == wordIdx) return true;
    var letter = board[charPos.get(0)][charPos.get(1)];
    if (letter != word.charAt(wordIdx)) return false;
    var foundIt = false;
    System.out.println("current letter: " + letter);
    System.out.println("current word index: " + wordIdx);
    var neighbors = adj.getOrDefault(charPos, new ArrayList<>());
    for (var neighbor : neighbors) {
      foundIt = checkNextLetter(board, word, wordIdx + 1, neighbor, adj, visited);
      if (foundIt) {
        return true;
      }
    }

    return false;
  }

  Map<List<Integer>, List<List<Integer>>> buildAdjList(int m, int n) {
    var adj = new HashMap<List<Integer>, List<List<Integer>>>();
    for (int mi = 0; mi < m; mi++) {
      for (int ni = 0; ni < n; ni++) {
        var node = List.of(mi,ni);
        var neighbors = new ArrayList<List<Integer>>();
        if (ni < n - 1) {
          var moveRight = List.of(mi,ni + 1);
          neighbors.add(moveRight);
        }
        if (mi < m - 1) {
          var moveDown = List.of(mi + 1, ni);
          neighbors.add(moveDown);
        }
        if (ni > 0) {
          var moveLeft = List.of(mi,ni - 1);
          neighbors.add(moveLeft);
        }
        if (mi > 0) {
          var moveUp = List.of(mi - 1, ni);
          neighbors.add(moveUp);
        }
        adj.put(node, neighbors);
      }
    }
    return adj;
  }

    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
      this.board = board;
      this.ROWS = board.length;
      this.COLS = board[0].length;

      for (int row = 0; row < this.ROWS; ++row)
        for (int col = 0; col < this.COLS; ++col)
          if (this.backtrack(row, col, word, 0))
            return true;
      return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
      /* Step 1). check the bottom case. */
      if (index >= word.length()) {
        System.out.println("found the last letter, we're done");
        return true;
      }

      /* Step 2). Check the boundaries. */
      System.out.println("coordinates " + row+ "," + col);
      if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
          || this.board[row][col] != word.charAt(index))
        return false;
      var letter = this.board[row][col];
      System.out.println(letter + " coordinates " + row+ "," + col);
      /* Step 3). explore the neighbors in DFS */
      boolean ret = false;
      // mark the path before the next exploration
      this.board[row][col] = '#';
      System.out.println(Arrays.toString(this.board[row]));

      int[] rowOffsets = {0, 1, 0, -1};
      int[] colOffsets = {1, 0, -1, 0};
      for (int d = 0; d < 4; ++d) {
        ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
        if (ret)
          break;
      }

      /* Step 4). clean up and return the result. */
      this.board[row][col] = word.charAt(index);
      System.out.println("post clean up " + Arrays.toString(this.board[row]));
      return ret;
    }

}
