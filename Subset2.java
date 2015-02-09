/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 
 * Tags: Array, Backtracking
 */




public class Solution {
	public static void main(String[] args) {
        int[] num = {1, 2, 2};
        subsetsWithDup(num);
    }



	/**
     * Backtrack to generate all subsets
     */
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
        	return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(num);
        rec(result, solution, num, 0);
        return result;
    }

    public void rec(List<List<Integer>> result, List<Integer> solution, int[] num, int pos) {
    	result.add(new ArrayList<Integer>(solution));
    	for (int i = pos; i < num.length; i++) {
    		if (i != pos && num[i] == num[i - 1]) {		// skip dups
    			continue;
    		}
    		solution.add(num[i]);
    		rec(result, solution, num, i + 1);
    		solution.remove(solution.size() - 1);
    	}
    }



}