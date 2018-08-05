package leetcode;

public class leetcode004 {

	/**
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)). Example 1: nums1 = [1, 3] nums2 = [2] The median is
	 * 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4] The median is (2 + 3)/2 = 2.5
	 * O(log(min(m,n)))
	 * 
	 */

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0, nums1Size = nums1.length; // setting pointer for first array
		int j = 0, nums2Size = nums2.length; // setting pointer for second array
		int total = nums1Size + nums2Size; // getting total elements in both arrays

		int mergeds1s2[] = new int[total]; // new array to store sorted elemented
		int k = 0;

		// merging both arrays into mergeds1s2 to get the final sorted array
		while (i < nums1Size && j < nums2Size) {

			if (nums1[i] < nums2[j]) {
				mergeds1s2[k] = nums1[i++];
			} else {
				mergeds1s2[k] = nums2[j++];
			}
			k++;
		}

		if (i == nums1Size) {
			while (j < nums2Size)
				mergeds1s2[k++] = nums2[j++];
		} else {
			while (i < nums1Size)
				mergeds1s2[k++] = nums1[i++];
		}

		// returning the median.
		if (k % 2 == 1)
			return mergeds1s2[k / 2];
		else
			return (mergeds1s2[k / 2] + mergeds1s2[k / 2 - 1]) / 2.0;

	}

}
