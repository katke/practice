package leetcode.practice;

import shared.PracticeStatus;

public class BestTimeToBuySellStock {
  String source = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/";
  PracticeStatus practiceStatus = PracticeStatus.ACCEPTED;
  String timeComplexity = "O(N)";
  String spaceComplexity = "O(1)";
  /*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different
day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
*/

  int solution(int[] prices) {
    if (prices == null || prices.length < 2) return 0;
    int maxProfit = 0;
    var minBuyPrice = Integer.MAX_VALUE;
    for (int price : prices) {
      if (minBuyPrice > price) {
        minBuyPrice = price;
      } else if (price - minBuyPrice > maxProfit) {
        maxProfit = price - minBuyPrice;
      }
    }
    return maxProfit;
  }

  int bruteForceSolution(int[] prices) {
    if (prices == null || prices.length < 2) return 0;
    var maxProfit = Integer.MIN_VALUE;
    var sell = 1;
    for (int buy = 0; buy < prices.length - 1; buy++) {
      while (sell < prices.length) {
        maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
        sell++;
      }
      sell = buy + 1;
    }
    return Math.max(maxProfit, 0);
  }
}
