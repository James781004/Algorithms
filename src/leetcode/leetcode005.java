package leetcode;

public class leetcode005 {

	// Given a string S, find the longest palindromic substring in S.
	// You may assume that the maximum length of S is 1000,
	// and there exists one unique longest palindromic substring.

	// basic version
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		String res = "";
		boolean[][] dp = new boolean[s.length()][s.length()];
		int max = 0;

		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i < j; i++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
				if (dp[i][j]) {
					if (j - i + 1 > max) {
						max = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res;
	}

	// Expand Around Center
	private int lo, maxLen;

	public String longestPalindrome2(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}

		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // assume odd length, try to extend Palindrome as possible
			extendPalindrome(s, i, i + 1); // assume even length.
		}
		return s.substring(lo, lo + maxLen);

	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
}
