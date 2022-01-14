package educative.codinginterviewpatterns.slidingwindow;

import shared.PracticeStatus;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinctChar {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/YQQwQMWLx80";
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(k)";

  /*
  * Given a string, find the length of the longest substring in it with no more than K distinct characters
  */
  // iterate through the string, adding/incrementing each char count to the map
  // while map keyset size <= k, keep updating substr length and incrementing
  // right pointer
  // once map keyset size > k, increment left pointer and remove that char count
  // from the map until the map keyset size is <= k again
  // then start process over with incrementing right pointer
  int solution(String str, int k) {
    if (str == null || str.length() == 0 || k == 0) return 0;
    Map<Character, Integer> charCount = new HashMap<>();
    var substrLen = -1;
    var right = 0;
    var left = 0;
    var leftChar = str.charAt(0);
    var rightChar = str.charAt(right);
    charCount.put(leftChar, 1);
    while (left < str.length()) {
      while (charCount.keySet().size() <= k) {
        substrLen = Math.max(substrLen, right - left + 1);
        if (right < str.length() - 1) {
          right++;
          rightChar = str.charAt(right);
          updateMap(true, rightChar, charCount);
        } else {
          break;
        }
      }
      leftChar = str.charAt(left);
      updateMap(false, leftChar, charCount);
      left++;
      }
    return substrLen;
    }


  void updateMap(boolean shouldAdd, Character key, Map<Character, Integer> map) {
    if (shouldAdd) {
      map.compute(key, (existingKey, existingVal) -> existingVal == null ? 1 : existingVal + 1);
    } else {
      var currentVal = map.getOrDefault(key, 1);
      if (currentVal == 1) {
        map.remove(key);
      } else {
        map.put(key, currentVal - 1);
      }
    }
  }
}
