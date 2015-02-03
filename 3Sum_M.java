/**
 * Given an array S of n integers, are there elements a, b, c in S such that a
 * + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in <strong>non-descending</strong>
 * order.
 * (ie, a ≤ b ≤ c)
 * The solution set must not contain <strong>duplicate</strong> triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * Tags: Array, Two Pointers
 */

 public class Solution {
 	public static void main(String[] args) {
 		Solution t = new Solution();
 		int[] s = {-1, 0, 1, 2, -1, -2};
 		t.printResult(threeSum(s));
 	}


    public List<List<Integer>> threeSum(int[] num) {
 		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		if (num == null || num.length < 3) {
 			return result;
 		}       
 		Arrays.sort(num);
 		for (int i = 0; i < num.length; i++) {
 			if (i != 0 && num[i] == num[i - 1]) {
 				continue;
 			}
 			int left = i + 1;
 			int right = num.length - 1;
 			while (left < right) {
 				int sum = num[i] + num[left] + num[right];
 				if (sum == 0) {
 					List<Integer> tmp = new ArrayList<Integer>();
 					tmp.add(num[i]);
 					tmp.add(num[left]);
 					tmp.add(num[right]);
 					result.add(tmp);
 					left++;
 					right--;
 					while (left < right && num[left] == num[left - 1]) {
 						left++;
 					}
 					while (left < right && num[right] == num[right + 1]) {
 						right--;
 					}
 				} else if (sum > 0) {
 					right--;
 				} else {
 					left++;
 				}
 			}
 		}
 		return result;
    }

    public static void printResult(List<List<Integer>> result) {
    	for (List<Integer> l : result) {
    		System.out.print("{");
    		for (int i : l) {
    			System.out.print(i + ", ");
    		}
    		System.out.print("}");
    	}
    }
}