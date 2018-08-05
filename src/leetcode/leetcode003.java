package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode003 {

	// Given a string, find the length of the longest substring without repeating
	// characters.
	// For example, the longest substring without repeating letters for "abcabcbb"
	// is "abc", which the length is 3.
	// For "bbbbb" the longest substring is "b", with the length of 1.

	public int lengthOfLongestSubstring(String s) {

		// check null
		if (s == null || s.length() == 0)
			return 0;

		// HashMap to put key & value
		HashMap<Character, Integer> map = new HashMap<>();

		// initializing result
		int result = 0;

		// i as current position in map
		// j as starting position of substring (which would change when there's a repeat
		// character in map)
		for (int i = 0, j = 0; i < s.length(); i++) {

			// if we found a repeat character
			if (map.containsKey(s.charAt(i))) {

				// reset j
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}

			// put key & value
			map.put(s.charAt(i), i);

			// find out the length
			result = Math.max(result, i - j + 1);
		}

		return result;
	}

	// HashSet method
	public int lengthOfLongestSubstring3(String s) {

		// check null
		if (s == null || s.length() == 0) {
			return 0;
		}

		// HashSet to add value
		HashSet<Character> mySet = new HashSet<>();
		int length = 0;
		int start = 0;
		int end = 0;
		while (start < s.length() && end < s.length()) {
			if (mySet.contains(s.charAt(end))) {
				mySet.remove(s.charAt(start));
				start++;
			} else {
				mySet.add(s.charAt(end));
				length = Math.max(length, end - start + 1);
				end++;
			}
		}
		return length;
	}

}
