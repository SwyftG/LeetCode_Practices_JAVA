/**
 * Given a set of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C <strong>unlimited</strong>
 * number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * Tags: Backtracking
 */


public class Solution {
	public static void main(String[] args) {
		
	}

    /**
     * Bakctracking
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        if (candidates == null || candidates.length == 0) {
        	return result;
        }
        Arrays.sort(candidate);
        helper(result, solution, candidates, target, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> solution, int[] candidates, int target, int index) {
    	if (target == 0) {
    		result.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	int prev = -1;
    	for (int i = index; i < candidates.length; i++) {
    		if (candidates[i] > target) {
    			break;
    		}
    		solution.add(candidates[i]);
    		helper(result, solution, candidates, target - candidates[i], i);
    		solution.remove(solution.size() - 1);
    	}
    }
}