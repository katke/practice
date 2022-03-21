package leetcode.practice;

import shared.PracticeStatus;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithNoRepeatingChars {
  String source = "https://leetcode.com/problems/longest-substring-without-repeating-characters/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(N)";
  /*
Given a string s, find the length of the longest substring without repeating characters.
*/

  int solution(String s) {
    if (s == null) return 0;
    else if (s.length() < 2) return s.length();
    Set<Character> uniqueLetters = new HashSet<>();
    int right = 0, maxLength = Integer.MIN_VALUE;
    char incomingChar = s.charAt(0);
    for (int left = 0; left < s.length() - 1; left++) {
      while (!uniqueLetters.contains(incomingChar)) {
        uniqueLetters.add(incomingChar);
        maxLength = Math.max(maxLength, uniqueLetters.size());
        if (right < s.length() - 1) {
          right++;
        } else {
          break;
        }
        incomingChar = s.charAt(right);
      }
      uniqueLetters.remove(s.charAt(left));
      incomingChar = s.charAt(right);
    }
    return maxLength;
  }
}
