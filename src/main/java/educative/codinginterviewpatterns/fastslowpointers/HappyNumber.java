package educative.codinginterviewpatterns.fastslowpointers;

import shared.PracticeStatus;

import java.util.*;

public class HappyNumber {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/39q3ZWq27jM";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  Map<Integer, Integer> squaresSumMemo = new HashMap<>();
  /*
  * Any number will be called a happy number if, after repeatedly replacing
  *  it with a number equal to the sum of the square of all of its digits,
  * leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
  * Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
  * For ex: 23 => true
  * 2^2 + 3^2 = 13
  * 1^2 + 3^2 = 10
  * 1^2 + 0^1 = 1
  * */
  boolean find(int num) {
    if (num < 2 && num > -2) return true;
    int slowPointer = num, fastPointer = num;
    do {
      System.out.println("Slow pointer: " + slowPointer);
      System.out.println("fast pointer: " + fastPointer);
      slowPointer = findSum(slowPointer);
      fastPointer = findSum(findSum(fastPointer));
    } while (slowPointer != fastPointer);
    return slowPointer == 1;
  }

  boolean alternativeSolution(int num) {
    if (num < 2 && num > -2) return true;
    int sum = num;
    while (sum != 1) {
      if (squaresSumMemo.containsKey(sum)) {
        return false;
      } else {
        int initialSum = sum;
        sum = findSum(sum);
        squaresSumMemo.put(initialSum, sum);
      }
    }
    return true;
  }

  int findSum(int digits) {
    if (digits < 10 && digits > -1) {
      return digits * digits;
    } else {
      return ((digits % 10) * (digits % 10)) + findSum(digits / 10);
    }
  }

}
