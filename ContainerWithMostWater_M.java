/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container.
 * 
 * Tags: Array, Two pointers
 */



public class Solution {
	public static void main(String[] args) {
        
    }
   


    
    /**
     * 2 pointers, low and high
     * curArea = (high - low) * min(height[high], height[low])
     * maxArea = max(maxArea, curArea)
     * Move lower pointer towards center for the next loop
     * Stop when two pointers meet, cause one line can form a container
     * Different from block
     */
    public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}        
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left <= right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return max;
    }
}