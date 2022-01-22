package educative.codinginterviewpatterns.twopointers;

import shared.PracticeStatus;

import java.util.*;

public class UniqueTriplets {
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r";
  PracticeStatus practiceStatus = PracticeStatus.FAIL_IMPLEMENTATION;

  /*
   * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
   * Input: [-3, 0, 1, 2, -1, 1, -2]
   * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
   * Explanation: There are four unique triplets whose sum is equal to zero.
   * */

  List<List<Integer>> searchTriplets(int[] arr) {
    if (arr == null || arr.length < 3) return List.of(List.of());
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();
    int left = 0, right = 1;
    int sum = arr[left] + arr[right];
    var freqMap = buildFrequencyMap(arr);
    Map<Integer, Integer> alreadyRecorded = new HashMap<>();
    while (left < arr.length - 2) {
      int neededInt = 0 - sum;

      if (freqMap.containsKey(neededInt)) {
        var alreadyCaptured = (alreadyRecorded.containsKey(arr[left])
            && alreadyRecorded.containsKey(arr[right])
            && alreadyRecorded.containsKey(neededInt));
        System.out.println(alreadyRecorded);
        if (!alreadyCaptured) {
          var newTriplet = List.of(arr[left], arr[right], neededInt);
          result.add(newTriplet);
          alreadyRecorded.put(arr[left], 1);
          alreadyRecorded.put(arr[right], 1);
          alreadyRecorded.put(neededInt, 1);
        }
      }
      if (right < arr.length - 1) {
        right++;
      } else {
        left++;
        right = left + 1;
      }
      sum = arr[right] + arr[left];
    }
    return result;
  }

  Map<Integer, Integer> buildFrequencyMap(int[] arr) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int i : arr) {
      freqMap.compute(i, (currKey, currVal) -> currVal == null ? 1 : currVal + 1);
    }
    return freqMap;
  }
}
