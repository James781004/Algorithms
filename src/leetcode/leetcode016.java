package leetcode;

import java.util.Arrays;

public class leetcode016 {

	// Given an array nums of n integers and an integer target, find three integers
	// in nums such that the sum is closest to target. Return the sum of the three
	// integers. You may assume that each input would have exactly one solution.
	//
	// Example:
	//
	// Given array nums = [-1, 2, 1, -4], and target = 1.
	//
	// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

	public int threeSumClosest(int[] nums, int target) {

		// sort first!!!
		Arrays.sort(nums);

		// initialize the result: first + second + last
		int result = nums[0] + nums[1] + nums[nums.length - 1];

		// we need at least 3 elements, end before nums.length - 2
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];

				// in a sorted array, always manipulate like this:
				// too big: move end to the front
				// too small: move start to the behind
				if (sum > target) {
					end--;
				} else {
					start++;
				}

				// find the closest one
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;

				}
			}
		}
		return result;
	}

}
