/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * Tags: Array, Greedy
 */


public class Solution {
	public static void main(String[] args) {
        
    }



	/**
     * Use last to store how far we already can reach
     * If we run out of it, update and add 1 more step to result
     * Return if last is already bigger than or equal to the length
     * Use cur to store how far we can reach for the next step
     */
    public int jump(int[] A) {
        int step = 0;
        int left = 0;
        int right = 0;
        if (A == null || A.length == 0 || A.length == 1) {
        	return 0;
        }
        while (left <= right) {
        	step++;
        	int oldright = right;
        	for (int i = left; i <= oldright; i++) {
        		int newright = i + A[i];
        		if (newright >= A.length - 1) {
        			return step;
        		}
        		if (newright > right) {
        			right = newright;
        		}
        	}
        	left = oldright + 1;
        }
        return 0;
    }
}