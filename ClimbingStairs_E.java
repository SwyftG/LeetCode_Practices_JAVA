/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Tags: DP
 */

 public class Solution {
	public static void main(String[] args) {
        System.out.println(climbStairs(44));
        System.out.println(climbStairsBottomUp(44));
    }
    

    /**
    * Bottom-up approach
    * Remember the previous two solutions
    */
    public int climbStairs(int n) {
    	int cur = 0;
    	int prev = 1; 
    	int tmp;
    	for (int i = 0; i < n; i++) {
    		tmp = cur;
    		cur = prev + cur;
    		prev = tmp;
    	}
    	return cur;
    }
}