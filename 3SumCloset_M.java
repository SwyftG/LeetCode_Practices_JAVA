/**
 * Given an array S of n integers, find three integers in S such that the 
 * sum is closest to a given number, target. Return the sum of the three 
 * integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Tags: Arrays, Two pointers
 */

 public class Solution {
 	public static void main(String[] args) {
 		
 	}
 	/**
     * Sort and initialize min
     * use two pointers to manipulate sums
     * update min when closer
     * return when min equals to target or all done
     */

    public int threeSumClosest(int[] num, int target) {
 		if (num == null || num.length < 3) {
 			return Integer.MAX_VALUE;
 		}
 		int closed = Integer.MAX_VALUE / 2;
 		Arrays.sort(num);
 		for (int i = 0; i < num.length; i++) {
 			int left = i + 1;
 			int right = num.length - 1;
 			while (left < right) {
 				int sum = num[i] + num[left] + num[right];
 				if (sum == target) {
 					return sum;
 				} else if (sum > target) {
 					right--;
 				} else {
 					left++;
 				}
 				closed = Math.abs(sum - target) < Math.abs(closed - target) ? sum : closed;
 			}
 		}
 		return closed;
    }
}