/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * Tags: Array, Binary Search
 */

 public class Solution {
 	public static void main(String[] args) {
 	
 	}

 	public boolean search(int[] A, int target) {
 		if (A == null || A.length == 0) {
 			return false;
 		}
 		int start = 0;
 		int end = A.length - 1;
 		int mid;
 		while (start + 1 < end) {
 			mid = start + (end - start) / 2;
 			if (A[mid] == target) {
 				return true;
 			} else if (A[start] < A[mid]) {
 				if (A[start] <= target && target < A[mid]) {
 					end = mid;
 				} else {
 					start = mid;
 				}
 			} else if (A[start] < A[mid]) {
 				if (A[mid] < target && target <= A[end]) {
 					start = mid;
 				} else {
 					end = mid;
 				}
 			} else {
 				start++;
 			}
 		}
 		if (A[start] == target) {
 			return true;
 		} else if (A[end] == target) {
 			return true;
 		} else {
 			return false;
 		}
 	}
 }