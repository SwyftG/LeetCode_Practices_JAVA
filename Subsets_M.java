/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * Tags: Array, Backtracking, Bit Manipulation
 */


public class Solution {
	public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> l : res) {
            System.out.println(l.toString());
        }
    }



  	/**
     * Remember the start position and do backtracking
     */
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
        	return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(S);
        rec(result, solution, S, 0);
        return result;
    }
    public void rec(List<List<Integer>> result, List<Integer> solution, int[] S, int pos) {
    	result.add(new ArrayList<Integer>(solution));
    	for (int i = pos; i < S.length; i++) {
    		solution.add(S[i]);
    		rec(result, solution, S, i + 1);
    		solution.remove(solution.size() - 1);
    	}
    }




    /**
     * Recursive down to two branches.
     */
    public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
        	return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(S);
        helper(result, solution, S, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> solution, int[] S, int start) {
    	if (start == S.length) {
    		result.add(solution);
    		return;
    	}  
    	List<Integer> copy = new ArrayList<Integer>(solution);
    	helper(result, solution, S, start + 1);
    	copy.add(S[start]);
    	helper(result, copy, S, start + 1);
    }
}