package leetcode.practice;

import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoChars implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/";

  public int solution(String t) {
    if (t == null) {
      return 0;
    } else if (t.length() < 2) {
      return t.length();
    }
    Map<Character, Integer> tMap = new HashMap<>();
    var l = 0;
    var r = 1;
    updateCountMap(t.charAt(l), tMap, true);
    var max = 2;
    while (r <= t.length()) {
      if (tMap.keySet().size() > 2) {
        // condition is now broken
        // increment left
        updateCountMap(t.charAt(l), tMap, false);
        l++;
      } else {
        // keep incrementing right
        var possibleNewMax = tMap.values().stream().reduce(0, (subtotal, next) -> subtotal + next);
        max = Math.max(max, possibleNewMax);
        if (r == t.length()) break;
        updateCountMap(t.charAt(r), tMap, true);
        r++;
      }
    }
    return max;
  }

  private void updateCountMap(Character c, Map<Character, Integer> tMap, boolean add) {
    if (add) {
      tMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
    } else {
      var currentVal = tMap.getOrDefault(c, -1);
      if (currentVal > 1) {
        tMap.put(c, currentVal - 1);
      } else {
        tMap.remove(c);
      }
    }
  }

}
