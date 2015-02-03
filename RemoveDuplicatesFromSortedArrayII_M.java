/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * Tags: Array, Two pointers
 */

 public class Solution {
 	public int removeDuplicates(int[] A) {
 		if (A == null || A.length == 0) {
 			return 0;
 		}
 		int index = 0;
 		int count = 1;
 		for (int i = 1; i < A.length; i++) {
 			if (A[index] == A[i]) {
 				if (count < 2) {		// If dumplicate are allowed at most N time, "count < N"
 					count++;
 					A[++index] = A[i];
 				}
 			} else {
 				count = 1;
 				A[++index] = A[i];
 			}
 		}
 		return index + 1;
 	}

 	public static void main(String[] args) {
 		
 	}
 }