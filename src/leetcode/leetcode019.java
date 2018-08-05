package leetcode;

public class leetcode019 {

	// Given a linked list, remove the n-th node from the end of list and return its
	// head.
	//
	// Example:
	//
	// Given linked list: 1->2->3->4->5, and n = 2.
	//
	// After removing the second node from the end, the linked list becomes
	// 1->2->3->5.
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		// (0)->1->2->3->4->5
		ListNode dummy = new ListNode(0);
		ListNode fast = dummy;
		ListNode slow = dummy;
		// 0->(1)->2->3->4->5
		dummy.next = head;
		// Advances fast pointer so that the gap between fast and slow is n nodes
		// apart
		for (int i = 0; i <= n; i++) {
			// 0->1->2->(3)->4->5
			fast = fast.next;
		}
		// Move fast to the end, maintaining the gap
		// fast moved twice more than slow!!!
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummy.next;
	}
}
