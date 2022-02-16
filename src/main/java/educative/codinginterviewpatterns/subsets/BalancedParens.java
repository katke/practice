package educative.codinginterviewpatterns.subsets;

import shared.PracticeStatus;

import java.util.*;

public class BalancedParens {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/NEXBg8YA5A2";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n * 2^n), 2^n number of possible combinations, n for each time copying and regenerating string with new ) or (";
  String spaceComplexity = "O(n * 2^n)";
  /*
  * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
  * Input: N=2
  * Output: (()), ()()
  * */

  List<String> solution(int num) {
    List<String> result = new ArrayList<>();
    Deque<ParenthesesString> queue = new ArrayDeque<>();
    queue.addLast(new ParenthesesString("", 0, 0));
    while (!queue.isEmpty()) {
      var currentPermutation = queue.removeFirst();
      if (currentPermutation.openCount == num && currentPermutation.closeCount == num) {
        result.add(currentPermutation.str);
        continue;
      }
      if (currentPermutation.openCount < num) {
        var newPermutation = new ParenthesesString(
            currentPermutation.str + "(",
            currentPermutation.openCount + 1,
            currentPermutation.closeCount);
        queue.addLast(newPermutation);
      }

      if (currentPermutation.openCount > currentPermutation.closeCount && currentPermutation.closeCount < num) {
        var newPermutation = new ParenthesesString(
            currentPermutation.str + ")",
            currentPermutation.openCount,
            currentPermutation.closeCount + 1);
        queue.addLast(newPermutation);
      }
    }
    return result;
  }

  List<String> recursiveSolution(int num) {
    List<String> result = new ArrayList<>();
    addParens(result, new ParenthesesString("", 0, 0), num);
    return result;
  }

  void addParens(List<String> result, ParenthesesString permutation, int num) {
    if (permutation.openCount == num && permutation.closeCount == num) {
      result.add(permutation.str);
      return;
    }
    if (permutation.openCount < num) {
      addParens(result, new ParenthesesString(permutation.str + "(", permutation.openCount + 1, permutation.closeCount), num);
    }
    if (permutation.openCount > permutation.closeCount && permutation.closeCount < num) {
      addParens(result, new ParenthesesString(permutation.str + ")", permutation.openCount, permutation.closeCount + 1), num);
    }
  }

  class ParenthesesString {
    String str;
    int openCount; // open parentheses count
    int closeCount; // close parentheses count

    public ParenthesesString(String s, int openCount, int closeCount) {
      str = s;
      this.openCount = openCount;
      this.closeCount = closeCount;
    }

    public String toString() {
      return String.format("String: %s, openCount: %s, closeCount: %s",
          this.str,
          this.openCount,
          this.closeCount);
    }
  }
}
