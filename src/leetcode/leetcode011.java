package leetcode;

public class leetcode011 {

	// Given n non-negative integers a1, a2, ..., an , where each represents a point
	// at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
	// of line i is at (i, ai) and (i, 0). Find two lines, which together with
	// x-axis forms a container, such that the container contains the most water.
	//
	// Note: You may not slant the container and n is at least 2.

	public int maxArea(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			// r - l as length we need
			// find the smaller one between height[l] and height[r],
			// in order to prevent water leakage
			// save Math.min(height[l], height[r]) * (r - l) in maxarea
			// compare current maxarea with next Math.min(height[l], height[r]) * (r - l)
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxarea;
	}
}
