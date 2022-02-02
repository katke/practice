package educative.codinginterviewpatterns.cyclicsort;

import shared.PracticeStatus;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNums {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(1)";
  /*
  * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
  * The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
  * */
  static final Integer DUP_PLACEHOLDER = -1;
  List<Integer> solution(int[] nums) {
    var missingNumbers = new ArrayList<Integer>();
    var i = 0;
    while (i < nums.length) {
      var currentVal = nums[i];
      var expectedVal = i + 1;
      if (currentVal == expectedVal || currentVal == DUP_PLACEHOLDER) {
        i++;
        continue;
      }
      var swapValue = nums[currentVal - 1];
      if (swapValue == currentVal) { // found a duplicate
        nums[currentVal - 1] = currentVal;
        nums[i] = DUP_PLACEHOLDER;
      } else {
        nums[currentVal - 1] = currentVal;
        nums[i] = swapValue;
      }
    }
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] == DUP_PLACEHOLDER) {
        missingNumbers.add(j + 1);
      }
    }
    return missingNumbers;
  }

}
