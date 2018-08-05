package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode017 {

	// Given a string containing digits from 2-9 inclusive, return all possible
	// letter combinations that the number could represent.
	//
	// A mapping of digit to letters (just like on the telephone buttons) is given
	// below. Note that 1 does not map to any letters.

	// Example:
	//
	// Input: "23"
	// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	// Note:
	//
	// Although the above answer is in lexicographical order, your answer could be
	// in any order you want.

	public List<String> letterCombinations(String digits) {

		// check null
		if (digits.length() == 0) {
			return new ArrayList<String>();
		}

		// letters on each buttons
		String[] d = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> ans = new ArrayList<>();
		ans.add("");
		for (char digit : digits.toCharArray()) {

			// list to keep current result
			List<String> tmp = new ArrayList<>();
			for (String t : ans) {
				// add letters into s
				String s = d[Character.getNumericValue(digit)];
				// loop through s
				for (int i = 0; i < s.length(); ++i)
					// add each character into tmp
					tmp.add(t + s.charAt(i));
			}
			ans = tmp;
		}

		return ans;
	}

}
