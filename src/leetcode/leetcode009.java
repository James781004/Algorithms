package leetcode;

public class leetcode009 {

	// Determine whether an integer is a palindrome. An integer is a palindrome when
	// it reads the same backward as forward.

	public boolean isPalindrome(int x) {
		if (x < 0 || x != 0 && x % 10 == 0)
			return false;
		int target = x;
		int result = 0;

		// ex: x = 121
		// result = 0
		// result --> 0 * 10 + 121 % 10 = 1
		// x: 121 /= 10 ---> 12
		// result = 1
		// result --> 1 * 10 + 12 % 10 = 12
		// x: 12 /= 10 ---> 1
		// result = 12
		// result --> 12 * 10 + 1 % 10 = 121
		// x: 1 /= 10 ---> 0
		while (x > 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}

		return result == target;
	}
}
