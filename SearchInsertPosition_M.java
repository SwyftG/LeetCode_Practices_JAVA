/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * Tags: Array, Binary Search
 */


public class Solution {
	public static void main(String[] args) {
		
	}




	/**
	 * Binary search
	 */
	public int searchInsert(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		int mid;
		if (target < A[0]) {
			return 0;
		}
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}else if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[end] == target) {
			return end;
		} 
		if (A[end] < target) {
			return end + 1;
		}
		if (A[start] == target) {
			return start;
		}
		return start + 1;
	}




	/**
     * Binary search
     * r = m - 1, l = m + 1
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
        	return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start <= end) {
        	mid = start + (end - start) / 2;
        	if (A[mid] == target) {
        		end = mid;
        	} else if (A[mid] < target) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }
        return start;
    }
}