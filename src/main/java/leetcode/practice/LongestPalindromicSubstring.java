package leetcode.practice;

import shared.PracticeStatus;

public class LongestPalindromicSubstring {
  String source = "https://leetcode.com/problems/longest-palindromic-substring/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED; // but was a struggle
  String timeComplexity = "O(n^2)";
  String spaceComplexity = "O(n^2)";
  /*
Given a string s, return the longest palindromic substring in s.
*/

  String solution(String s) {
    if (s == null) return "";
    else if (s.length() < 2) return s;
    int longestPalindromeLen = 0, palindromeStart = 0, palindromeEnd = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      int[] newPalindrome1 = checkPalindromeFromStartIndex(s, i, i + 1);
      int[] newPalindrome2 = checkPalindromeFromStartIndex(s, i, i);
      if (newPalindrome1[1] - newPalindrome1[0] + 1 > newPalindrome2[1] - newPalindrome2[0] + 1) {
        if (newPalindrome1[1] - newPalindrome1[0] + 1 > longestPalindromeLen) {
          palindromeStart = newPalindrome1[0];
          palindromeEnd = newPalindrome1[1];
          longestPalindromeLen = palindromeEnd - palindromeStart + 1;
        }
      } else {
        if (newPalindrome2[1] - newPalindrome2[0] + 1 > longestPalindromeLen) {
          palindromeStart = newPalindrome2[0];
          palindromeEnd = newPalindrome2[1];
          longestPalindromeLen = palindromeEnd - palindromeStart + 1;
        }
      }
    }
    return s.substring(palindromeStart, palindromeEnd + 1);
  }

  int[] checkPalindromeFromStartIndex(String s, int start, int end) {
    int[] palindromeIndices = new int[2];
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }
    palindromeIndices[0] = start + 1;
    palindromeIndices[1] = end - 1;
    return palindromeIndices;
  }
}
