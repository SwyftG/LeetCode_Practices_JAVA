/**
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 * 
 * Tags: Backtracking
 */



public class Solution {
	public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("aa"));
    }
    


    /**
     * Backtracking
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
        	return result;
        }
        List<String> solution = new ArrayList<String>();
        rec(result, solution, s, 0);
        return result;
    }
    public void rec(List<List<String>> result, List<String> solution, String s, int pos) {
    	if (pos == s.length()) {
    		result.add(new ArrayList<String>(solution));
    		return;
    	}
    	for (int i = pos + 1; i <= s.length(); i++) { // Key point
    		String pre = s.substring(pos, i);1
    		if (!isValid(pre)) {
    			continue;
    		}
    		solution.add(pre);
    		rec(result, solution, s, i);
    		solution.remove(solution.size() - 1);
    	}
    }
    public boolean isValid(String s) {
    	int start = 0;
    	int end = s.length() - 1;
    	while (start < end) {
    		if (s.charAt(start) != s.charAt(end)) {
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }
}