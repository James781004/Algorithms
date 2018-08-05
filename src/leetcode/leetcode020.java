package leetcode;

import java.util.Stack;

public class leetcode020 {

	// Given a string containing just the characters '(', ')', '{', '}', '[' and
	// ']', determine if the input string is valid.
	//
	// An input string is valid if:
	//
	// Open brackets must be closed by the same type of brackets.
	// Open brackets must be closed in the correct order.
	// Note that an empty string is also considered valid.
	//
	// Example 1:
	//
	// Input: "()"
	// Output: true
	// Example 2:
	//
	// Input: "()[]{}"
	// Output: true
	// Example 3:
	//
	// Input: "(]"
	// Output: false
	// Example 4:
	//
	// Input: "([)]"
	// Output: false
	// Example 5:
	//
	// Input: "{[]}"
	// Output: true

	public boolean isValid(String s) {
		if (s.length() == 0 || s == null) {
			return true;
		}
		// FILO
		Stack<Character> stack = new Stack<>();
		// ex: ()
		// '('
		// 1. stack.push(')');
		// '(' has become ')'
		// ')'
		// not in the if case, go else
		// stack.pop() = ')'
		// true
		for (Character ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(')');
			} else if (ch == '[') {
				stack.push(']');
			} else if (ch == '{') {
				stack.push('}');
			} else {
				if (stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}
		}

		// popped over
		return stack.isEmpty();
	}
}
