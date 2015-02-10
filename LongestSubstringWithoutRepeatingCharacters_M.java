/**
 * Given a string, find the length of the longest substring without repeating characters. For 
 * example, the longest substring without repeating letters for "abcabcbb" is "abc", which the 
 * length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */



public class Solution {
	public static void main(String[] args) {

	}



    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int leftbound = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
        	if (set.contains(s.charAt(i))) {
        		while (leftbound < i && s.charAt(i) != s.charAt(leftbound)) {
        			set.remove(s.charAt(leftbound));
        			leftbound++;
        		}
        		leftbound++;
        	} else {
        		set.add(s.charAt(i));
        		max = Math.max(max, i - leftbound + 1);
        	}
        }
        return max;
    }
}