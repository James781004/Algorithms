package leetcode;

import java.util.HashMap;

public class leetcode001 {

	// Given an array of integers, return indices of the two numbers such that they
	// add up to a specific target.
	//
	// You may assume that each input would have exactly one solution, and you may
	// not use the same element twice.
	//
	// Example:
	//
	// Given nums = [2, 7, 11, 15], target = 9,
	//
	// Because nums[0] + nums[1] = 2 + 7 = 9,
	// return [0, 1].

	public static int[] twoSum(int[] nums, int target) {

		// check if array contains nothing or only one integer
		if (nums == null || nums.length < 2) {
			return new int[] { -1, -1 };
		}

		// initializing a new array to save answer
		int[] res = new int[] { -1, -1 };

		// initializing a new HashMap to keep key and value
		HashMap<Integer, Integer> map = new HashMap<>();

		// finding out the target in the HashMap
		for (int i = 0; i < nums.length; i++) {

			// target = 9, if 9 - 2 = 7 exist
			if (map.containsKey(target - nums[i])) {

				// save 7
				res[0] = map.get(target - nums[i]);

				// save 2
				res[1] = i;
				break;
			}

			// save nums in HashMap
			map.put(nums[i], i);
		}

		return res;
	}

}
