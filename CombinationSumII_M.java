/**
 * Given a collection of candidate numbers (C) and a target number (T), find
 * all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used <strong>once</strong> in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * 
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * Tags: Array, Backtracking
 */



public class Solution {
	public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int tar = 8;
        List<List<Integer>> solution = new CombinationSum2().combinationSum2(candidates, tar);
        for (List<Integer> l : solution) {
        	System.out.println(l.toString());	
        }
    }



    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        if (num == null || num.length == 0) {
        	return result;
        }
        Arrays.sort(num);
        helper(result, solution, num, target, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> solution, int[] num, int target, int index) {
    	if (target == 0) {
    		result.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	int prev = -1;
    	for (int i = index; i < num.length; i++) {
    		if (num[i] > target) {
    			break;
    		}
    		if (prev != -1 && prev == num[i]) {
    			continue;
    		}
    		solution.add(num[i]);
    		helper(result, solution, num, target - num[i], i + 1);
    		solution.remove(solution.size() - 1);
    		prev = num[i];
    	}
    }
}