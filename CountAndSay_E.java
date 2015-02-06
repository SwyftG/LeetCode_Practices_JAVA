/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * Tags: String
 */


public class Solution {
	public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }


    public String countAndSay(int n) {
        String oldstring = "1";
        int k = 0;
        while (k < (n - 1)) {
        	StringBuffer sb = new StringBuffer();
        	char[] oldchars = oldstring.toCharArray();
        	for (int i = 0; i < oldchars.length; i++) {
        		int count = 1;
        		while ((i + 1) < oldchars.length && oldchars[i] == oldchars[i + 1]) {
        			count++;
        			i++;
        		} 
        		sb.append(String.valueOf(count) + String.valueOf(oldchars[i]));
        	}
        	oldstring = sb.toString();
        	k++;
        }
        return oldstring;
    }
}