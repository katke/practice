package educative.interviewrecursion;

import shared.PracticeStatus;

public class IsPrimeNumber {
  String source = "https://www.educative.io/courses/recursion-for-coding-interviews-in-java/xll1j810xB3";
  String timeComplexity = "O(sqrt(n))";
  String spaceComplexity = "O(sqrt(n))";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;

  boolean solution(int num) {
    if (num != 2 && num % 2 == 0) return false;
    return isPrime((int) Math.sqrt(num), num);
  }

  boolean isPrime(int divisor, int ogNum) {
    if (divisor <= 1) return true;
    else if (ogNum % divisor == 0) {
      return false;
    }
    return isPrime(divisor - 1, ogNum);
  }
}
