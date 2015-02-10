/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * Tags: Backtracking. String
 */



public class Solution {
	public static void main(String[] args) {
	
	}

	/**
     * Backtracking
     */
    public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}	       
		helper(result, "", n, n);
		return result;
    }

    public void helper(List<String> result, String solution, int left, int right) {
    	if (left == 0 && right == 0) {
    		result.add(solution);
    		return;
    	}
    	if (left < 0 || right < 0 || left > right) {
    		return;
    	}
    	helper(result, solution + "(", left - 1, right);
    	helper(result, solution + ")", left, right - 1);
    }
}