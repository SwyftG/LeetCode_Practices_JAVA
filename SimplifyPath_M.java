/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * Tags: Stack, String
 */


public class Solution {
 	public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }



    /** 
     * It likes the second solution.
     */
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
        	return null;
        }
        String result = "/";
        String[] subs = path.split("/");
        ArrayList<String> paths = new ArrayList<String>();
        for (String s : subs) {
        	if (s.equals("..")) {
        		if (paths.size() > 0) {
        			paths.remove(paths.size() - 1);
        		} 
        	}else if (!s.equals(".") && !s.equals("")) {
        			paths.add(s);
        	}
        }
        for (String s : paths) {
        	result = result + s + "/";
        }
        if (result.length() > 1) {
        	result = result.substring(0, result.length() - 1);
        }
        return result;
    }



    /**
     * Split words with /, use a stack to save directories
     * If ".", skip
     * If "..", check stack. If stack empty, skip; If not, pop
     * Else, push it to stack
     * Initialize result as "/" if stack is empty, otherwise as empty string
     * Go through stack and concatenate words
     * Return result
     */
    public String simplifyPath(String path) {
    	if (path == null || path.length() == 0) {
    		return null;
    	}
    	Stack<String> stack = new Stack<String>();
    	String[] subs = path.split("/");
    	for (String s : subs) {
    		if (s.length() == 0 || s.equals(".")) {
    			continue;
    		} 
    		if (s.equals("..")) {
    			if (stack.isEmpty()) {
    				continue;
    			} else {
    				stack.pop();
    			}
    		} else {
    			stack.push(s);
    		}
    	}
    	String result = stack.isEmpty() ? "/" : "";
    	for (String s : stack) {
    		result = result + "/" + s;
    	}
    	return result;
    }
}