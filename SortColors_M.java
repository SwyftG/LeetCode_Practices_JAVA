/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * Tags: Array, Two Pointers, Sort
 */


public class Solution {
	 public static void main(String[] args) {
        // normal case
        int[] A = {0, 1, 0, 1, 2, 1, 0};
        // other test cases
        // int[] A = {1, 2, 0};
        // int[] A = {2};
        // int[] A = {2, 2};
        sortColors(A);
    }





    public void sortColors(int[] A) {
    	if (A == null || A.length <= 1) {
    		return;
    	}    
    	int start = 0;
    	int end = A.length - 1;
    	int i = 0;
    	while (i <= end) {
    		if (A[i] == 0) {
    			swap(A, i, start);
    			start++;
    			i++;
    		} else if (A[i] == 1) {
    			i++;
    		} else {
    			swap(A, i, end);
    			end--;
    		}
    	}
    }
    public void swap(int[] A, int i, int j) {
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
    }




    /**
     * two-pass count sorting
     */
    public void sortColors(int[] A) {
    	int red = 0;
    	int white = 0;
    	int blue = 0;
    	for (int i = 0; i < A.length; i++) {
    		if (A[i] == 0) {
    			red++;
    		} else if (A[i] == 1) {
    			white++;
    		} else {
    			blue++;
    		}
    	}
    	int i = 0;
    	while (i < red) {
    		A[i] = 0;
    		i++;
    	}
    	while (i < red + white) {
    		A[i] = 1;
    		i++;
    	}
    	while (i < red + white + blue) {
    		A[i] = 2;
    		i++;
    	}
    }
}