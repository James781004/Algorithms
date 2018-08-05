package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode022 {

	// Given n pairs of parentheses, write a function to generate all combinations
	// of well-formed parentheses.
	//
	// For example, given n = 3, a solution set is:
	//
	// [
	// "((()))",
	// "(()())",
	// "(())()",
	// "()(())",
	// "()()()"
	// ]

	// if (n > 0), n: 3 result: []

	// if (left > 0), left: 3 right: 3 prefix: result: []

	// if (left > 0), left: 2 right: 3 prefix: ( result: []

	// if (left > 0), left: 1 right: 3 prefix: (( result: []

	// if (left < right), left: 0 right: 3 prefix: ((( result: []

	// if (left < right), left: 0 right: 2 prefix: ((() result: []

	// if (left < right), left: 0 right: 1 prefix: ((()) result: []

	// if (left == 0 && right == 0), prefix: ((())) result: []

	// if (left < right), left: 1 right: 3 prefix: (( result: [((()))]

	// if (left > 0), left: 1 right: 2 prefix: (() result: [((()))]

	// if (left < right), left: 0 right: 2 prefix: (()( result: [((()))]

	// if (left < right), left: 0 right: 1 prefix: (()() result: [((()))]

	// if (left == 0 && right == 0), prefix: (()()) result: [((()))]

	// if (left < right), left: 1 right: 2 prefix: (() result: [((())), (()())]

	// if (left > 0), left: 1 right: 1 prefix: (()) result: [((())), (()())]

	// if (left < right), left: 0 right: 1 prefix: (())( result: [((())), (()())]

	// if (left == 0 && right == 0), prefix: (())() result: [((())), (()())]

	// if (left < right), left: 2 right: 3 prefix: ( result: [((())), (()()),
	// (())()]

	// if (left > 0), left: 2 right: 2 prefix: () result: [((())), (()()), (())()]

	// if (left > 0), left: 1 right: 2 prefix: ()( result: [((())), (()()), (())()]

	// if (left < right), left: 0 right: 2 prefix: ()(( result: [((())), (()()),
	// (())()]

	// if (left < right), left: 0 right: 1 prefix: ()(() result: [((())), (()()),
	// (())()]

	// if (left == 0 && right == 0), prefix: ()(()) result: [((())), (()()), (())()]

	// if (left < right), left: 1 right: 2 prefix: ()( result: [((())), (()()),
	// (())(), ()(())]

	// if (left > 0), left: 1 right: 1 prefix: ()() result: [((())), (()()), (())(),
	// ()(())]

	// if (left < right), left: 0 right: 1 prefix: ()()( result: [((())), (()()),
	// (())(), ()(())]

	// if (left == 0 && right == 0), prefix: ()()() result: [((())), (()()), (())(),
	// ()(())]

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) {
			return res;
		}
		helper(res, "", n, n);
		return res;
	}

	public static void helper(List<String> res, String s, int left, int right) {
		if (left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}
		// Has left Parenthesis
		if (left > 0) {
			helper(res, s + "(", left - 1, right);
		}
		// has more right Parenthesis
		if (right > 0) {
			helper(res, s + ")", left, right - 1);
		}
	}

}
