/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * Tags: Backtracking
 */


public class Solution {
	 public static void main(String[] args) {
        
    }



    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
        	return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort(num);
        int[] visited = new int[num.length];
        rec(result, solution, num, visited);
        return result;
    }

    public void rec(List<List<Integer>> result, List<Integer> solution, int[] num, int[] visited) {
    	if (solution.size() == num.length) {
    		result.add(new ArrayList<Integer>(solution));
    	}
    	for (int i = 0; i < num.length; i++) {
    		if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)) {
    			continue;
    		}
    		solution.add(num[i]);
    		visited[i] = 1;
    		rec(result, solution, num, visited);
    		solution.remove(solution.size() - 1);
    		visited[i] = 0;
    	}
    }
}