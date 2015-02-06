/**
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to 
 * ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Tags: Two pointers, String
 */


public class Solution {
 	public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


    /**
     * two pointers
     */ 
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
        	return true;
        }
        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
        	while (front < s.length() && !isValid(s.charAt(front))) {
        		front++;
        	}
        	if (front == s.length()) {
        		return true;
        	}
        	while (end >= 0 && !isValid(s.charAt(end))) {
        		end--;
        	}
        	if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
        		return false;
        	} else {
        		front++;
        		end--;
        	}
        }
        return end <= front;
    }
    public boolean isValid(char c) {
    	return Character.isDigit(c) || Character.isLetter(c);
    }




    /**
     * Put letters and numbers in a new string and convert to lowercase
     * O(2n) Time, O(n) Space
     */
    public boolean isPalindrome(String s) {
    	StringBuffer sb = new StringBuffer();
    	for (char c : s.toCharArray()) {
    		if (Character.isLetterOrDigit(c)) {
    			sb.append(c);
    		}
    	}
    	String copy = sb.toString().toLowerCase();
    	int len = copy.length();
    	for (int i = 0; i < len / 2; i++) {
    		if (copy.charAt(i) != copy.charAt(len - (i + 1))) {
    			return false;
    		}
    	}
    	return true;
    }
}