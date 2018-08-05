package leetcode;

public class leetcode023 {

	// Merge k sorted linked lists and return it as one sorted list. Analyze and
	// describe its complexity.
	//
	// Example:
	//
	// Input:
	// [
	// 1->4->5,
	// 1->3->4,
	// 2->6
	// ]
	// Output: 1->1->2->3->4->4->5->6

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		return sort(lists, 0, lists.length - 1);
	}

	// divide and conquer
	public ListNode sort(ListNode[] lists, int lo, int hi) {
		if (lo >= hi) {
			return lists[lo];
		}

		int mid = (hi - lo) / 2 + lo;
		ListNode l1 = sort(lists, lo, mid);
		ListNode l2 = sort(lists, mid + 1, hi);
		return merge(l1, l2);
	}

	// This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

	// for reference
	public ListNode mergeKLists2(ListNode[] lists) {
		return mL(lists, 0, lists.length - 1);
	}

	private ListNode mL(ListNode[] lists, int l, int r) {
		if (r < l)
			return null;
		if (r == l)
			return lists[r];

		int mid = (l + r) / 2;
		ListNode a = mL(lists, l, mid), b = mL(lists, mid + 1, r);
		ListNode dmHead = new ListNode(0), cur = dmHead;
		while (a != null && b != null) {
			if (a.val < b.val) {
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		cur.next = (a != null) ? a : b;

		return dmHead.next;
	}
}
