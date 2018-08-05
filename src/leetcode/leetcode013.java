package leetcode;

public class leetcode013 {
	/*
	 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
	 * and M.
	 * 
	 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, two is written
	 * as II in Roman numeral, just two one's added together. Twelve is written as,
	 * XII, which is simply X + II. The number twenty seven is written as XXVII,
	 * which is XX + V + II.
	 * 
	 * Roman numerals are usually written largest to smallest from left to right.
	 * However, the numeral for four is not IIII. Instead, the number four is
	 * written as IV. Because the one is before the five we subtract it making four.
	 * The same principle applies to the number nine, which is written as IX. There
	 * are six instances where subtraction is used:
	 * 
	 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
	 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
	 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
	 * integer. Input is guaranteed to be within the range from 1 to 3999.
	 */

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int result = toNum(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			// ex: IV
			// first loop: result = 1
			// second loop:
			// 5 > 1 ---> 5 - 1 = 4
			// another 1 is already add by result
			// therefore 4 minus 1 again!!!
			// finally: result = 1 + 3 = 4
			if (toNum(s.charAt(i)) > toNum(s.charAt(i - 1))) {
				result += toNum(s.charAt(i)) - 2 * toNum(s.charAt(i - 1));
			} else {
				result += toNum(s.charAt(i));
			}
		}
		return result;

	}

	public static int toNum(char c) {
		int res = 0;
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return res;
	}
}
