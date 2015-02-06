/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all
 * valid but "(]" and "([)]" are not.
 * 
 * Tags: Stack, String
 */



public class Solution {
	 public static void main(String[] args) {
        ValidParenthese v = new ValidParenthese();
        System.out.println(v.isValid("()"));
        System.out.println(v.isValid("()[]{}"));
        System.out.println(v.isValid("([)]"));
        System.out.println(v.isValid("[({(())}[()])]"));
        System.out.println(v.isValid("a[a(a{a(a(.)a)a}x[a(a)v]w)q]z"));
    }




    /**
     * Use a stack to store the parens
     * If   left paren, push to stack
     * Elif stk is empty, return false
     * Elif mathches, pop and go on
     * Else don't match, return false
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
        	return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
        	if ("[{(".contains(String.valueOf(c))) {
        		stack.push(c);
        	} else {
        		if (!stack.isEmpty() && isValid(stack.peek(), c)) {
        			stack.pop();
        		} else {
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }
    public boolean isValid(char a, char b) {
    	return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}