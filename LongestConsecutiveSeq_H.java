/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its
 * length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Tags: Array, HashTable
 */

 public class Solution {
 	public static void main(String[] args) {
 		int[] A = {100, 4, 200, 1, 3, 2};
 		System.out.println(longestConsecutive(A));
 	}


    public int longestConsecutive(int[] num) {
 		if (num == null || num.length == 0) {
 			return 0;
 		}
 		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
 		for (int i : num) {
 			map.put(i, 0);
 		}
 		int longest = 0;
 		for (int i : num) {
 			if (map.get(i) == 1) {
 				continue;
 			}
 			int length = 1;
 			int tmp = i;
 			while (map.containsKey(tmp + 1)) {
 				map.put(tmp + 1, 1);
 				length++;
 				tmp++;
 			}
 			tmp = i; 
 			while (map.containsKey(tmp - 1)) {
 				map.put(tmp - 1, 1);
 				length++;
 				tmp--;
 			}
 			longest = Math.max(longest, length);
 		}
 		return longest;
    }
}