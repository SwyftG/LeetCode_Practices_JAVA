/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Tags: Math, String
 */


public class Solution {
	public static void main(String[] args){

	}


    public static final int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    


    /**
     * While loop
     */
    public String intToRoman(int num) {
        if (num <= 0) {
        	return null;
        }
        String result = "";
        int digit = 0;
        while (num > 0) {
        	int times = num / nums[digit];
        	num = num - times * nums[digits];
        	for (; times > 0; times--) {
        		result += symbols[digits];
        	}
        	digits++;
        }
        return result;
    }



    /**
     * Recursion
     * Go through the dict, if num >= dict, insert it to head
     * Pass rest of the integer to next recursion
     */
    public String intToRoman(int num) {
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] <= num) {
    			return symbols[i] + intToRoman(num - nums[i]);
    		}
    	}
    	return "";
    }
}