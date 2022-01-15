package educative.codinginterviewpatterns.slidingwindow;

import shared.PracticeStatus;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueCharSubstring {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://www.educative.io/courses/grokking-the-coding-interview/YMzBx1gE5EO";
  String timeComplexity = "O(n)";
  String spaceComplexity = "O(n) [or O(1) since possible number of characters as key is finite]";
  /*
  * Given a string, find the length of the longest substring, which has all distinct characters.
  * Ex aabccbb => 3, "abc"
  * */
  // Create hashmap to track char frequency, which should be 1 for all chars to meet req
  // left/right pointers: if the condition is met, expand right pointer, adding new
  // chars to map. Update max length found throughout
  // while condition is not met, contract left pointer and remove those chars from map
  // until condition is true again
  int findLength(String str) {
    if (str == null || str.length() == 0) return 0;
    var charCount = new HashMap<Character, Integer>();
    int left = 0, right = 0, uniqueCharLen = 0;
    var leftChar = str.charAt(left);
    var rightChar = str.charAt(right);
    for (right = 0; right < str.length(); right++) {
      rightChar = str.charAt(right);
      updateMap(true, rightChar, charCount);
      while (charCount.keySet().size() != right - left + 1) { // at least one char has higher frequency than 1
        updateMap(false, leftChar, charCount);
        left++;
        leftChar = str.charAt(left);
      }
      uniqueCharLen = Math.max(uniqueCharLen, right - left + 1);
    }
    return uniqueCharLen;
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
