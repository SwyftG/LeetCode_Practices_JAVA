/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 * Tags: Math, String
 */


public class Solution {
 	public static void main(String[] args) {
        
    }

    /**
     * Whitespace, +, -, digit, ., e
     */
    public boolean isNumber(String s) {
    	String str = s.trim();
        if (str == null || str.length() == 0) {
        	return false;
        }
        int front = 0;
        int len = str.length();
        int end = len - 1;
        if (str.charAt(front) == '+' || str.charAt(front) == '-') {
        	front++;
        }
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (front <= end) {
        	char c = str.charAt(front);
        	if (Character.isDigit(c)) {
        		num = true;
        	} else if (c == '.') {
        		if (exp || dot) {
        			return false;
        		}
        		dot = true;
        	} else if (c == 'e') {
        		if (exp || num == false) {
        			return false;
        		}
        		exp = true;
        		num = false;
        	} else if (c == '+' || c == '-') {
        		if (str.charAt(front - 1) != 'e') {
        			return false;
        		}
        	} else {
        		return false;
        	} 
        	front++;
        }
        return num;
    }
}