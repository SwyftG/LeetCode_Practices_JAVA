/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * Tags: BFS, Hashtable
 */



public class Solution {
	public static void main(String[] args) {
        String start = "hot";
        String end = "dog";
        Set<String> s = new HashSet<String>();
        s.add("hot");
        s.add("dog");
        s.add("dot");
        System.out.println(ladderLength(start, end, s));
    }



 	/**
     * BFS
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
        	return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1;
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		String current = queue.poll();
        		for (char c = 'a'; c <= 'z'; c++) {
        			for (int j = 0; j < current.length(); j++) {
        				if (c == current.charAt(j)) {
        					continue;
        				}
        				String tmp = replace(current, j, c);
        				if (tmp.equals(end)) {
        					return length + 1;
        				}
        				if (dict.contains(tmp)) {
        					queue.offer(tmp);
        					dict.remove(tmp);
        				}
        			}
        		}
        	}
        	length++;
        }
        return 0;
    }
    public String replace(String current, int j, char c) {
    	char[] chars = current.toCharArray();
    	chars[j] = c;
    	return new String(chars);
    }




    /**
     * use queue to do BFS
     * use Map to record distance with word as key
     * if found end, return distance
     * else continue build queue
     */
    public int ladderLength(String start, String end, Set<String> dict) {
    	if (dict == null || dict.size() == 0) {
    		return 0;
    	}
    	dict.add(end);
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	map.put(start, 1);
    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(start);
    	while (!queue.isEmpty()) {
    		String word = queue.poll();
    		if (word.equals(end)) {
    			break;
    		}
    		for (int i = 0; i < word.length(); i++) {
    			for (char c = 'a'; c <= 'z'; c++) {
    				char[] ch = word.toCharArray();
    				if (ch[i] == c) {
    					continue;
    				}
    				ch[i] = c;
    				String newWord = new String(ch);
    				if (dict.contains(newWord) && !map.containsKey(newWord)) {
    					map.put(newWord, map.get(word) + 1);
    					queue.add(newWord);
    				}
    			}
    		}
    	}
    	return map.containsKey(end) ? map.get(end) : 0;
    }

}