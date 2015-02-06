/**
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * Tags: String
 */


public class Solution {
	public static void main(String[] args) {
        
    }

    /**
     * Solution one:
     */
    public String longestCommonPrefix(String[] strs) {
 		if (strs == null || strs.length == 0) {
 			return "";
 		}       
 		String result = strs[0];
 		for (int i = 0; i < strs.length; i++) {
 			int j = 0;
 			while (j < result.length() && j < strs[i].length() && strs[i].charAt(j) == result.charAt(j)) {
 				j++;
 			}
 			result = result.substring(0, j);
 		}
 		return result;
    }



    /**
     * Solution two:
     * loop backwards and overwrite previous word with prefix
     */
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

    	for (int i = strs.length - 2; i >= 0; i--) {
    		strs[i] = commonPrefix(strs[i + 1], strs[i]);
    	}
    	return strs[0];
    }

    public String commonPrefix(String a, String b) {
    	StringBuffer sb = new StringBuffer();
    	int lenA = a.length();
    	int lenB = b.length();
    	int i = 0;
    	while ( i < lenA && i < lenB) {
    		if (a.charAt(i) == b.charAt(o)) {
    			sb.append(a.charAt(i));
    		} else {
    			break;
    		}
    		i++;
    	}
    	return sb.toString();
    }
}