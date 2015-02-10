/**
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Tags: Array, DP
 */



public class Solution {
	public static void main(String[] args) {
        int[] prices = { 1, 4, 2 };
        System.out.println(maxProfit(prices));
    }
    


    /**
     * O(n) Time, O(1) Space
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
        	min = Math.min(min, i);
        	profit = Math.max((i - min), profit);
        }
        return profit;
    }
}