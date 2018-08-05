package leetcode;

public class leetcode014 {

	// Write a function to find the longest common prefix string amongst an array of
	// strings.
	//
	// If there is no common prefix, return an empty string "".
	//
	// Example 1:
	//
	// Input: ["flower","flow","flight"]
	// Output: "fl"
	// Example 2:
	//
	// Input: ["dog","racecar","car"]
	// Output: ""
	// Explanation: There is no common prefix among the input strings.
	// Note:
	//
	// All given inputs are in lowercase letters a-z.

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		// get first element in strs
		String res = strs[0];

		// Input: ["flower","flow","flight"]
		// res = "flower" compares with strs[1]
		// res = "flower" --> not zero, not found in flow, so minus 1
		// res = "flowe" --> not zero, not found in flow, so minus 1
		// res = "flow" --> found, next loop
		// res = "flow" ompares with strs[2]
		// res = "flow" --> not zero, not found in flight, so minus 1
		// res = "flo" --> not zero, not found in flight, so minus 1
		// res = "fl" --> found, return
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(res) != 0) {
				res = res.substring(0, res.length() - 1);
			}
		}
		return res;

	}
}
