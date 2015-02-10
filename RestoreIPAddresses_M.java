/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example:
 * 
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * Tags: Backtracking, String
 */


public class Solution {
	public static void main(String[] args) {
        restoreIPAddresses("25525511135");
        restoreIPAddresses("010010");
    }



	/**
     * Figure out what is a valid IP address
     * Use backtracking to insert dots into string
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<String> solution = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
        	return result;
        }
        helper(result, solution, s, 0);
        return result;
    }
    
    public void helper(List<String> result, List<String> solution, String s, int start) {
    	if (solution.size() == 4) {
    		if (start != s.length()) {
    			return;
    		}
    		StringBuffer sb = new StringBuffer();
    		for (String tmp : solution) {
    			sb.append(tmp);
    			sb.append(".");
    		}
    		sb.deleteCharAt(sb.length() - 1);
    		result.add(sb.toString());
    		return;
    	}
    	for (int i = start; i < s.length() && i <= start + 3; i++) {
    		String tmp = s.substring(start, i + 1);
    		if (isValid(tmp)) {
    			solution.add(tmp);
    			helper(result, solution, s, i + 1);
    			solution.remove(solution.size() - 1);
    		}
    	}
    }

    public boolean isValid(String tmp) {
    	if (tmp.charAt(0) == '0') {
    		return tmp.equals("0");
    	}
    	int digit = Integer.valueOf(tmp);
    	return digit >= 0 && digit <= 255;
    }
}