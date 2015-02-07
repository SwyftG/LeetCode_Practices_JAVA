/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 *
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 *
 * Tags: Array, Stack
 */



public class Solution {
	public static void main(String[] args) {
        int[] height = { 2, 1, 5, 6, 2, 3 };
        int[] height2 = { 1, 2, 3, 4, 5, 6 };
        System.out.println(new LargestRectangleInHist().largestRectangleArea(height2));
    }



	/**
     * Only height is smaller do update happens
     * Stack for indices
     * add a zero height into the group
     */
    public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}        
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i <= height.length; i++) {
			int cur = (i == height.length) ? 0 : height[i];
			while (!stack.isEmpty() && cur <= height[stack.peek()]) {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.push(i);
		}
		return max;
    }
}