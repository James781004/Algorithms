package leetcode;

public class leetcode008 {

	// Implement atoi which converts a string to an integer.
	//
	// The function first discards as many whitespace characters as necessary until
	// the first non-whitespace character is found. Then, starting from this
	// character, takes an optional initial plus or minus sign followed by as many
	// numerical digits as possible, and interprets them as a numerical value.
	//
	// The string can contain additional characters after those that form the
	// integral number, which are ignored and have no effect on the behavior of this
	// function.
	//
	// If the first sequence of non-whitespace characters in str is not a valid
	// integral number, or if no such sequence exists because either str is empty or
	// it contains only whitespace characters, no conversion is performed.
	//
	// If no valid conversion could be performed, a zero value is returned.
	//
	// Note:
	//
	// Only the space character ' ' is considered as whitespace character.
	// Assume we are dealing with an environment which could only store integers
	// within the 32-bit signed integer range: [−231, 231 − 1]. If the numerical
	// value is out of the range of representable values, INT_MAX (231 − 1) or
	// INT_MIN (−231) is returned.

	public int myAtoi(String str) {
		int index = 0;
		int total = 0;
		int sign = 1;

		// Check if empty string
		if (str.length() == 0)
			return 0;

		// remove white spaces from the string
		while (index < str.length() && str.charAt(index) == ' ')
			index++;

		if (index == str.length())
			return 0;

		// get the sign
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
			index++;
		}

		// convert to the actual number and make sure it's not overflow
		while (index < str.length()) {
			int digit = str.charAt(index) - '0';
			if (digit < 0 || digit > 9)
				break;

			// check for overflow
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = total * 10 + digit;
			index++; // don't forget to increment the counter
		}
		return total * sign;
	}

	// for reference
	public int myAtoi2(String str) {

		str = str.trim(); // remove empty

		// check null
		if (str == null || str.length() == 0)
			return 0;

		int sign = 1; // + or -
		int start = 0; // pointer
		long res = 0;
		if (str.charAt(0) == '+') {
			sign = 1;
			start++;
		} else if (str.charAt(0) == '-') {
			sign = -1;
			start++;
		}

		// convert to integer
		for (int i = start; i < str.length(); i++) {

			// non-digit case checking
			if (!Character.isDigit(str.charAt(i))) {
				return (int) res * sign;
			}

			// ex:12
			// str.charAt(0) == 1
			// res --> 0 * 10 + 1 = 1
			// str.charAt(1) == 2
			// res --> 1 * 10 + 2 = 12
			// 12 * sign
			// don't forget to check the overflow cases
			res = res * 10 + str.charAt(i) - '0';
			if (sign == 1 && res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && res > Integer.MAX_VALUE)
				return Integer.MIN_VALUE;
		}
		return (int) res * sign;
	}
}
