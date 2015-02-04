/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 *
 * You are giving candies to these children subjected to the following
 * requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Tags: Greedy
 */

 public class Solution {
 	public static void main(String[] args) {
        
    }


    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
        	return 0;
        }
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
        	if (ratings[i] < ratings[i + 1]) {
        		count[i + 1] = count[i] + 1;
        	}
        }
        for (int i = n - 1; i >= 1; i--) {
        	if (ratings[i] < ratings[i - 1] && count[i - 1] <= count[i]) {
        		count[i - 1] = count[i] + 1;
        	}
        }
        for (int i = 0; i < n; i++) {
        	sum = sum + count[i];
        }
        return sum;
    }
}