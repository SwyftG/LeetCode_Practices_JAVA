/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * Tags: Divide and Conquer, Array, Binary Search
 */

 public class Solution {
 	public static void main(String[] args) {
 		Solution median = new Solution();
 		int[] A = {1, 2, 3, 4, 5};
 		int[] B = {2, 4, 6, 8, 10};
 		System.out.println(median.findMedianSortedArrays(A, B));
 	}
 	
 	
 	public double findMedianSortedArrays(int[] A, int[] B) {
 		int len = A.length + B.length;
 		if (len % 2 == 0) {
 			return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
 		} else {
 			return findKth(A, 0, B, 0, len / 2 + 1);
 		}
 	}

 	public double findKth(int[] A, int Astart, int[] B, int Bstart, int k) {
 		if (Astart >= A.length) {
 			return B[Bstart + k - 1];
 		}
 		if (Bstart >= B.length) {
 			return A[Astart + k - 1];
 		}
 		if (k == 1) {
 			return Math.min(A[Astart], B[Bstart]);
 		}
 		int Akey = Astart + k / 2 - 1 < A.length ? A[Astart + k / 2 - 1] : Integer.MAX_VALUE;
 		int Bkey = Bstart + k / 2 - 1 < B.length ? B[Bstart + k / 2 - 1] : Integer.MAX_VALUE;
 		if (Akey > Bkey) {
 			return findKth(A, Astart, B, Bstart + k / 2, k - k / 2);
 		} else {
 			return findKth(A, Astart + k / 2, B, Bstart, k - k / 2);
 		}
 	}
 }