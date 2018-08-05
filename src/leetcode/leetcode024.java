package leetcode;

public class leetcode024 {
	// Given a linked list, swap every two adjacent nodes and return its head.
	//
	// Example:
	//
	// Given 1->2->3->4, you should return the list as 2->1->4->3.

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}

	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode l1 = dummy;
		ListNode l2 = head;

		// (l1)->1(l2)->2->3(NS)->4
		while (l2 != null && l2.next != null) {
			ListNode nextStart = l2.next.next;
			// (l1)->1(l2)->2(l1.next)->3(NS)->4
			l1.next = l2.next;
			// (l1)->1(l2)(l2.next.next)->2(l1.next)->3(NS)->4
			l2.next.next = l2;
			// (l1)->1(l2)(l2.next.next)->2(l1.next)->3(NS)(l2.next)->4
			// (l1)->2->1->3->4
			l2.next = nextStart;
			// 2->1(l1 new)->3(l2 new)->4
			l1 = l2;
			l2 = l2.next;
		}
		return dummy.next;
	}

	// for reference
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;
		// 0(current)->1->2->3->4
		while (current.next != null && current.next.next != null) {
			ListNode first = current.next; // 1
			ListNode second = current.next.next; // 2
			first.next = second.next; // 3
			// current->1->2 ==> current->2->2
			current.next = second;
			// current->2->2 ==> current->2->1
			current.next.next = first;
			// 2->1(current)->3->4 ==> another loop
			current = current.next.next;
		}
		return dummy.next;
	}
}
