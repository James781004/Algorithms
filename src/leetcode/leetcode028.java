package leetcode;

public class leetcode028 {
	// Implement strStr().
	//
	// Return the index of the first occurrence of needle in haystack, or -1 if
	// needle is not part of haystack.
	//
	// Example 1:
	//
	// Input: haystack = "hello", needle = "ll"
	// Output: 2
	// Example 2:
	//
	// Input: haystack = "aaaaa", needle = "bba"
	// Output: -1

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;

		// finding "needle" inside "haystack"
		// max length for start point should be haystack.length() - needle.length()
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}

		}
		return -1;
	}
}
