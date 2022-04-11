package educative.codinginterviewpatterns.kwaymerge;

import shared.PracticeStatus;

import java.util.List;

public class FindKthSmallestElement {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/myAqDMyRXn3";
  PracticeStatus practiceStatus = PracticeStatus.IN_PROGRESS;
  String timeComplexity = "";
  String spaceComplexity = "";
  /*
Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
*/

  int solution(List<Integer[]> lists, int k) {
    if (lists == null || lists.isEmpty() || k < 1) throw new RuntimeException();

    return 0;
  }
}
