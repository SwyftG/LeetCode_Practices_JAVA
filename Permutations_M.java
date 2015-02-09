/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Tags: Backtracking
 */


public class Solution {
	public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 3, 2}));
    }

    


    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
        	return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(num);
        rec(result, solution, num);
        return result;
    }
    public void rec(List<List<Integer>> result, List<Integer> solution, int[] num) {
    	if (solution.size() == num.length) {
    		result.add(new ArrayList<Integer>(solution));
    		return;
    	}
    	for (int i = 0; i < num.length; i++) {
    		if (solution.contains(num[i])) {
    			continue;
    		}
    		solution.add(num[i]);
    		rec(result, solution, num);
    		solution.remove(solution.size() - 1);
    	}
    }
}