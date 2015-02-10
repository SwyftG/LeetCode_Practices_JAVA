/**
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most 
 * <strong>two</strong> transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * 
 * Tags: Array, DP
 */



public class Solution {
	public static void main(String[] args) {
        int[] prices = { 6, 1, 3, 2, 4, 7, 6, 10, 15 };
        System.out.println(maxProfit(prices));
    }


    
    /**
     * Goes forward to build single transaction max profit
     * Then goes backward to build max since day i profit
     * Find the max of the sum of these two
     */
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) {
    		return 0;
    	}
    	int[] left = new int[prices.length];
    	int[] right = new int[prices.length];
    	left[0] = 0;
    	int min = prices[0];
    	for (int i = 1; i < prices.length; i++) {
    		min = Math.min(min, prices[i]);
    		left[i] = Math.max(left[i - 1], prices[i] - min);
    	}
    	right[prices.length - 1] = 0;
    	int max = prices[prices.length - 1];
    	for (int i = prices.length - 2; i >= 0; i--) {
    		max = Math.max(max, prices[i]);
    		right[i] = Math.max(right[i + 1], max - prices[i]);
    	}
    	int profit = 0;
    	for (int i = 0; i < prices.length; i++) {
    		profit = Math.max(profit, right[i] + left[i]);
    	}
    	return profit;
    }
}