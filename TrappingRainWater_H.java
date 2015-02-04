/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1], return 6.
 * 
 * Tags: Array, Stack, Two pointers
 */

 public class Solution {
 	public static void main(String[] args) {

 	}

 	/**
 	 * First find the MAX value in the array, use "index" to store its index
 	 * caculate left side
 	 * caculate right side
 	 */
    public int trap(int[] A) {
 		
 		int index = -1;
 		int max = -1;
 		int sum = 0;
 		int prev;
 		for (int i = 0; i < A.length; i++) {
 			if (A[i] > max) {
 				index = i;
 				max = A[i]; 
 			}
 		}
 		prev = 0;
 		for (int i = 0; i < index; i++) {
 			if (A[i] > prev) {
 				sum = sum + (A[i] - prev) * (index - i);
 				prev = A[i];
 			}
 			sum = sum - A[i];
 		}
 		prev = 0;
 		for (int i = A.length - 1; i > index; i--) {
 			if (A[i] > prev) {
 				sum = sum + (A[i] - prev) * (i - index);
 				prev = A[i];
 			}
 			sum = sum - A[i];
 		}
 		return sum;
    }
}