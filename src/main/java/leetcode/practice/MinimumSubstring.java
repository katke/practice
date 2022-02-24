package leetcode.practice;

import shared.PracticeProblem;
import shared.PracticeStatus;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubstring implements PracticeProblem {
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String source = "https://leetcode.com/problems/minimum-window-substring/";
  String timeComplexity = "O(t + (s * t))";
  String spaceComplexity = "O(t)";

  /*
  * Given two strings s and t of lengths m and n respectively, return the minimum window substring
  * of s such that every character in t (including duplicates) is included in the window. If there is
  * no such substring, return the empty string "".
  *
  * The testcases will be generated such that the answer is unique.
  *
  * A substring is a contiguous sequence of characters within the string.
  * Example:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
  * */

  public String solution(String s, String t) {
    if ((s == null || s.length() == 0) || (t == null || t.length() == 0)) return "";
    else if (t.length() > s.length()) return "";
    Map<Character, Integer> currentCharFreq = new HashMap<>();
    final Map<Character, Integer> tCharLimits = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      tCharLimits.compute(t.charAt(i), (key, val) -> val == null ? 1 : val + 1);
    }
    int left = 0, right = -1, minWindowLength = Integer.MAX_VALUE;
    String minWindow = "";
    while (left < s.length() - t.length() + 1) {
      if (right < s.length() - 1) {
        right++;
        updateMap(false, s.charAt(right), currentCharFreq, tCharLimits);
      } else {
        updateMap(true, s.charAt(left), currentCharFreq, tCharLimits);
        left++;
      }
      while (allCharsAccountedFor(currentCharFreq, tCharLimits)) {
        if (right - left + 1 < minWindowLength) {
          minWindow = s.substring(left, right + 1);
          minWindowLength = minWindow.length();
        }
        updateMap(true, s.charAt(left), currentCharFreq, tCharLimits);
        left++;
      }
    }
    return minWindow;
  }

  void updateMap(boolean remove, char key, Map<Character, Integer> charFreq, final Map<Character, Integer> tLimits) {
    var currFrequency = charFreq.getOrDefault(key, 0);
    if (remove) {
      if (currFrequency == 1) {
        charFreq.remove(key);
      } else if (currFrequency > 1) {
        charFreq.put(key, currFrequency - 1);
      }
    } else {
      if (tLimits.containsKey(key)) {
        charFreq.put(key, currFrequency + 1);
      }
    }
  }

  boolean allCharsAccountedFor(Map<Character, Integer> charFreq, final Map<Character, Integer> tLimits) {
    for (Character c : tLimits.keySet()) {
      if (charFreq.getOrDefault(c, 0) < tLimits.get(c)) {
        return false;
      }
    }
    return true;
  }

}