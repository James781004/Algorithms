package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode015 {
	// Given an array nums of n integers, are there elements a, b, c in nums such
	// that a + b + c = 0? Find all unique triplets in the array which gives the sum
	// of zero.
	//
	// Note:
	//
	// The solution set must not contain duplicate triplets.
	//
	// Example:
	//
	// Given array nums = [-1, 0, 1, 2, -1, -4],
	//
	// A solution set is:
	// [
	// [-1, 0, 1],
	// [-1, -1, 2]
	// ]

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		if (nums == null || nums.length < 3)
			return res;

		int len = nums.length;

		// sort nums first!!!
		Arrays.sort(nums);

		// set up the first element at nums[i] and check the rest
		for (int i = 0; i < len; i++) {
			// avoid repeat
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			// find result from behind
			// set begin at nums[i + 1] --> second one
			int begin = i + 1;

			// set end at nums[len - 1] --> last one
			int end = len - 1;

			while (begin < end) {
				int sum = nums[i] + nums[begin] + nums[end];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[begin]);
					list.add(nums[end]);
					res.add(list);

					// got result, move begin and end
					begin++;
					end--;
					// avoid repeat!!!!
					while (begin < end && nums[begin] == nums[begin - 1]) {
						begin++;
					}
					// avoid repeat!!!!
					while (begin < end && nums[end] == nums[end + 1]) {
						end--;
					}

				} else if (sum > 0) {
					// too big, move end to the front
					end--;
				} else {
					// too small, move begin to the behind
					begin++;
				}
			}
		}
		return res;
	}
}
