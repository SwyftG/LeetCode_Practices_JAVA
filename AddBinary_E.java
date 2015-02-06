/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * Tags: Math, String
 */


public class Solution {


    public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return null;
		}        
		if (a.length() < b.length()) {
			String tmp = a;
			a = b; 
			b = tmp;
		}
		int la = a.length() - 1;
		int lb = b.length() - 1;
		int carry = 0;
		String result = "";
		while (lb >= 0) {
			int sum = carry + (int)(a.charAt(la) - '0') + (int)(b.charAt(lb) - '0');
			result = String.valueOf(sum % 2) + result;
			carry = sum / 2;
			la--;
			lb--;
		}
		while (la >= 0) {
			int sum = carry + (int)(a.charAt(la) - '0');
			result = String.valueOf(sum % 2) + result;
			carry = sum / 2;
			la--;
		}
		if (carry != 0) {
			result = String.valueOf(carry) + result;
		}
		return result;
    }
}